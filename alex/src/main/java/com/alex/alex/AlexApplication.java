package com.alex.alex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackageClasses = AlexApplication.class)
@EnableWebMvc
public class AlexApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlexApplication.class, args);
    }

}
