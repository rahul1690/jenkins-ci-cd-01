package com.javatechie.learning.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/greetings/{name}")
    public String greetings(@PathVariable String name){
        return "Hello "+name+" Congratulations you have successfully completed learning jenkins CI/CD demo!";
    }

}
