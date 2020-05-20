package springboot.study.respons;

import lombok.Data;

import java.util.List;

@Data
public class ResponseBlog {

    private Integer total;
    private List<naverDocument> items;

    @Data
    public static class naverDocument{
        String title;
        String link;
        String bloggername;
        String description;
        String postdate;
    }
}