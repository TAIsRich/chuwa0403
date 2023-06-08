package org.example.lambda;

public interface Foo {
    //abstract method aMethod
    String aMethod(String string);
    default String defaultBar(){
        String s = "default bar method";
        System.out.println(s);
        return s;
    }
    default String defaultCommon(){
        String s="defaultCommon String";
        System.out.println(s);
        return s;
    }
}
