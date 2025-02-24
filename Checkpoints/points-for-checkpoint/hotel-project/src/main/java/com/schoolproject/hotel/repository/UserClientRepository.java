package com.schoolproject.hotel.repository;

import com.schoolproject.hotel.model.UserClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserClientRepository extends JpaRepository<UserClientEntity, Long> {
}
