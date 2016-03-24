package kingdom_of_Balloria.exceptions;


import kingdom_of_Balloria.Color;

public class RuleViolationForColorException extends Throwable {
    public RuleViolationForColorException(Color color, int limit) {
        super(String.format("Only %s %s Balls Allowed",  limit, color ));
    }
}
