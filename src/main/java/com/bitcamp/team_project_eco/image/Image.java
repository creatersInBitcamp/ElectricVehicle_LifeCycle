package com.bitcamp.team_project_eco.image;

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

    @Column(name = "url", nullable = false, length = 700)
    private String url;

    @Column(name = "update_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private DateTime updateDate;

    @Column(name = "image_cate", nullable = false)
    private String imageCate;
}
