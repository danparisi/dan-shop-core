package com.danshop.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CoreApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(CoreApplication.class, args);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
