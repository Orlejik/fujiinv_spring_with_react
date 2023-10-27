package com.demo.fijinv.Repositories;

import com.demo.fijinv.Models.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departments, Long> {
}
