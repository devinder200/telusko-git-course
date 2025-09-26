package com.example.SpringBootSecurityTest.controller;

import com.example.SpringBootSecurityTest.config.MyUserDetails;
import com.example.SpringBootSecurityTest.modal.Users;
import com.example.SpringBootSecurityTest.service.MyUserDetailsService;
import com.example.SpringBootSecurityTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    UserService userService;

//    @GetMapping("/login")
//    public String getLogin(){
//        System.out.println("entered in getLogin method");
//        return "login";
//    }
//
//    @GetMapping("/register")
//    public String getRegister(){
//        System.out.println("entered in getRegister method");
//        return "register";
//    }
//
//    @GetMapping("/home")
//    public String getHome(@RequestBody Users user){
//        System.out.println("entered in home method");
//        return "home";
//    }

    @ResponseBody
    @PostMapping("/registerUser")
    public Users registerUser(@RequestBody Users user){
            return userService.register(user);
    }

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return userService.verify(user);
    }


}
