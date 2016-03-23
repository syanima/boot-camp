package kingdom_of_Balloria;

public class YellowBallLimitException extends Throwable {
    public YellowBallLimitException() {
        super("The Bag cannot add Yellow Ball at this point");
    }
}
