package com.tu.travel.service;

import com.tu.travel.exception.TripDeletionFails;
import com.tu.travel.exception.TripNotFoundException;
import com.tu.travel.model.services.TripServiceModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripService {
    public TripServiceModel getTripById(long id) throws TripNotFoundException;

    public TripServiceModel addTrip(TripServiceModel day) throws TripNotFoundException;

    public long deleteTripById(long id) throws TripNotFoundException, TripDeletionFails;

    public void addDays(Long tripId, List<Long> daysIds) throws TripNotFoundException;
}
