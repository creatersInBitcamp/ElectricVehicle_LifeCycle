package com.bitcamp.team_project_eco.bookmark;

import com.bitcamp.team_project_eco.wishlist.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {
    @Autowired BookmarkService bookmarkService;

    @GetMapping("/getall")
    public List<Bookmark> getAllBookmark(){
        return (List<Bookmark>) bookmarkService.findAll();
    }

    @GetMapping("/getone/{bookmarkId}")
    public Optional<Bookmark> getOneBookmark(@PathVariable String bookmarkId) {
        return bookmarkService.findById(bookmarkId);
    }

    @PostMapping("/insert")
    public void insertBookmark(@RequestBody Bookmark bookmark) {
        bookmarkService.insertBookmark(bookmark);
    }
    @PostMapping("/update")
    public void updateBookmark(@RequestBody Bookmark bookmark) {
        bookmarkService.updateBookmark(bookmark);
    }

    @GetMapping("/delete")
    public void deleteBookmark(@PathVariable String bookmarkId) {
        bookmarkService.delete(bookmarkId);
    }

}
