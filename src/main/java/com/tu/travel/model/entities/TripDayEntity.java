package com.tu.travel.model.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.sql.Date;

@Entity(name = "trips_days")
public class TripDayEntity {
    @EmbeddedId
    private  TripDayFK tripDayFK;

    public TripDayEntity() {
    }

    public TripDayEntity(TripDayFK tripDayFK) {
        this.tripDayFK = tripDayFK;
    }

    public TripDayFK getTripDayFK() {
        return tripDayFK;
    }

    public void setTripDayFK(TripDayFK tripDayFK) {
        this.tripDayFK = tripDayFK;
    }
}
