package kingdom_of_Balloria.rules;

import kingdom_of_Balloria.Ball;
import kingdom_of_Balloria.balls.Balls;
import kingdom_of_Balloria.balls.ReadOnlyBalls;
import kingdom_of_Balloria.exceptions.RedBallRuleViolationException;
import kingdom_of_Balloria.exceptions.RuleViolationForColorException;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class RedBallRuleTest {

    private RedBallRule redBallRule;
    private Balls balls;
    private Ball redBall;
    private Ball greenBall;

    @Before
    public void setUp() throws Exception {
        redBallRule = new RedBallRule();
        balls = new Balls();
        redBall = Ball.createRedBall();
        greenBall = Ball.createGreenBall();
    }

    @org.junit.Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_allow_red_balls_less_than_double_the_number_of_green_ball() throws RuleViolationForColorException {
        balls.add(greenBall);
        balls.add(redBall);
        ReadOnlyBalls readOnlyBalls = new ReadOnlyBalls(balls);

        thrown.expect(RedBallRuleViolationException.class);
        thrown.expectMessage(CoreMatchers.is("Only 1 RED Balls Allowed"));
        redBallRule.checkRuleViolationToAddNewBall(redBall, readOnlyBalls);
    }

    @Test
    public void should_not_throws_exception_until_rule_is_violated() throws RuleViolationForColorException {
        balls.add(redBall);
        balls.add(redBall);

        ReadOnlyBalls readOnlyBalls = new ReadOnlyBalls(balls);
        redBallRule.checkRuleViolationToAddNewBall(redBall, readOnlyBalls);

        assertTrue(true);
    }
}
