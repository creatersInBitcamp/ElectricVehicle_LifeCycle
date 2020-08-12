package com.bitcamp.team_project_eco.bookmark;

import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import com.bitcamp.team_project_eco.chargingStation.ChargingStationRepository;
import com.bitcamp.team_project_eco.sights.Sights;
import com.bitcamp.team_project_eco.sights.SightsRepository;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

interface BookmarkService extends JpaService<Bookmark>{

    void insertBookmark(BookmarkVO id);

    void updateBookmark(BookmarkVO id);

    List<Object> findAllBookmark();
}

@Service
public class BookmarkServiceImpl implements BookmarkService{
    private final BookmarkRepository bookmarkRepository;
    private final ChargingStationRepository chargingStationRepository;
    private final SightsRepository sightsRepository;

    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository, ChargingStationRepository chargingStationRepository, SightsRepository sightsRepository) {
        this.bookmarkRepository = bookmarkRepository;
        this.chargingStationRepository = chargingStationRepository;
        this.sightsRepository = sightsRepository;
    }

    @Override
    public Optional<Bookmark> findById(String id) {
        return bookmarkRepository.findById(Long.valueOf(id));
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
        Long bookmarId;
        bookmarkRepository.delete(findById(id).orElse(new Bookmark()));
        System.out.println(findAll());
    }

    @Override
    public boolean exists(String id) {
        return bookmarkRepository.existsById(Long.valueOf(id));
    }

    @Override
    public void insertBookmark(BookmarkVO id) {
        Bookmark bookmark = new Bookmark();
        if(id.isCharging()){
            bookmark.setChargingStation(chargingStationRepository.findById(Long.valueOf(id.getId())).orElseThrow(() -> new NoSuchElementException("Chargingstation not found")));
            System.out.println(bookmark.toString());
            bookmarkRepository.save(bookmark);
        }else{
            bookmark.setSights(sightsRepository.findById(Long.valueOf(id.getId())).orElseThrow(() -> new NoSuchElementException("Sights not found")));
            System.out.println(bookmark.toString());
            bookmarkRepository.save(bookmark);
        }

    }

    @Override
    public void updateBookmark(BookmarkVO id) {

    }

    @Override
    public List<Object> findAllBookmark() {
        List<Object> list = new ArrayList<>();
        List<Object> bookmarkLists = new ArrayList<>();
        for (int i=0; i<count();i++){
            BookmarkList bookmark = new BookmarkList();
            bookmark.setId(bookmarkRepository.findAll().get(i).getBookmarkId());
            if(bookmarkRepository.findAll().get(i).getSights() != null){
                bookmark.setPlace(bookmarkRepository.findAll().get(i).getSights());
                list.add(bookmarkRepository.findAll().get(i).getSights());
            }else if(bookmarkRepository.findAll().get(i).getChargingStation() != null){
                bookmark.setPlace(bookmarkRepository.findAll().get(i).getChargingStation());
                list.add(bookmarkRepository.findAll().get(i).getChargingStation());
            }
            bookmarkLists.add(bookmark);
        }
        return bookmarkLists;
    }
}
