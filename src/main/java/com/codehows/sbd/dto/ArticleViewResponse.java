package com.codehows.sbd.dto;


import com.codehows.sbd.domain.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ArticleViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDate start;
    private LocalDate updateAt;

    public ArticleViewResponse(Article article){
        this.id = article.getId();
        this.title=  article.getTitle();
        this.content = article.getContent();
        this.start = article.getStart();
        this.updateAt = article.getUpdateAt();
    }
}
