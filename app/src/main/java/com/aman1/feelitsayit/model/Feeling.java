package com.aman1.feelitsayit.model;

import java.util.Date;
import java.util.UUID;

public class Feeling {

    private UUID id;
    private String entityName;
    private String feelingDetails;
    private Date date;

    public Feeling() {
        this.id = UUID.randomUUID();
        this.date = new Date();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getFeelingDetails() {
        return feelingDetails;
    }

    public void setFeelingDetails(String feelingDetails) {
        this.feelingDetails = feelingDetails;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
