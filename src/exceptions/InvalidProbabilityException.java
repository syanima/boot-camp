package exceptions;

public class InvalidProbabilityException extends Throwable {
    public InvalidProbabilityException() {
        super("Expected value should be greater than zero and less than one");
    }
}