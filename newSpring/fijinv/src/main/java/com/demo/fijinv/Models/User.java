package com.demo.fijinv.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private Long Id;
    @Column(name="firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;

    @Column(name = "login")
    private String login;
    @Column(name = "email", unique = true)
    @NonNull
    private String email;
    @Column(name = "isActive")
    private String isActive;
    @Column(name = "statusOfActivity")
    private boolean activity;
    @Column(name = "password")
    @NonNull
    private String password;
    @Column(name = "secret")
    private  String secret;
    @Column(name = "roles")
    private String roles;
    @Column(name = "permissions")
    private String permissions;
    @Column(name = "creationDate")
    @NonNull
    private String creationDate;
    @Column(name = "department")
    @NonNull
    private String departmentName;
    @JsonIgnore
    @JsonManagedReference
    @ManyToOne
    private Departments department;

    @Column(name = "plant")
    @NonNull
    private String plant;

    @PrePersist
    private void init() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        creationDate = LocalDateTime.now().format(formatter);
        email=firstname.toLowerCase()+"."+lastname.toLowerCase()+"@eu.fujikura.com";
        if(isActive.equals("ACTIVE")){
            activity=true;
        }
        if(isActive.equals("INACTIVE")){
            activity=false;
        }
    }
    public List<String> getRoleList(){
        if(this.roles.length()>0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionsList(){
        if (this.permissions.length()>0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
}
