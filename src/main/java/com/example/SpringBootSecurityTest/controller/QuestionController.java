package com.example.SpringBootSecurityTest.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionController {

    @GetMapping("/")
    public String getQuestions(){
        System.out.println("------------Entered in question controller--------");
        return "question";
    }
}
