package kingdom_of_Balloria.rules;

import kingdom_of_Balloria.Ball;
import kingdom_of_Balloria.Color;
import kingdom_of_Balloria.balls.ReadOnlyBalls;
import kingdom_of_Balloria.exceptions.GreenBallRuleViolationException;

public class GreenBallRule implements Rule {
    private final int limit;

    public GreenBallRule(int limit) {
        this.limit = limit;
    }

    @Override
    public void checkRuleViolationToAddNewBall(Ball ball, ReadOnlyBalls balls) throws GreenBallRuleViolationException {
        if (!ball.isOfColor(Color.GREEN))
            return;
        if(balls.countOf(Color.GREEN) == limit)
            throw new GreenBallRuleViolationException(limit);
    }
}