package com.demo.fijinv.Conteollers;

import com.demo.fijinv.Models.Departments;
import com.demo.fijinv.Models.User;
import com.demo.fijinv.Repositories.DepartmentRepository;
import com.demo.fijinv.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    public DepartmentRepository departmentRepository;
    @Autowired
    public UserRepository userRepository;

    @GetMapping
    public List<Departments> getAllDepartments(){return departmentRepository.findAll();}


    @PostMapping
    public Departments createNewDepartment(@RequestBody Departments department){return departmentRepository.save(department);}

    @DeleteMapping("{id}")
    public ResponseEntity<Departments> deleteDepartment(@PathVariable Long id){
        departmentRepository.deleteById(id);
        return new ResponseEntity<Departments>(HttpStatus.OK);
    }
}
