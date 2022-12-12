package com.tu.travel.model.services;

import java.util.Date;
import java.util.List;

public class TripDayServiceModel {
    private long dayId;
    private Date data;

    public TripDayServiceModel() {
    }

    public TripDayServiceModel(long dayId, Date data) {
        this.dayId = dayId;
        this.data = data;
    }

    public long getDayId() {
        return dayId;
    }

    public void setDayId(long dayId) {
        this.dayId = dayId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
