package com.example.SpringBootSecurityTest.controller;


import com.example.SpringBootSecurityTest.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public String getQuestions(){
        return questionService.getQuestions();
    }
}
