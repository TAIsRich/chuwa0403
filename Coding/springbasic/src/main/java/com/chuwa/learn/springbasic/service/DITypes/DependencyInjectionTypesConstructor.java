package com.chuwa.learn.springbasic.service.DITypes;

import com.chuwa.learn.springbasic.service.dependencies.JpaICC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DependencyInjectionTypesConstructor {

    // type 1, field Injection
    //@Autowired
    private JpaICC jpaICC;

    // type 2, Constructor Injection,  @Autowired可以省略
    @Autowired
    public DependencyInjectionTypesConstructor(JpaICC jpaICC){
        this.jpaICC = jpaICC;
    }

    // type 3, Setter Injection,  @Autowired可以省略
    // @Autowired
    public void setJpaICC(JpaICC jpaICC){
        this.jpaICC = jpaICC;
    }

    public void printMessage(){
        jpaICC.printMessage();
    }
}
