package com.akashcodez.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "/")
public class HomeController {

    @RequestMapping("/")
    public String goToHome(){
        return "redirect:/app/home";
    }
}
