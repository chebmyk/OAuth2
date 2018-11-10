package com.mika.authorizationserver.config.security;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;

public class BcryptTest {

    @Test
    public void testBCryptEncode(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("secret"));
    }

    @Test
    public void testBCryptDecode(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        assertTrue(encoder.matches("admin","$2a$10$ORV.D7ddegCiQ4oxpLBQOO1P2.oo0Ca561ZP.ExJn8P7DN3vR/22C"));
    }

}