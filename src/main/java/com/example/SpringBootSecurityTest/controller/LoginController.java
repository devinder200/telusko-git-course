package com.example.SpringBootSecurityTest.controller;

import com.example.SpringBootSecurityTest.config.MyUserDetails;
import com.example.SpringBootSecurityTest.modal.Users;
import com.example.SpringBootSecurityTest.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }


    @PostMapping("/registerUser")
    public ModelAndView registerUser(@ModelAttribute("user") Users user){
        ModelAndView mv = new ModelAndView("register");
        return mv.addObject("message", myUserDetailsService.registerUser(user));
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

}
