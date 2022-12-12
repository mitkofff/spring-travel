package com.tu.travel.exception;

public class TripDeletionFails extends Exception{
    public TripDeletionFails(long id) {
        super(String.format("Something went wrong while deleting trip with id = %d", id));
    }
}
