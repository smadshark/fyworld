package org.fyworld.developer.controller;

import lombok.RequiredArgsConstructor;
import org.fyworld.developer.domain.Article;
import org.fyworld.developer.dto.AddArticleRequest;
import org.fyworld.developer.dto.ArticleResponse;
import org.fyworld.developer.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/articles")
public class BlogController {
    private final BlogService blogService;

    @PostMapping
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream().map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok().body(articles);
    }
}
