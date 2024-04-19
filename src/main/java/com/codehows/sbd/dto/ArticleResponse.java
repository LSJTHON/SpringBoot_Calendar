package com.codehows.sbd.dto;


import com.codehows.sbd.domain.Article;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;


//title과 content 분을 사용
@Getter
public class ArticleResponse {
    private Long id;
    private final String title;
    private final String content;
    private final LocalDate start;
    private final LocalDate updated_at;

    public ArticleResponse(Article article){
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.start = article.getStart();
        this.updated_at = article.getUpdateAt();
    }
}
