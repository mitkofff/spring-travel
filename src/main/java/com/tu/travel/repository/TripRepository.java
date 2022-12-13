package com.tu.travel.repository;

import com.tu.travel.model.entities.DayEntity;
import com.tu.travel.model.entities.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<TripEntity, Long> {
    @Query("SELECT t FROM TripEntity t")
    List<TripEntity> getTripEntities();
    Optional<TripEntity> findById(int id);
}
