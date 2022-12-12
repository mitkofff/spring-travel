package com.tu.travel.exception;

public class DayDeletionFails extends Exception {
    public DayDeletionFails(long id) {
        super(String.format("Something went wrong while deleting day with id = %d", id));
    }
}
