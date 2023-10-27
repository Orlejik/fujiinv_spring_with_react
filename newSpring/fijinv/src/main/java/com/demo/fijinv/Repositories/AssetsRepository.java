package com.demo.fijinv.Repositories;

import com.demo.fijinv.Models.Assets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetsRepository extends JpaRepository<Assets, Long> {

Assets getAssetsByAssetModel(String assetModel);
}
