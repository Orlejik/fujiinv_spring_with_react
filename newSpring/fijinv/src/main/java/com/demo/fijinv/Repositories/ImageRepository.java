package com.demo.fijinv.Repositories;


import com.demo.fijinv.Models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> getImagesByAssets_AssetModel(String itemModel);

    List<Image> getAllByAssets_Id(Long id);

    List<Image> findAllByAssets_AssetModel(String assetModel);
}
