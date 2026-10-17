package com.mycomp.firstapp.config;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

@Configuration
public class Appconfig {

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public JsonMapper jsonMapper() {
        return JsonMapper.builder()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .build();
    }
}
