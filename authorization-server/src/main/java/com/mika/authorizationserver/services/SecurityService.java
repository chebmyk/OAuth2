package com.mika.authorizationserver.services;

import com.mika.authorizationserver.model.CustomUserDetails;
import com.mika.authorizationserver.model.entity.Security;
import com.mika.authorizationserver.repositories.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SecurityService implements UserDetailsService {

    private SecurityRepository repository;

    @Autowired
    public SecurityService(SecurityRepository repository) {
        this.repository =repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Checking user " +email);
        Security credentials = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with email [" +email+ "] not found"));
        return new CustomUserDetails(
                credentials.getUser().getEmail(),
                credentials.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")) //todo load from DB
        );
    }
}
