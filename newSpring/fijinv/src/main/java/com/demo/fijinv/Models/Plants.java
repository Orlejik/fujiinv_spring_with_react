package com.demo.fijinv.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table
public class Plants {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plantId")
    private Long id;
    @Column(name = "plant")
    private String plant;
}
