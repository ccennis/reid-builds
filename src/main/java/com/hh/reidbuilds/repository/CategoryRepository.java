package com.hh.reidbuilds.repository;

import com.hh.reidbuilds.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cennis on 4/1/18.
 */
 @Repository
    public interface CategoryRepository extends JpaRepository<Category, Long> {

}
