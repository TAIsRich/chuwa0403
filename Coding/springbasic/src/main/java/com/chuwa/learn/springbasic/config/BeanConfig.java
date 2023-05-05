package com.chuwa.learn.springbasic.config;

import com.chuwa.learn.springbasic.components.JpaChuwa;
import com.chuwa.learn.springbasic.components.impl.DataNucleusChuwaNoComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.chuwa.learn.springbasic"})
public class BeanConfig {

    @Bean
    public JpaChuwa myDataNucleus(){
        return new DataNucleusChuwaNoComponent();
    }
}
