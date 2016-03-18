package exception;

public class InvalidInputException extends Throwable {
    public InvalidInputException(){
        super("Invalid input ,only positive values are allowed");
    }
}
