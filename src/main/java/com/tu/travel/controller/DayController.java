package com.tu.travel.controller;

import com.tu.travel.exception.*;
import com.tu.travel.model.services.DayServiceModel;
import com.tu.travel.service.DayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/days")
public class DayController {
    private final DayService dayService;

    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @GetMapping()
    public ResponseEntity<List<DayServiceModel>> getDays(Principal pr) throws GetDaysException {
        System.out.println(pr.getName());
        System.out.println(pr.getClass());
        return ResponseEntity.ok(dayService.getDays());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DayServiceModel> getDayById(@PathVariable("id") long id) throws DayNotFoundException {
        return ResponseEntity.ok(dayService.getDayById(id));
    }

    @PostMapping()
    public ResponseEntity<DayServiceModel> addDay(@RequestBody() DayServiceModel day) throws DayNotFoundException, DaySaveException {
        return new ResponseEntity<>(dayService.addDay(day), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DayServiceModel> updateDay(
            @PathVariable("id") long id,
            @RequestBody() DayServiceModel day) throws DayNotFoundException, DayUpdateException {
        return  new ResponseEntity<>(dayService.updateDay(id, day), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Long> deleteDayById(@PathVariable("id") long id) throws DayNotFoundException, DayDeletionFails {
        return  new ResponseEntity<>(dayService.deleteDayById(id), HttpStatus.OK);
    }
}
