package com.bitcamp.team_project_eco.bookmark;

import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import com.bitcamp.team_project_eco.chargingStation.ChargingStationRepository;
import com.bitcamp.team_project_eco.sights.Sights;
import com.bitcamp.team_project_eco.sights.SightsRepository;
import com.bitcamp.team_project_eco.user.User;
import com.bitcamp.team_project_eco.user.UserRepository;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

interface BookmarkService extends JpaService<Bookmark>{

    void insertBookmark(BookmarkVO bookmarkVO);

    void updateBookmark(BookmarkVO bookmarkVO);

    void deleteBookmark(String bookmarkId);

    List<Object> findAllBookmark(String userId);
}

@Service
public class BookmarkServiceImpl implements BookmarkService{
    private final BookmarkRepository bookmarkRepository;
    private final ChargingStationRepository chargingStationRepository;
    private final SightsRepository sightsRepository;
    private final UserRepository userRepository;

    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository, ChargingStationRepository chargingStationRepository, SightsRepository sightsRepository, UserRepository userRepository) {
        this.bookmarkRepository = bookmarkRepository;
        this.chargingStationRepository = chargingStationRepository;
        this.sightsRepository = sightsRepository;
        this.userRepository = userRepository;
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
    public void insertBookmark(BookmarkVO bookmarkVO) {
        System.out.println(bookmarkVO.getUserSeq());
        User user = userRepository.findById(Long.valueOf(bookmarkVO.getUserSeq())).get();
        if(bookmarkVO.isCharging()){
            ChargingStation c = chargingStationRepository.findById(Long.valueOf(bookmarkVO.getId())).get();
            bookmarkRepository.save(new Bookmark(Long.valueOf(bookmarkVO.getId()),null,c,user));

        }else{
            Sights s = sightsRepository.findById(Long.valueOf(bookmarkVO.getId())).get();
            bookmarkRepository.save(new Bookmark(Long.valueOf(bookmarkVO.getId()),s,null,user));
        }
    }

    @Override
    public void updateBookmark(BookmarkVO id) {

    }

    @Override
    public void deleteBookmark(String bookmarkId) {
        Bookmark bookmark = bookmarkRepository.findById(Long.valueOf(bookmarkId)).get();
        User user = bookmark.getUser();
        user.getBookmarkList().remove(bookmark);
        userRepository.saveAndFlush(user);
        ChargingStation chargingStation = bookmark.getChargingStation();
        chargingStation.getBookmarkList().remove(bookmark);
        chargingStationRepository.saveAndFlush(chargingStation);
        Sights sights = bookmark.getSights();
        sights.getBookmarkList().remove(bookmark);
        bookmark.setUser(null);
        bookmark.setChargingStation(null);
        bookmark.setSights(null);
        bookmarkRepository.save(bookmark);
    }

    @Override
    public List<Object> findAllBookmark(String userId) {
        List<Object> list = new ArrayList<>();
        List<Object> bookmarkLists = new ArrayList<>();
        List<Bookmark> b = userRepository.findById(Long.valueOf(userId)).get().getBookmarkList();
        System.out.println(b);
        for (int i=0; i<count();i++){
            BookmarkList bookmark = new BookmarkList();
            bookmark.setId(b.get(i).getBookmarkId());
            System.out.println(bookmark.getId());
            if(b.get(i).getSights() != null){
                bookmark.setPlace(b.get(i).getSights());
                list.add(b.get(i).getSights());
            }else if(b.get(i).getChargingStation() != null){
                bookmark.setPlace(b.get(i).getChargingStation());
                list.add(b.get(i).getChargingStation());
            }
            bookmarkLists.add(bookmark);
            System.out.println(bookmarkLists.get(i).toString());
        }
        return bookmarkLists;
    }
}
