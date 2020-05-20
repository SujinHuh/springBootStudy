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
        String title;
        String link;
        String description;
        Integer display;
        Integer start;
        Integer total;
        // LocalDateTime?? --> datetime


    }


}
