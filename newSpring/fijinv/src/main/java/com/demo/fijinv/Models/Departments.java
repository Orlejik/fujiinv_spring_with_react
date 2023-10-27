package com.demo.fijinv.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "depId")
    private Long id;
    @Column(name = "department")
    private String department;
    @JsonIgnore
    @JsonManagedReference
    @OneToMany
    private List<User> users;
}

