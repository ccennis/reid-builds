package com.hh.reidbuilds.services;

import com.hh.reidbuilds.model.Image;
import com.hh.reidbuilds.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cennis on 4/7/18.
 */
@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    public List<Image> getByCategory(String categorySlug){

        if(categorySlug.equals("all")){
            return imageRepository.findAll();
        } else {
           return imageRepository.findByCategorySlug(categorySlug);
        }
    }
}
