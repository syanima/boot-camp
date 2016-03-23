package kingdom_of_Balloria;

public class GreenBallLimitException extends Throwable {
    public GreenBallLimitException() {
        super("The Bag cannot contain more than 3 Green Balls.");
    }
}
