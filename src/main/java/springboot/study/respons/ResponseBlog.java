package springboot.study.respons;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseBlog {

    private Integer total;
    private List<naverDocument> items;

    @Getter
    @Setter
    public static class naverDocument{
        String title;
        String link;
        String bloggername;
        String description;
        String postdate;
    }
}