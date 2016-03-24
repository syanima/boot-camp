package kingdom_of_Balloria.exceptions;


public class RuleViolationForColorException extends Throwable {
    public RuleViolationForColorException(Color color, int limit) {
        super(String.format("Only %s %s Balls Allowed",  limit, color ));
    }
}
