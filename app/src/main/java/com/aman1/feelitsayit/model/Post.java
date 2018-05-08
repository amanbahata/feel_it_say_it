package com.aman1.feelitsayit.model;

import java.util.Date;
import java.util.UUID;

public class Post {

    private UUID id;
    private String title;
    private String details;
    private Date date;

    public Post() {
        this.id = UUID.randomUUID();
        this.date = new Date();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
