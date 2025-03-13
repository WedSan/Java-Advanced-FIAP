package com.project.wedsan.JavaCheckpoint4.repository;

import com.project.wedsan.JavaCheckpoint4.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    boolean existsByName(String cityName);

    boolean existsByLatitudeAndLongitude(double latitude, double longitude);
}
