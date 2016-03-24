package kingdom_of_Balloria.exceptions;

public class BagFullException extends Throwable{
    public BagFullException(int limit) {
        super(String.format("Bag can hold only %s Balls", limit));
    }
}
