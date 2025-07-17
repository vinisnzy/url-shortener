package com.vinisnzy.url_shortener.repository;

import com.vinisnzy.url_shortener.domain.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends MongoRepository<Url, String> {
    Optional<Url> findByOriginalUrl(String originalUrl);
}
