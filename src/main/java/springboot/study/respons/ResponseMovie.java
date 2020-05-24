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
        private String title;
        private String link;
        private String actor;
        private String director;
        private float userRating;
        private String subtitle;
//        Data pubDate;

    }
}
