package com.chuwa.redbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class CommonConfig {
    /*
    当需要把第三方lib放进IOC容器中的时候，会用@Bean
     */
    @Bean
    public ModelMapper moduleMapper(){
        return new ModelMapper();
    }
}
