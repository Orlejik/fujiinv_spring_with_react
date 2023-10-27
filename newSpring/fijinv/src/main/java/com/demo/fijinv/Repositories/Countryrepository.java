package com.demo.fijinv.Repositories;

import com.demo.fijinv.Models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Countryrepository extends JpaRepository<Country, Long> {
}
