package springboot.study.respons;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseMovie {

    private List<Item> items;

    @Getter
    public static class Item {
        String title;
        String link;
        String actor;
        String director;
        float userRating;
        String subtitle;
//        Data pubDate;

    }
}
