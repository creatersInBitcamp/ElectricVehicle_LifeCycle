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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

interface PostService extends JpaService<Post> {
    public void readCsv();

    void insertPost(NewPostVO newPost);

    void updatePost(NewPostVO upPost);

    Page<Post> popularSort(Pageable of);

    Page<Post> recentSort(PageRequest of);

    Page<Post> allPostFindByCategory(String category, int page);

    Page<Post> findBySearchWord(String category, String condition, String searchWord, Pageable page);

    Optional<Post> getOneById(String postId);

    boolean recommend(Long postId);
}

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository repository;
    private final UserRepository userRepository;
    public PostServiceImpl(PostRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Post> findById(String id) {
        return repository.findById(Long.parseLong(id));
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
        return repository.existsById(Long.parseLong(id));
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
                    "tedd911",
                    csvRecord.get(0),
                    csvRecord.get(1),
                    csvRecord.get(2),
                    csvRecord.get(3),
                    csvRecord.get(4),
                    0,
                    0,
                    "news",
                    userRepository.findById(Long.parseLong(csvRecord.get(5))).get(), // user Entity
                    new ArrayList<>())); // comment list
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
    public void updatePost(NewPostVO post) {
        User u = post.user;
        Post up = repository.findById(Long.parseLong(post.postId)).get();
        up.setTitle(post.title);
        up.setLink(post.link);
        up.setImg(post.img);
        up.setContent(post.content);
        repository.save(up);
    }

    @Override
    public Page<Post> popularSort(Pageable of) {
        return repository.findAll(of);
    }

    @Override
    public Page<Post> recentSort(PageRequest of) {
        return repository.findAll(of);
    }

    @Override
    public Page<Post> allPostFindByCategory(String category, int page) {
        Pageable pageable = PageRequest.of(page-1, 8);
        return repository.findByCategory(category, pageable);
    }

    @Override
    public Page<Post> findBySearchWord(String category, String condition, String searchWord, Pageable page) {
        switch (condition) {
            case "title": return repository.findByCategoryAndTitleLikeSearchWord(category, searchWord, page);
            case "userId": return repository.findByCategoryAndUserIdLikeSearchWord(category, searchWord, page);
            default: return repository.findByCategoryAndContentLikeSearchWord(category, searchWord, page);
        }
    }

    @Override
    public Optional<Post> getOneById(String postId) {
        Post sp = repository.findById(Long.parseLong(postId)).get();
        int h = sp.getHits() + 1;
        sp.setHits(h);
        repository.save(sp);
        return repository.findById(Long.parseLong(postId));
    }

    @Override
    public boolean recommend(Long postId) {
        try {
            Post p = repository.findById(postId).get();
            int r = p.getRecommendation() + 1;
            p.setRecommendation(r);
            repository.save(p);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}