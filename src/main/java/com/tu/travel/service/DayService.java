package com.tu.travel.service;

import com.tu.travel.exception.*;
import com.tu.travel.model.services.DayServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface DayService {
    //public DayServiceModel getDays() throws GetDaysException;
    public DayServiceModel getDayById(long id) throws DayNotFoundException;

    public DayServiceModel addDay(DayServiceModel day) throws DayNotFoundException, DaySaveException;

    public DayServiceModel updateDay(long id, DayServiceModel day) throws DayNotFoundException, DayUpdateException;

    public  long deleteDayById(long id) throws DayNotFoundException, DayDeletionFails;
}
