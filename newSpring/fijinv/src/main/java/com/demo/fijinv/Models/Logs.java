package com.demo.fijinv.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data

@Table(name = "Logs")
@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "log_id")
    private Long id;
    @Column(name = "log_date_time")
    private String logTime;
    @Column(name = "log text", length = 10000000)
    private String logText;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Items item;

    @PrePersist
    private void init() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        logTime = LocalDateTime.now().format(formatter);
            }
}
