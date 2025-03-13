package com.project.wedsan.JavaCheckpoint4.repository;

import com.project.wedsan.JavaCheckpoint4.model.CityEntity;
import com.project.wedsan.JavaCheckpoint4.model.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
    List<WeatherEntity> findAllByCityEntity(CityEntity cityEntity);
}
