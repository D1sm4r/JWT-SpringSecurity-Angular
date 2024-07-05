package com.proyecto.rest.backend.repository;

import com.proyecto.rest.backend.entity.HorasExtras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorasExtrasRepository extends JpaRepository<HorasExtras, Long> {
}
