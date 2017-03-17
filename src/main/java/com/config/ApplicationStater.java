package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by vincentdemilly on 16/03/2017.
 */
@SpringBootApplication
public class ApplicationStater {

    public static void main(String[] args) {

        System.out.println(new BCryptPasswordEncoder().encode("admin"));
        System.setProperty("spring.profiles.active", "DEV");
        SpringApplication.run(ApplicationStater.class, args);
    }
}
