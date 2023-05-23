package org.fyworld.developer.service;

import lombok.RequiredArgsConstructor;
import org.fyworld.developer.domain.Article;
import org.fyworld.developer.dto.AddArticleRequest;
import org.fyworld.developer.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
}
