public abstract class TwoDShape<E> extends Shape<E> implements TwoDGeometricObject, Comparable<E> {

    public TwoDShape() {}

    public TwoDShape(String color, boolean filled) {
        super(color, filled);
    }

}
