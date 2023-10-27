package com.demo.fijinv.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name = "assets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "asset_type")
    private String assettype;
    @Column(name = "asset_brand")
    private String assetBrand;
    @Column(name = "asset_model")
    private String assetModel;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "assets")
    @JsonManagedReference
    @JsonIgnore
    private List<Image> images = new ArrayList<>();

    private Long previewImageId;
    private LocalDateTime creationDate;
    @PrePersist //to read about inversion of control
    private void init() {
        creationDate = LocalDateTime.now();
    }
    public void addImageToItemName(Image image) {
        image.setAssets(this);
        images.add(image);
    }

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Items> invItem = new ArrayList<>();
}
