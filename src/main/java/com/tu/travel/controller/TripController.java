package com.tu.travel.controller;

import com.tu.travel.exception.TripDeletionFails;
import com.tu.travel.exception.TripNotFoundException;
import com.tu.travel.model.services.TripServiceModel;
import com.tu.travel.service.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping()
    public ResponseEntity<List<TripServiceModel>> getTrips() throws TripNotFoundException {
        return ResponseEntity.ok(tripService.getTrips());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripServiceModel> getTripById(@PathVariable("id") long id) throws TripNotFoundException, TripNotFoundException {
        return ResponseEntity.ok(tripService.getTripById(id));
    }

    @PostMapping()
    public ResponseEntity<TripServiceModel> addTrip(@RequestBody() TripServiceModel trip) throws TripNotFoundException {
        return new ResponseEntity<>(tripService.addTrip(trip), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTripById(@PathVariable("id") long id) throws TripNotFoundException, TripDeletionFails {
        return new ResponseEntity<>(tripService.deleteTripById(id), HttpStatus.OK);
    }

    @PutMapping("/days/{id}")
    public void addDays(@PathVariable("id") long id, @RequestBody List<Long> daysIds) throws TripNotFoundException {
        tripService.addDays(id, daysIds);
    }
}
