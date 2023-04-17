package Generic;

/**
 * @author Min He
 * @date 15/4/2023 19:25 PM
 * */
public class GenericClass <T>{
    T obj;

    public GenericClass(T obj) {
        this.obj = obj;
    }
    public T getObj(){
        return this.obj;
    }
}
