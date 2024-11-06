package com.fiap.checkpoint3.repository;

import com.fiap.checkpoint3.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    boolean existsByCode(String code);

    boolean existsByName(String name);

    boolean existsByEmail(String email);
}
