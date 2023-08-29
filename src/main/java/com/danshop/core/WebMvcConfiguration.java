package com.danshop.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    private final LoggingInterceptorAdapter loggingInterceptorAdapter;

    public WebMvcConfiguration(LoggingInterceptorAdapter loggingInterceptorAdapter) {
        this.loggingInterceptorAdapter = loggingInterceptorAdapter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(loggingInterceptorAdapter)
                .addPathPatterns("/*");
    }
}