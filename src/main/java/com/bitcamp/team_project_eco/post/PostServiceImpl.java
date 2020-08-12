package com.bitcamp.team_project_eco.post;

import com.bitcamp.team_project_eco.user.User;
import com.bitcamp.team_project_eco.user.UserRepository;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

interface PostService extends JpaService<Post> {
    public void readCsv();

    void insertPost(NewPostVO newPost);

    void updatePost(Post post);

    Page<Post> pagingFindAll(Pageable page);

    Page<Post> popularSort(PageRequest of);

    Page<Post> recentSort(PageRequest of);

    Page<Post> allPostFindByCategory(String category, PageRequest of);
}

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository repository;
    private final UserRepository userRepository;
    public PostServiceImpl(PostRepository repository, EntityManager em, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Post> findById(String id) {
        return repository.findById(Integer.parseInt(id));
    }

    @Override
    public Iterable<Post> findAll() {
        return repository.findAll();
    }

    @Override
    public int count() {
        return (int) repository.count();
    }

    @Override
    public void delete(String id) {
        repository.delete(findById(id).orElse(new Post()));
    }

    @Override
    public boolean exists(String id) {
        return repository.existsById(Integer.parseInt(id));
    }

    @Override
    public void readCsv() {
        InputStream is = getClass().getResourceAsStream("/static/news.csv");
        try {
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
        Iterable<CSVRecord> csvRecords = csvParser.getRecords();
        for (CSVRecord csvRecord : csvRecords) {
            repository.save(new Post(
                    "이형태",
                    csvRecord.get(0),
                    csvRecord.get(1),
                    csvRecord.get(2),
                    csvRecord.get(3),
                    csvRecord.get(4),
                    0,
                    0,
                    "news",
                    userRepository.findById(Long.parseLong(csvRecord.get(5))).orElse(new User()), // user Entity
                    new ArrayList<>()));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertPost(NewPostVO object) {
        User u = object.user;
        Post np = new Post(object.userName, object.link, object.title, object.date, object.img,
                object.content, 0, 0, object.category, u, new ArrayList<>());
        repository.save(np);
    }

    @Override
    public void updatePost(Post post) {
    }

    @Override
    public Page<Post> pagingFindAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Post> popularSort(PageRequest of) {
        return repository.findAll(of);
    }

    @Override
    public Page<Post> recentSort(PageRequest of) {
        return repository.findAll(of);
    }

    @Override
    public Page<Post> allPostFindByCategory(String category, PageRequest of) {
        Pageable pageable = of;
        return repository.findByCategory(category, pageable);
    }
}