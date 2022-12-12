package com.tu.travel.model.services;

import java.sql.Date;

public class DayServiceModel {
    private String location;
    private String description;
    private String comment;
    private Date date;

    public DayServiceModel() {
    }

    public DayServiceModel(String location, String description, String comment, Date date) {
        this.location = location;
        this.description = description;
        this.comment = comment;
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
