package kingdom_of_Balloria.rules;

import kingdom_of_Balloria.Ball;
import kingdom_of_Balloria.balls.ReadOnlyBalls;
import kingdom_of_Balloria.exceptions.RuleViolationForColorException;

public interface Rule {
    public void checkRuleViolationToAddNewBall(Ball ball, ReadOnlyBalls balls) throws RuleViolationForColorException;
}