package com.example;

import com.example.service.RedisService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ApplicationConfiguration {

    @Bean
    public RedisService redisService() {
        return new RedisService();
    }
}
