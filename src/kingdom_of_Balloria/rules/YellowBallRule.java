package kingdom_of_Balloria.rules;

import kingdom_of_Balloria.Ball;
import kingdom_of_Balloria.Color;
import kingdom_of_Balloria.balls.ReadOnlyBalls;
import kingdom_of_Balloria.exceptions.YellowBallRuleViolationException;

public class YellowBallRule implements Rule {
    private final double threshold;

    public YellowBallRule(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public void checkRuleViolationToAddNewBall(Ball ball, ReadOnlyBalls balls) throws YellowBallRuleViolationException {
        if (!ball.isOfColor(Color.YELLOW))
            return;
        if(balls.countOf(Color.YELLOW) == getAllowedCount(balls))
            throw new YellowBallRuleViolationException(getAllowedCount(balls));
    }

    private int getAllowedCount(ReadOnlyBalls balls) {
        return new Double(threshold * (balls.size()+1)).intValue();
    }
}