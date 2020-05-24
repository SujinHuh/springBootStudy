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

    @Data
    public static class naverDocument {
        private String title;
        private String link;
        private String bloggername;
        private String description;
        private String postdate;
    }
}