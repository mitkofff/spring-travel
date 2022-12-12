package com.tu.travel.exception;

public class GetDaysException extends Exception{
    public GetDaysException() {
        super(String.format("Something went wrong while trying to fetch all days"));
    }
}
