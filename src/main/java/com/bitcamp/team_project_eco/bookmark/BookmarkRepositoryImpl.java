package com.bitcamp.team_project_eco.bookmark;

import com.bitcamp.team_project_eco.chargingStation.ChargingStation;
import com.bitcamp.team_project_eco.chargingStation.QChargingStation;
import com.bitcamp.team_project_eco.join.AdminUsedCar;
import com.bitcamp.team_project_eco.sights.QSights;
import com.bitcamp.team_project_eco.sights.Sights;
import com.bitcamp.team_project_eco.user.QUser;
import com.bitcamp.team_project_eco.user.User;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.bitcamp.team_project_eco.bookmark.QBookmark.bookmark;
import static com.bitcamp.team_project_eco.user.QUser.*;
import static com.bitcamp.team_project_eco.chargingStation.QChargingStation.*;
import static com.bitcamp.team_project_eco.sights.QSights.*;

interface CustomedBookmarkRepository{
    List<Object> findBookmarks(Long userSeq);
    ChargingStation findByChargingStationId(String chargingStationId);
    User findByUserSeq(Long userSeq);
    Sights findBySightsId(Long sightsId);
}
@Repository
public class BookmarkRepositoryImpl extends QuerydslRepositorySupport implements CustomedBookmarkRepository{
    private final JPAQueryFactory jpaQueryFactory;
    public BookmarkRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        super(Bookmark.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
    @Override
    public ChargingStation findByChargingStationId(String chargingStationId) {
        QChargingStation qChargingStation = chargingStation;
        return jpaQueryFactory.selectFrom(qChargingStation).where(qChargingStation.chargerId.eq(chargingStationId)).fetchOne();
    }
    @Override
    public User findByUserSeq(Long userSeq) {
        QUser qUser = user;
        return jpaQueryFactory.selectFrom(qUser).where(qUser.userSeq.eq(userSeq)).fetchOne();
    }
    @Override
    public Sights findBySightsId(Long sightsId) {
        QSights qSights = sights;
        return jpaQueryFactory.selectFrom(qSights).where(qSights.sightsId.eq(sightsId)).fetchOne();
    }
    @Override
    public List<Object> findBookmarks(Long userSeq) {
        System.out.println("durl"+userSeq);
        List<Bookmark> b = jpaQueryFactory
                .selectFrom(bookmark)
                .where(bookmark.user.userSeq.eq(userSeq))
                .fetch();
        System.out.println(b);
        List<Object> list = new ArrayList<>();
        List<Object> bookmarkLists = new ArrayList<>();
        for (int i=0; i<b.size();i++){
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
            System.out.println(bookmarkLists);
        }
        return bookmarkLists;
    }

}
