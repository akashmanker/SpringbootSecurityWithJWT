package com.akashcodez.controllers;

import com.akashcodez.entity.User;
import com.akashcodez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping("/home")
    public String showHome(){
        return  "home";
    }

    @RequestMapping("/about")
    public String showAbout(){
        return  "about";
    }


    @RequestMapping("/showRegisterForm")
    public String showRegForm(){
        return "registerForm";
    }

    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public String register(@RequestParam("userName") String userName,
                           @RequestParam("userEmail") String userEmail,
                           @RequestParam("userPassword") String userPassword){

        User user = new User();
        user.setUserName(userName);
        user.setUserEmail(userEmail);
        user.setUserPassword(passwordEncoder.encode(userPassword));
        user.setRole("USER");
        userService.addUser(user);
        return "home";
    }

}