package com.bitcamp.team_project_eco.image;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/images")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/csv")
    public void csvRead(){
        imageService.readCsv();
    }

    @GetMapping("/getall")
    public List<Image> getAllImage(){
        return (List<Image>) imageService.findAll();
    }

    @GetMapping("/getone/{imageId}")
    public Optional<Image> getOneImage(@PathVariable String imageId) {
        return imageService.findById(imageId);
    }

    @GetMapping("/delete")
    public void deleteImage(@PathVariable String imageId) {
        imageService.delete(imageId);
    }

}
