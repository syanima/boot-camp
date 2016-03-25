package kingdom_of_Balloria;

import kingdom_of_Balloria.balls.Balls;
import kingdom_of_Balloria.balls.ReadOnlyBalls;
import kingdom_of_Balloria.exceptions.YellowBallRuleViolationException;
import kingdom_of_Balloria.rules.YellowBallRule;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class YellowBallRuleTest {
    private YellowBallRule yellowBallRule;
    private Balls balls;
    private Ball yellowBall;
    private Ball blueBall;

    @Before
    public void setUp() throws Exception {
        yellowBallRule = new YellowBallRule(0.4);
        balls = new Balls();
        yellowBall = Ball.createYellowBall();
        blueBall = Ball.createBlueBall();
    }

    @org.junit.Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void does_not_allow_to_add_a_yellow_ball_when_there_is_no_balls() throws YellowBallRuleViolationException {
        ReadOnlyBalls readOnlyBalls = new ReadOnlyBalls(balls);

        thrown.expect(YellowBallRuleViolationException.class);
        thrown.expectMessage(CoreMatchers.is("Only 0 YELLOW Balls Allowed"));
        yellowBallRule.checkRuleViolationToAddNewBall(yellowBall, readOnlyBalls);
    }

    @Test
    public void allows_only_40_percent_of_the_total_balls_to_be_yellow_ball() throws YellowBallRuleViolationException {
        balls.add(blueBall);
        balls.add(blueBall);
        ReadOnlyBalls readOnlyBalls = new ReadOnlyBalls(balls);
        yellowBallRule.checkRuleViolationToAddNewBall(yellowBall, readOnlyBalls);
        assertTrue(true);
    }
}