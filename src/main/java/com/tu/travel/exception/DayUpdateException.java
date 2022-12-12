package com.tu.travel.exception;

public class DayUpdateException extends Exception{
    public DayUpdateException(long id) {
        super(String.format("Day with id = %d update failed!", id));
    }
}
