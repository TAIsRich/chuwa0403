package com.chuwa.learn.springbasic.service.coupling;

import com.chuwa.learn.springbasic.service.dependencies.JpaICC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DependencyInjection {

    /**
     * 1) 使用 interface
     * 2) 使用Dependency Injection. Spring注入object给变量。
     * 不用提供有参数构造器，我们使用时候不需要传参数
     * 如果想换成别的impl,则删除old, add 新的impl
     */
    @Autowired
    private JpaICC jpaICC;

    public void printMessage() {
        jpaICC.printMessage();
    }

}
