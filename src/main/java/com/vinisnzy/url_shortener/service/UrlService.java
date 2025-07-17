package com.vinisnzy.url_shortener.service;

import com.vinisnzy.url_shortener.domain.Url;
import com.vinisnzy.url_shortener.dto.UrlDTO;
import com.vinisnzy.url_shortener.repository.UrlRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

import static com.vinisnzy.url_shortener.utils.GenerateId.generateId;

@Service
public class UrlService {
    private final UrlRepository repository;

    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    public UrlDTO shortenUrl(String originalUrl, HttpServletRequest request) {
        Optional<Url> existingUrl = repository.findByOriginalUrl(originalUrl);
        if (existingUrl.isPresent()) {
            String redirectUrl = request.getRequestURL().toString().replace("shorten-url", existingUrl.get().getId());
            return new UrlDTO(redirectUrl);
        }

        String id;
        do {
            id = generateId();
        } while (repository.existsById(id));

        repository.save(new Url(id, originalUrl));

        String redirectUrl = request.getRequestURL().toString().replace("shorten-url", id);
        return new UrlDTO(redirectUrl);
    }

    public Optional<HttpHeaders> redirect(String id) {
        Optional<Url> url = repository.findById(id);
        if (url.isEmpty()) {
            return Optional.empty();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url.get().getOriginalUrl()));
        return Optional.of(headers);
    }
}
