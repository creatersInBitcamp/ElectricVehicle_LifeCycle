package com.bitcamp.team_project_eco.bookmark;

import com.bitcamp.team_project_eco.utils.JpaService;
import com.bitcamp.team_project_eco.wishlist.Wishlist;
import org.springframework.stereotype.Service;

import java.util.Optional;

interface BookmarkService extends JpaService<Bookmark>{

    void insertBookmark(Bookmark bookmark);

    void updateBookmark(Bookmark bookmark);
}

@Service
public class BookmarkServiceImpl implements BookmarkService{
    private final BookmarkRepository bookmarkRepository;

    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @Override
    public Optional<Bookmark> findById(String id) {
        return bookmarkRepository.findById(Integer.parseInt(id));
    }

    @Override
    public Iterable<Bookmark> findAll() {
        return bookmarkRepository.findAll();
    }

    @Override
    public int count() {
        return (int) bookmarkRepository.count();
    }

    @Override
    public void delete(String id) {
        bookmarkRepository.delete(findById(id).orElse(new Bookmark()));
    }

    @Override
    public boolean exists(String id) {
        return bookmarkRepository.existsById(Integer.parseInt(id));
    }

    @Override
    public void insertBookmark(Bookmark bookmark) {
        bookmarkRepository.save(bookmark);
    }

    @Override
    public void updateBookmark(Bookmark bookmark) {

    }
}
