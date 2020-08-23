package com.bitcamp.team_project_eco.sights;

import com.bitcamp.team_project_eco.bookmark.Bookmark;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SightsVO {
    Long sightsId;
    String name;
    String streetAddress;
    String address;
    double xValue;
    double yValue;
    int capacity;
    int parkingLot;
    String info;
    String category;
    List<Bookmark> bookmarkList;
    Long userSeq;
}
