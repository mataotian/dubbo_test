package com.qf.class_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
public class ClassWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassWebApplication.class, args);
    }

}
