package com.bitcamp.team_project_eco.image;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity @Getter @Setter @ToString @Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private Long imageId;
    @Column(name = "img_name", nullable = false, length = 700)
    private String imgName;
    @Column(name = "img_file", nullable = false)
    private String imgFile;
    @Column(name = "upload_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private DateTime uploadDate;
    @Column(name = "category", nullable = false)
    private String category;

    public Image() {}

    @Builder
    public Image(String imgName, String imgFile, DateTime uploadDate, String category){
        this.imgName = imgName;
        this.imgFile = imgFile;
        this.uploadDate = uploadDate;
        this.category = category;
    }
}
