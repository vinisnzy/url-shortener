package com.vinisnzy.url_shortener.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "urls")
public class Url {

    @Id
    private String id;
    private String originalUrl;
    private Date createdAt;

    public Url() {
    }

    public Url(String id, String originalUrl) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.createdAt = new Date();
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

    public Date getExpiresAt() {
        return createdAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.createdAt = expiresAt;
    }
}
