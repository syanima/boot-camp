package kingdom_of_Balloria.exceptions;

import kingdom_of_Balloria.Color;

public class GreenBallRuleViolationException extends RuleViolationForColorException {
    public GreenBallRuleViolationException(int limit) {
        super(Color.GREEN, limit);
    }
}