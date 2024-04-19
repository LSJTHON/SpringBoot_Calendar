package com.codehows.sbd.controller;


import com.codehows.sbd.domain.Article;
import com.codehows.sbd.dto.ArticleViewResponse;
import com.codehows.sbd.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/calendars")
    public String getCalendars(Model model){
//        List<ArticleListViewResponse> articles = blogService.findAll()
//                .stream()
//                .map(ArticleListViewResponse::new)
//                .toList();
//        model.addAttribute("articles", articles);
// 얘네들은 calendarList로 리턴 해봤자 사용처가 없음 그 이유로는 api에서 JSON형태로된 정보를들 넘겨주기 때문
        return "calendarList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Article article = blogService.findById(id);

        //ArticleViewResponse 에 있는 업로드 날짜 업데이트 날짜 아이디 제목 내용이 있는 객체를 article을 model로 전송해준다.
        model.addAttribute("article",new ArticleViewResponse(article));

        return "article";
    }

    @GetMapping("/new-article")
    //@RequestParam(required = false) id가 들어갈수도 있고 아닐 수도있다. 그러므로 id가 있으면 수정 없으면 새로 작성
    public String newArticle(@RequestParam(required = false) Long id, Model model){
        if(id==null){//id가 없기 떄문에 새로운 글 작성
            model.addAttribute("article", new ArticleViewResponse());
        }else{ //id가 있으므로 글 수정
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }
        return "newArticle";
    }
}
