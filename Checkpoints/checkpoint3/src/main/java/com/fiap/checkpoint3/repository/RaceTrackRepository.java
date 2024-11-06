package com.fiap.checkpoint3.repository;

import com.fiap.checkpoint3.model.RaceTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceTrackRepository extends JpaRepository<RaceTrack, Long> {
}
