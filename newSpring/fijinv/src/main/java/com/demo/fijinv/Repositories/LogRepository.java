package com.demo.fijinv.Repositories;

import com.demo.fijinv.Models.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Logs, Long> {
    List<Logs> getLogsByItem_Id(Long id);
}
