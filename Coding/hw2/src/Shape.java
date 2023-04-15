public abstract class Shape<E>{
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    protected Shape() {
        dateCreated = new java.util.Date();
    }

    protected Shape(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        System.out.println("-----------------------");
        return " Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                ", dateCreated=" + dateCreated +
                '}';
    }

    public abstract int compareTo(E o);

    public abstract boolean equalArea(E object1, E object2);
}
