package com.example.restservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    ///this class will be used for any other BEAN Manual creation !!!

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
