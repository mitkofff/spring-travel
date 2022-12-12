package com.tu.travel.exception;

public class TripNotFoundException extends Exception {
    public TripNotFoundException(long id) {
        super(String.format("Trip with id = %d does not found", id));
    }
}
