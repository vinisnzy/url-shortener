package com.vinisnzy.url_shortener.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "urls")
public class Url {

    @Id
    private String id;
    private String originalUrl;

    public Url() {
    }

    public Url(String id, String originalUrl) {
        this.id = id;
        this.originalUrl = originalUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
