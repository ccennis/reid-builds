package com.hh.reidbuilds.repository;

import com.hh.reidbuilds.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cennis on 4/1/18.
 */
 @Repository
    public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findByCategoryId(Long id);

}
