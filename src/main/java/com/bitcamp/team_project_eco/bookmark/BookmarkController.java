package com.bitcamp.team_project_eco.bookmark;

import com.bitcamp.team_project_eco.chargingStation.ChargingStationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {
    private final BookmarkService bookmarkService;
    private final ChargingStationServiceImpl chargingStationService;

    public BookmarkController(BookmarkService bookmarkService, ChargingStationServiceImpl chargingStationService) {
        this.bookmarkService = bookmarkService;
        this.chargingStationService = chargingStationService;
    }

    @GetMapping("/getall")
    public List<Bookmark> getAllBookmark(){
        return (List<Bookmark>) bookmarkService.findAll();
    }

    @GetMapping("/getallbookmark/{userId}")
    public List<Object> getAllBookmarks(@PathVariable Long userId){
        return bookmarkService.findBookmarks(userId);
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
        bookmarkService.delete(bookmarkID);
    }

    @GetMapping("/deletebookmark/{bookmarkId}")
    public void deleteBookmark(@PathVariable String bookmarkId){
        bookmarkService.deleteBookmark(bookmarkId);
    }

}
