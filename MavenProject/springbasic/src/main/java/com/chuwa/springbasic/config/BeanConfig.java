package com.chuwa.springbasic.config;

import com.chuwa.springbasic.components.JpaChuwa;
import com.chuwa.springbasic.components.impl.DataNucleusChuwaNoComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//1. 如果只有一个impl,则默认用这个impl
//2. 如果有多个impl, 则查看是否有@Qualifier
//3. 如果有多个impl, 且无@Qualifier, 则查看是否有@Primary (因为这个是type level的)
//4. 如果有多个impl, 且无@Qualifier, 且無@Primary, 按变量名(By Name)确定用哪一个
//5. 如果依然不能确定用哪一个，则报错(NoUniqueBeanDefinitionException)
@Configuration
@ComponentScan(basePackages = {"com.chuwa.springbasic"})
public class BeanConfig {
    @Bean
    public JpaChuwa myDataNucleus() {
        return new DataNucleusChuwaNoComponent();
    }
}
