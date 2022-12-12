package com.tu.travel.exception;

public class DayNotFoundException extends Exception {
    public DayNotFoundException(long id) {
        super(String.format("Day with id = %d does not found", id));
    }
}
