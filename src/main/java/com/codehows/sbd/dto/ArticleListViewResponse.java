package com.codehows.sbd.dto;



//글 작성 리스트르 뷰로 보내는 객체
import com.codehows.sbd.domain.Article;
import lombok.Getter;

@Getter
public class ArticleListViewResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponse(Article article){
        this.id  = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
