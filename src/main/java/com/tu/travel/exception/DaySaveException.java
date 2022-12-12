package com.tu.travel.exception;

public class DaySaveException  extends Exception {
    public DaySaveException(String location) {
        super(String.format("Something went wrong while trying to add a day in %t", location));
    }
}