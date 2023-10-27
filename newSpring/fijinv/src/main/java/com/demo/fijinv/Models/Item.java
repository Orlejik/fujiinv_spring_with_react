//package com.demo.fijinv.Models;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.*;
//
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "Items")
//public class Item {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Long id;
//    @Column(name = "plant")
//    private String plant;
//    @Column(name = "fae_number")
//    private String faenumber;
//    @Column(name = "sis_number")
//    private String sisnumber;
//    @Column(name = "item_name")
//    private String itemname;
//    @Column(name = "item_brand")
//    private String itembrand;
//    @Column(name = "item_model")
//    private String itemmodel;
//    @Column(name = "serial_number", unique = true)
//    private String serialnumber;
//    @Column(name = "location")
//    private String location;
//    @Column(name = "hostname")
//    private String hostname;
//    @Column(name = "ip_address")
//    private String ip_address;
//    @Column(name = "isDamaged")
//    private boolean isDamaged;
//    @Column(name = "user_name")
//    private String user_name;
//    @Column(name="departmetn")
//    private String department;
//    @Column(name = "operator_namber")
//    private String operator_number;
//    @Column(name = "user_added")
//    private String user_added_item;
//
//
////    Adding the logs of item movements
//
//    @JsonIgnore
//    @JsonManagedReference
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "item")
//    private List<Logs> logs = new ArrayList<>();
//
////    public void addLogToInvItem(Logs log){
////        log.setItem(this);
////        logs.add(log);
////    }
//}
