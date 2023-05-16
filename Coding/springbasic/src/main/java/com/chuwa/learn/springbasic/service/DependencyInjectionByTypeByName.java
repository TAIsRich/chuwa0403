package com.chuwa.learn.springbasic.service;

import com.chuwa.learn.springbasic.components.JpaChuwa;
import com.chuwa.learn.springbasic.components.impl.HibernateChuwa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DependencyInjectionByTypeByName {

    // Match by type
    @Autowired
    private HibernateChuwa hibernate;

    // Match by Name, 变量名必须是某个子类的名称，且首字母小写
    // 如果是来自于@Bean, 则用的是方法名小写
    @Autowired
    private JpaChuwa hibernateChuwa;

    @Autowired
    private JpaChuwa eclipseLinkChuwa;
    @Autowired
    private JpaChuwa myDataNucleus;

    // Match by Qualifier, 变量名随便起

    @Autowired
    @Qualifier("hibernateChuwa")
    private JpaChuwa jpaChuwaQualifier;

    public void printFirstMessage(){
        System.out.print("By Type(HibernateChuwa hibernate)         : ");
        hibernate.printMessage();

        System.out.print("By Name(JpaChuwa hibernateChuwa)          : ");
        hibernateChuwa.printMessage();
        System.out.print("By Name(JpaChuwa eclipsedLinkChuwa)       : ");
        eclipseLinkChuwa.printMessage();

        System.out.print("By Name and @Bean:(myDataNucleus())       : ");
        myDataNucleus.printMessage();

        System.out.print("By @Qualifier(\"hibernateChuwa\")         : ");
        jpaChuwaQualifier.printMessage();
    }
}
