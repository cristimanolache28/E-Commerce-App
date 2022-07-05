package com.lov2code.shop;


import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordEncoderTest {

    @Test
    public void testEncodePassword() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "password";
        String encoderPassword = passwordEncoder.encode(rawPassword);

        System.out.println("Password encoder: " + encoderPassword);

        boolean matches = passwordEncoder.matches(rawPassword, encoderPassword);
        assertThat(matches).isTrue();
    }
}
