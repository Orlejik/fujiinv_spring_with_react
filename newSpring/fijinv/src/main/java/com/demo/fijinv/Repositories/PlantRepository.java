package com.demo.fijinv.Repositories;

import com.demo.fijinv.Models.Plants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plants, Long> {
}
