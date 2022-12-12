package com.tu.travel.model.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.sql.Date;

@Entity(name = "trips_days")
public class TripDayEntity {
    @EmbeddedId
    private  TripDayFK tripDayFK;
    private Date date;

    public TripDayEntity() {
    }

    public TripDayEntity(TripDayFK tripDayFK, Date date) {
        this.tripDayFK = tripDayFK;
        this.date = date;
    }

    public TripDayFK getTripDayFK() {
        return tripDayFK;
    }

    public void setTripDayFK(TripDayFK tripDayFK) {
        this.tripDayFK = tripDayFK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
