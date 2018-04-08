package com.hh.reidbuilds.controller;

import com.hh.reidbuilds.model.Image;
import com.hh.reidbuilds.repository.ImageRepository;
import com.hh.reidbuilds.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by cennis on 4/7/18.
 */
@Controller
public class DetailsController {

    @Autowired
    ImageService imageService;

//    @GetMapping("/categories/{id}")
//    public String categories(@PathVariable(value = "id") Long categoryId, Model model) {
//
//        List<Image> images = imageRepository.findByCategoryId(categoryId);
//        model.addAttribute("images", images);
//        model.addAttribute("category_name", images.get(0).getCategory().getName());
//
//        return "category/index";
//    }

    @GetMapping("/categories/{slug}")
    public String categoriesBySlug(@PathVariable(value = "slug") String categorySlug, Model model) {

        List<Image> images = imageService.getByCategory(categorySlug);

        model.addAttribute("images", images);
        model.addAttribute("category_name", images.get(0).getCategory().getName());

        return "category/index";
    }
}
