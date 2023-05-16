package com.chuwa.learn.springbasic.main;

import com.chuwa.learn.springbasic.config.BeanConfig;
import com.chuwa.learn.springbasic.service.DependencyInjectionByTypeByName;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocContainerApplication {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        context.getBean("dependencyInjectionByTypeByName", DependencyInjectionByTypeByName.class).printFirstMessage();

        ApplicationContext context2 = new AnnotationConfigApplicationContext(BeanConfig.class);
        context2.getBean("dependencyInjectionByTypeByName", DependencyInjectionByTypeByName.class).printFirstMessage();

        //ApplicationContext context3 = new ClassPathXmlApplicationContext("bean2.xml");
        //context3.getBean("dependencyInjectionByTypeByName", DependencyInjectionByTypeByName.class).printFirstMessage();
    }

}
