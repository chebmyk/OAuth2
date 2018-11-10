package com.mika.oauthclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.security.Principal;

@RestController("/client")
public class UserController {

    @Autowired
    private OAuth2RestTemplate oauth2RestTemplate;

    @GetMapping("/user")
    public Principal root(Principal user){
        return user;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> me(Principal user){
        return oauth2RestTemplate.getForEntity("http://localhost:9992/users/0", String.class);
    }
}
