package com.demo.fijinv.Repositories;

import com.demo.fijinv.Models.Departments;
import com.demo.fijinv.Models.Items;
import com.demo.fijinv.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByDepartmentName(String depName);

    Optional<User> findById(Long id);
}