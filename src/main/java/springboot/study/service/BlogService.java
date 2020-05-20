package springboot.study.service;

import org.springframework.stereotype.Service;
import springboot.study.dto.BlogDto;
import springboot.study.repository.BlogRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<BlogDto> findByQuery(String query) {

        List<BlogDto> list = new ArrayList<>();
        blogRepository.findByQuery(query).getItems().forEach(
                b -> list.add(BlogDto.builder()
                        .title(b.getTitle())
                        .link(b.getLink())
                        .description(b.getDescription())
                        .postdate(b.getPostdate())
                        .blogger(b.getBloggername())
                        .build())
        );

        return list;

        /*
        return blogRepository.findByQuery(query).getItems().stream()
                .map(b -> BlogDTO.builder()
                        .title(b.title)
                        .link(b.link)
                        .description(b.description)
                        .postdate(b.postdate)
                        .blogger(b.bloggername)
                        .build()
                ).collect(Collectors.toList());
        */
    }
}