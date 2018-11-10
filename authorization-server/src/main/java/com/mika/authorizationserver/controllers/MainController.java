package com.mika.authorizationserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController("/")
public class MainController {
    @GetMapping("/me")
    public Principal showMe(Principal user){
        return user;
    }

    public String state(){
        return "AuthServer is Running";
    }
}
