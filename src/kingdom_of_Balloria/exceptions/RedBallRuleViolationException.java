package kingdom_of_Balloria.exceptions;

import kingdom_of_Balloria.Color;

public class RedBallRuleViolationException extends RuleViolationForColorException {
    public RedBallRuleViolationException(int limit) {
        super(Color.RED, limit);
    }
}