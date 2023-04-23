package hw5.feature_exercise;

public class EmptyCartException extends RuntimeException {
    public EmptyCartException(String message){
        super(message);
    }
}
