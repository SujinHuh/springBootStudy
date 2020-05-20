package springboot.study.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EncyclopediaDto {

    private String title;
    private String link;
    private Integer total;
    private Integer start;
    private Integer display;
}
