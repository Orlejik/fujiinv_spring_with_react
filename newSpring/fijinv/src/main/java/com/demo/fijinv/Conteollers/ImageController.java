package com.demo.fijinv.Conteollers;

import com.demo.fijinv.Models.Image;
import com.demo.fijinv.Repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@CrossOrigin("*")
@RestController //no needed to present anything
@RequestMapping("/api/images")
public class ImageController {
    @Autowired
    public ImageRepository imageRepository;

    @GetMapping("/")
    private List<Image> getAllImages(){
        return imageRepository.findAll();
    }

    @GetMapping("{id}")
    private ResponseEntity<?> getImageByID(@PathVariable Long id){
        Image image = imageRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("filename", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }

    @GetMapping("/asset/{assetModel}")
    private List<Image> getAllImagesByAssetId(@PathVariable String assetModel){

        return imageRepository.findAllByAssets_AssetModel(assetModel);




    }
}
