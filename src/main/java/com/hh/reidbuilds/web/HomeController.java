package com.hh.reidbuilds.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "index";
    }
}
