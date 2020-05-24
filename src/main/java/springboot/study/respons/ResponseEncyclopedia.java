package springboot.study.respons;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseEncyclopedia {

    private List<Item> items;

    @Getter
    public static class Item {
        private String title;
        private String link;
        private String description;
        private Integer display;
        private Integer start;
        private Integer total;
        // LocalDateTime?? --> datetime


    }


}
