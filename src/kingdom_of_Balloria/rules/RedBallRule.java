package kingdom_of_Balloria.rules;

import kingdom_of_Balloria.Ball;
import kingdom_of_Balloria.Color;
import kingdom_of_Balloria.balls.ReadOnlyBalls;
import kingdom_of_Balloria.exceptions.RedBallRuleViolationException;
import kingdom_of_Balloria.exceptions.RuleViolationForColorException;

public class RedBallRule implements Rule {
    @Override
    public void checkRuleViolationToAddNewBall(Ball ball, ReadOnlyBalls balls) throws RuleViolationForColorException {
        if (!ball.isOfColor(Color.RED))
            return;
        if (balls.countOf(Color.RED) == getAllowedCount(balls))
            throw new RedBallRuleViolationException(getAllowedCount(balls));
    }

    private int getAllowedCount(ReadOnlyBalls balls) {
        int totalGreenBallsPresent = balls.countOf(Color.GREEN);
        return (totalGreenBallsPresent * 2) - 1;
    }
}
