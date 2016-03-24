package kingdom_of_Balloria.exceptions;

import kingdom_of_Balloria.Color;

public class YellowBallRuleViolationException extends RuleViolationForColorException {
    public YellowBallRuleViolationException(int limit) {
        super(Color.YELLOW, limit);
    }
}