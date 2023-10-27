package com.demo.fijinv.Conteollers;

import com.demo.fijinv.Exceptions.ResourceNotFoundException;
import com.demo.fijinv.Models.Departments;
import com.demo.fijinv.Models.Logs;
import com.demo.fijinv.Models.User;
import com.demo.fijinv.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("{id}/details")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user= userRepository.findById(id).orElseThrow(()->{
            throw new ResourceNotFoundException("User with such Id was not found");
        });
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public User createNewUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("{department}")
    public List<User> getUsersInDepartment(@PathVariable String department){
        return userRepository.findAllByDepartmentName(department);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
        User updatedUser = userRepository.findById(id).orElseThrow(()->{
            throw new ResourceNotFoundException("user with id="+id+" was not found");
        });

        updatedUser.setFirstname(userDetails.getFirstname());
        updatedUser.setLastname(userDetails.getLastname());
        updatedUser.setPassword(userDetails.getPassword());
        updatedUser.setSecret(userDetails.getSecret());
        updatedUser.setLogin(userDetails.getLogin());
        updatedUser.setIsActive(userDetails.getIsActive());
        updatedUser.setEmail(userDetails.getEmail());
        updatedUser.setRoles(userDetails.getRoles());
        updatedUser.setPermissions(userDetails.getPermissions());
        updatedUser.setPlant(userDetails.getPlant());

        if (updatedUser.getIsActive().equals("ACTIVE")){
            updatedUser.setActivity(true);
        }
        if (updatedUser.getIsActive().equals("INACTIVE")){
            updatedUser.setActivity(false);
        }

        userRepository.save(updatedUser);

        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<User>(HttpStatus.OK);
    }



}
