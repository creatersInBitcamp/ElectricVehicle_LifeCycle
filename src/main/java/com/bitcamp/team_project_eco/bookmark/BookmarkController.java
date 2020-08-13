package com.bitcamp.team_project_eco.bookmark;

import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import com.bitcamp.team_project_eco.chargingStation.ChargingStationServiceImpl;
import com.bitcamp.team_project_eco.sights.Sights;
import com.bitcamp.team_project_eco.wishlist.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {
    @Autowired BookmarkService bookmarkService;
    @Autowired
    ChargingStationServiceImpl chargingStationService;

    @GetMapping("/getall")
    public List<Bookmark> getAllBookmark(){
        return (List<Bookmark>) bookmarkService.findAll();
    }

    @GetMapping("/getallbookmark")
    public List<Object> getAllBookmarks(){
        return bookmarkService.findAllBookmark();
    }

    @GetMapping("/getone/{bookmarkId}")
    public Optional<Bookmark> getOneBookmark(@PathVariable String bookmarkId) {
        return bookmarkService.findById(bookmarkId);
    }

    @PostMapping("/insert")
    public void insertBookmark(@RequestBody BookmarkVO bookmarkVO) {
        bookmarkService.insertBookmark(bookmarkVO);
    }
    @PostMapping("/update")
    public void updateBookmark(@RequestBody BookmarkVO id) {
        bookmarkService.updateBookmark(id);
    }

    @GetMapping("/delete/{bookmarkID}")
    public void delete(@PathVariable String bookmarkID) {
        System.out.println(bookmarkID);
        bookmarkService.delete(bookmarkID);
    }

    @GetMapping("/deletebookmark/{bookmarkId}")
    public void deleteBookmark(@PathVariable String bookmarkId){
        bookmarkService.deleteBookmark(bookmarkId);
    }

}
