package com.tu.travel.repository;

import com.tu.travel.model.entities.TripDayEntity;
import com.tu.travel.model.entities.TripDayFK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TripDayRepository extends JpaRepository<TripDayEntity, TripDayFK> {

   // @Query("SELECT td FROM TripDayEntity td where td.tripId = id")
   // List<TripDayEntity> getTripDayByTripId(@Param("id") long id);
}
