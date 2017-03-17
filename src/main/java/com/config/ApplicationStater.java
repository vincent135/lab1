package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by vincentdemilly on 16/03/2017.
 */
@SpringBootApplication
public class ApplicationStater {

    public static void main(String[] args) {

        System.setProperty("spring.profiles.active", "PROD");
        SpringApplication.run(ApplicationStater.class, args);
    }
}
