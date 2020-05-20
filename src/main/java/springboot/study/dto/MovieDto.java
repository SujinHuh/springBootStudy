package springboot.study.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MovieDto {

    private String title;
    private String link;
    private float userRating;
    private String subtitle;
}
