package com.example.SmartDoc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsCfg implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry r) {
        r.addMapping("/**")
                .allowedOrigins("http://localhost:8081","http://127.0.0.1:8081")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)   // only if you plan to send cookies/auth
                .maxAge(3600);
    }
}

