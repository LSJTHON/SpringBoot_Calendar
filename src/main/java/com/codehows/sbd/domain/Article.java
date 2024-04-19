package com.codehows.sbd.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content",nullable = false)
    private String content;

    @Builder//빌더 패턴으로 객체 생성
    public Article(String title, String content,LocalDate start){
        this.title = title;
        this.content = content;
        this.start=start;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    //@CreatedDate //컬럼이 들어갈때 시간 저장
    @Column(name = "start")
    private LocalDate start;


    //@LastModifiedDate //수정된 시간 저장(업데이트 될때)
    @Column(name = "updated_at")
    private LocalDate updateAt;

}
