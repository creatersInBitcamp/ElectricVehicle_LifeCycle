package com.bitcamp.team_project_eco.post;

import com.bitcamp.team_project_eco.utils.JpaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

interface PostService extends JpaService<Post> {
    public void readCsv();

    void insertPost(Post post);

    void updatePost(Post post);
}

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
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
                    csvRecord.get(0),
                    csvRecord.get(1),
                    csvRecord.get(2),
                    csvRecord.get(3),
                    csvRecord.get(4),
                    0,
                    0,
                    "News"
            ));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertPost(Post post) {
        repository.save(post);
    }

    @Override
    public void updatePost(Post post) {
//        int targetPostId = post.getPostId();
    }
}