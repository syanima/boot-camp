package kingdom_of_Balloria.rules;

import kingdom_of_Balloria.Ball;
import kingdom_of_Balloria.balls.ReadOnlyBalls;
import kingdom_of_Balloria.exceptions.RuleViolationForColorException;

public class ReadOnlyRules {
    private Rules rules;

    public ReadOnlyRules(Rules rules) {
        this.rules = rules;
    }

    public void cryWhenRuleViolated(Ball ball, ReadOnlyBalls balls) throws RuleViolationForColorException {
        rules.cryWhenRuleViolated(ball, balls);
    }
}