package com.danshop.core;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import static com.danshop.core.MDCUtils.MDC_APPLICATION_NAME;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class CoreApplication {

    public static void main(String[] args) {
        try {
            SpringApplication
                    .run(CoreApplication.class, args);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    @Bean
    ApplicationRunner applicationRunner(Environment environment) {
        String serviceName = environment.getProperty("spring.application.name");

        return args -> {
            MDC.put(MDC_APPLICATION_NAME, serviceName);
        };
    }

}
