package com.socialmedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SocialMediaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialMediaServiceApplication.class, args);
    }

}
