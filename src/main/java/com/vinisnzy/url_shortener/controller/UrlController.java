package com.vinisnzy.url_shortener.controller;

import com.vinisnzy.url_shortener.dto.UrlDTO;
import com.vinisnzy.url_shortener.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UrlController {

    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    @PostMapping("/shorten-url")
    public ResponseEntity<UrlDTO> createUrl(@RequestBody UrlDTO dto, HttpServletRequest request) {
        UrlDTO shortenUrl = service.shortenUrl(dto.url(), request);
        return ResponseEntity.ok().body(shortenUrl);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> redirect(@PathVariable String id) {
        Optional<HttpHeaders> headers = service.redirect(id);
        return headers.<ResponseEntity<Void>>
                        map(httpHeaders -> ResponseEntity.status(HttpStatus.FOUND).headers(httpHeaders).build())
                        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
