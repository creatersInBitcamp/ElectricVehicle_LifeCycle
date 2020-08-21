package com.bitcamp.team_project_eco.sights;

import com.bitcamp.team_project_eco.bookmark.Bookmark;
import com.bitcamp.team_project_eco.bookmark.BookmarkRepository;
import com.bitcamp.team_project_eco.user.UserRepository;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface SightsService extends JpaService<Sights> {
    public void readCsv();

    void insertSights(Sights sights);

    void updateSights(Sights sights);

    List<? extends Object> findAll(String userSeq);
}

@Service
public class SightsServiceImpl implements SightsService{
    private final SightsRepository sightsRepository;
    private final UserRepository userRepository;
    private final BookmarkRepository bookmarkRepository;

    public SightsServiceImpl(SightsRepository sightsRepository, UserRepository userRepository, BookmarkRepository bookmarkRepository) {
        this.sightsRepository = sightsRepository;
        this.userRepository = userRepository;
        this.bookmarkRepository = bookmarkRepository;
    }

    @Override
    public Optional<Sights> findById(String id) {
        return sightsRepository.findById(Long.valueOf(id));
    }

    @Override
    public Iterable<Sights> findAll() {
        return sightsRepository.findAll();
    }

    @Override
    public List<? extends Object> findAll(String userSeq) {
        List<Bookmark> b = userRepository.findById(Long.valueOf(userSeq)).get().getBookmarkList();
        System.out.println("흠"+b.toString());
        List<Sights> sights = sightsRepository.findAll();

        if(b.isEmpty()){
            return sights;
        }
        else{
            List<SightsVO> sightsList = new ArrayList<>();
            List<String> id = new ArrayList<>();
            List<Boolean> check = new ArrayList<>();
            for (Bookmark bookmark : b) {
                if (bookmark.getSights() == null) {
                    check.add(true);
                }else {
                    check.add(false);
                    id.add(String.valueOf(bookmark.getSights().getSightsId()));
                }
                System.out.println("관광지 "+check);
            }
            if (!check.contains(false)){
                return sights;
            }
            for(int i=0; i<count(); i++){
                SightsVO s = new SightsVO();
                s.setSightsId(sights.get(i).getSightsId());
                s.setName(sights.get(i).getName());
                s.setStreetAddress(sights.get(i).getStreetAddress());
                s.setAddress(sights.get(i).getAddress());
                s.setXValue(sights.get(i).getXValue());
                s.setYValue(sights.get(i).getYValue());
                s.setCapacity(sights.get(i).getCapacity());
                s.setParkingLot(sights.get(i).getParkingLot());
                s.setInfo(sights.get(i).getInfo());
                s.setCategory(sights.get(i).getCategory());
                s.setUserSeq(Long.valueOf(userSeq));

                for(int j=0; j<id.size();j++){
                    if (s.getSightsId().equals(Long.valueOf(id.get(j)))){
                        s.setBookmarkList(b);
                    }
                }
                sightsList.add(s);
            }
            return sightsList;
        }
    }

    @Override
    public int count() {
        return (int) sightsRepository.count();
    }

    @Override
    public void delete(String id) {
        sightsRepository.delete(findById(id).orElse(new Sights()));
    }

    @Override
    public boolean exists(String id) {
        return sightsRepository.existsById(Long.valueOf(id));
    }

    @Override
    public void readCsv() {
        InputStream is = getClass().getResourceAsStream("/static/sights.csv");

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                sightsRepository.save(new Sights(
                        csvRecord.get(0),
                        csvRecord.get(1),
                        csvRecord.get(2),
                        Double.parseDouble(csvRecord.get(3)),
                        Double.parseDouble(csvRecord.get(4)),
                        Integer.parseInt(csvRecord.get(5)),
                        Integer.parseInt(csvRecord.get(6)),
                        csvRecord.get(7),
                        "sights",
                        new ArrayList<>()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertSights(Sights sights) {
        sightsRepository.save(sights);
    }

    @Override
    public void updateSights(Sights sights) {

    }

}
