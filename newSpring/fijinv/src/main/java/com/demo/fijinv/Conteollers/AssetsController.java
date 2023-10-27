package com.demo.fijinv.Conteollers;

import com.demo.fijinv.Models.Assets;
import com.demo.fijinv.Models.Image;
import com.demo.fijinv.Repositories.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/assets")
public class AssetsController {
    @Autowired
    public AssetsRepository assetsRepository;

    @GetMapping
    public List<Assets> getAllAssets() {
        return assetsRepository.findAll();
    }

    @GetMapping("{assetModel}")
    public ResponseEntity<Assets> getAssetByAssetModel(@PathVariable String assetModel){
         assetsRepository.getAssetsByAssetModel(assetModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Assets> deleteAsset(@PathVariable Long id) {
        assetsRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> saveAsset(@ModelAttribute Assets assets,
                                            @RequestParam(value = "file1", required =false) MultipartFile file1,
                                            @RequestParam(value = "file2", required =false) MultipartFile file2,
                                            @RequestParam(value = "file3", required =false) MultipartFile file3)  throws IOException {

        Image image1;
        Image image2;
        Image image3;

        if(file1.getSize() != 0 || !file1.isEmpty() ){
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            assets.addImageToItemName(image1);
        }else{
            System.out.println("File1 was not sent");
            System.out.println(assets);
        }
        if(file2.getSize() != 0 || !file2.isEmpty() ){
            image2 = toImageEntity(file2);
            assets.addImageToItemName(image2);
        }else{
            System.out.println("File2 was not sent");
            System.out.println(assets);
        }
        if(file3.getSize() != 0 || !file3.isEmpty() ){
            image3 = toImageEntity(file3);
            assets.addImageToItemName(image3);
        }else{
            System.out.println("File3 was not sent");
            System.out.println(assets);
        }

        System.out.println(assets);

        Assets itemFromDB = assetsRepository.save(assets);
        itemFromDB.setPreviewImageId(itemFromDB.getImages().get(0).getId());
        assetsRepository.save(assets);

        return ResponseEntity.ok().build();
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setImageName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
}
