package com.manasseh.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String showHomepage(){
        return "index";
    }

    @PostMapping("/error")
    public String errorPage(){
        return "errorpage";
    }
}
