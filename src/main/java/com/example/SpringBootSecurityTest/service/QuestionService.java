package com.example.SpringBootSecurityTest.service;

import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    public String getQuestions() {
        return "question";
    }
}
