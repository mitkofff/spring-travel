package com.tu.travel.model.entities;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "trips")
public class TripEntity extends BaseEntity{
    private String name;
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="trips_days",
            joinColumns = { @JoinColumn(name = "trip_id") },
            inverseJoinColumns = { @JoinColumn(name = "day_id")}
    )
    private List<DayEntity> days;
    @ManyToMany
    private List<FileEntity> pictures;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DayEntity> getDays() {
        return days;
    }

    public void setDays(List<DayEntity> days) {
        this.days = days;
    }

    public List<FileEntity> getPictures() {
        return pictures;
    }

    public void setPictures(List<FileEntity> pictures) {
        this.pictures = pictures;
    }
}
