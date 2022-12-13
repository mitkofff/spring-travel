package com.tu.travel.web;

import com.tu.travel.exception.*;
import com.tu.travel.model.services.DayServiceModel;
import com.tu.travel.service.DayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/days")
public class DayController {
    private final DayService dayService;

    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @GetMapping()
    public ResponseEntity<List<DayServiceModel>> getDays() throws GetDaysException {
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
