package dev.pichborith.springcoredemo.config;

import dev.pichborith.springcoredemo.common.Coach;
import dev.pichborith.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

//    @Bean("customBeanId")
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}

