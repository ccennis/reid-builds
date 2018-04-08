package com.hh.reidbuilds.controller;

import com.hh.reidbuilds.model.Image;
import com.hh.reidbuilds.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cennis on 4/5/18.
 */
@RestController
@RequestMapping("/api")
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @GetMapping("/images")
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @GetMapping("/imagesCategory/{id}")
    public List<Image> getCategoryImages(@PathVariable(value = "id") Long categoryId) {

        List<Image> images = imageRepository.findByCategoryId(categoryId);

       return images;
    }
}
