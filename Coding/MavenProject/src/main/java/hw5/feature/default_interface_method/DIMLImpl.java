package hw5.feature.default_interface_method;

public class DIMLImpl implements DIML{

    @Override
    public int add(int a, int b) {
        return a+b;
    }
    // can override `sub` method
    // cannot override static `method` print


}
