package com.demo.fijinv.Repositories;

import com.demo.fijinv.Models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
