package exercise;
/**
 * @author Min He
 * @date 4/16/23 14:19 PM
 */
public class EmptyCartException extends RuntimeException{
    public EmptyCartException(String message){
        super(message);
    }

}
