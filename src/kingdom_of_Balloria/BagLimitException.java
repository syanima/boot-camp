package kingdom_of_Balloria;

public class BagLimitException extends Throwable {
    public BagLimitException() {
        super("The Bag is full. You can't add any more balls.");
    }
}
