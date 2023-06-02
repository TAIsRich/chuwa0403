package org.example;

public class GenericClass<T> {
    T obj;
    public GenericClass(T obj){
        this.obj=obj;
    }
    public T getObj(){
        return this.obj;
    }

    public void setObj(T obj){
        this.obj = obj;
    }
}
