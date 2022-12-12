package com.tu.travel.repository;

import com.tu.travel.model.entities.DayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface DayRepository extends JpaRepository<DayEntity, Long> {
    @Query("SELECT d FROM DayEntity d")
    List<DayEntity> getDayEntities();

    Optional<DayEntity> findById(int id);

    @Query("SELECT d FROM DayEntity d where d.id in(:pIds)")
    List<DayEntity> getDaysByIds(@Param("pIds") List<Long> ids);
}
