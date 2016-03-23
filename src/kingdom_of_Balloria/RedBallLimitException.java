package kingdom_of_Balloria;

public class RedBallLimitException extends  Throwable{
    public RedBallLimitException() {
        super("The Bag cannot add Red Ball at this point.");
    }
}
