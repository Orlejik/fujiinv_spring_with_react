package com.demo.fijinv.Repositories;

import com.demo.fijinv.Models.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemsRepository extends JpaRepository<Items, Long> {

//    Item findByItemname(String itemname);
    public Items findItemByItemname(String itemname);
    Optional<Items> findById(Long id);
}
