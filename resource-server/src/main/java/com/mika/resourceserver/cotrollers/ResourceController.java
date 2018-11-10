package com.mika.resourceserver.cotrollers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class ResourceController {

    private List<String> users = new ArrayList<>();

    @PostConstruct
    private void init(){
        users.add("Name1");
        users.add("FFFFF2");
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_ADMIN') && hasAuthority('ROLE_ADMIN')")
    public List<String> showUsers(){
        return users;
    }

    @GetMapping("/users/{index}")
    @PreAuthorize("#oauth2.hasScope('read')")
    public String showUserByIndex(@PathVariable int index){
        return users.get(index);
    }

    @GetMapping(value = "/userinfo",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Principal> me(Principal user) {
        return ResponseEntity.ok(user);
    }
}
