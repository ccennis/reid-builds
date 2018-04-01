package com.hh.reidbuilds.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cennis on 3/30/18.
 */
@Controller
public class CategoryController {

    @RequestMapping("/")
    public String index() {
        return "categories.index";
    }

}
