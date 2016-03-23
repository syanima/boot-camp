package exceptions;

public class BallCantBeAddedBecauseConstraintIsBroken extends Throwable {
    public BallCantBeAddedBecauseConstraintIsBroken(String exceptionMessage) {
        super(exceptionMessage);
    }
}
