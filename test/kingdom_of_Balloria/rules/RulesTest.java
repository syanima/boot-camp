package kingdom_of_Balloria.rules;

import kingdom_of_Balloria.Ball;
import kingdom_of_Balloria.balls.Balls;
import kingdom_of_Balloria.balls.ReadOnlyBalls;
import kingdom_of_Balloria.exceptions.GreenBallRuleViolationException;
import kingdom_of_Balloria.exceptions.RedBallRuleViolationException;
import kingdom_of_Balloria.exceptions.RuleViolationForColorException;
import kingdom_of_Balloria.exceptions.YellowBallRuleViolationException;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class RulesTest {

    private GreenBallRule greenBallRule;
    private Balls balls;
    private Rules rules;
    private Ball yellowBall;
    private Ball redBall;
    private Ball greenBall;
    private Ball blueBall;

    @Before
    public void setUp() throws Exception {
        rules = new Rules();
        rules.addRule(new GreenBallRule(3));
        rules.addRule(new RedBallRule());
        rules.addRule(new YellowBallRule(0.4));

        greenBall = Ball.createGreenBall();
        redBall = Ball.createRedBall();
        yellowBall = Ball.createYellowBall();
        blueBall = Ball.createBlueBall();

        balls = new Balls();
    }

    @org.junit.Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_not_does_anything_when_green_ball_rule_is_not_violated() throws RuleViolationForColorException {
        balls.add(greenBall);
        balls.add(blueBall);

        ReadOnlyBalls readOnlyBalls = new ReadOnlyBalls(balls);

        rules.cryWhenRuleViolated(greenBall, readOnlyBalls);

        assertTrue(true);
    }

    @Test
    public void should_throw_exception_when_green_ball_rule_is_violated() throws RuleViolationForColorException {
        balls.add(greenBall);
        balls.add(greenBall);
        balls.add(greenBall);

        ReadOnlyBalls readOnlyBalls = new ReadOnlyBalls(balls);

        thrown.expect(GreenBallRuleViolationException.class);
        thrown.expectMessage(CoreMatchers.is("Only 3 GREEN Balls Allowed"));

        rules.cryWhenRuleViolated(greenBall, readOnlyBalls);
    }

    @Test
    public void should_throw_exception_when_red_ball_rule_is_violated() throws RuleViolationForColorException {
        balls.add(greenBall);
        balls.add(greenBall);
        balls.add(redBall);
        balls.add(redBall);
        balls.add(redBall);

        ReadOnlyBalls readOnlyBalls = new ReadOnlyBalls(balls);

        thrown.expect(RedBallRuleViolationException.class);
        thrown.expectMessage(CoreMatchers.is("Only 3 RED Balls Allowed"));

        rules.cryWhenRuleViolated(redBall, readOnlyBalls);
    }

    @Test
    public void should_not_do_anything_when_red_ball_rule_is_not_violated() throws RuleViolationForColorException {
        balls.add(greenBall);
        balls.add(greenBall);
        balls.add(redBall);
        balls.add(redBall);

        ReadOnlyBalls readOnlyBalls = new ReadOnlyBalls(balls);

        rules.cryWhenRuleViolated(redBall, readOnlyBalls);

        assertTrue(true);
    }

    @Test
    public void should_throw_exception_when_yellow_ball_rule_is_violated() throws RuleViolationForColorException {
        balls.add(greenBall);
        balls.add(greenBall);
        balls.add(yellowBall);
        balls.add(yellowBall);

        ReadOnlyBalls readOnlyBalls = new ReadOnlyBalls(balls);

        thrown.expect(YellowBallRuleViolationException.class);
        thrown.expectMessage(CoreMatchers.is("Only 2 YELLOW Balls Allowed"));

        rules.cryWhenRuleViolated(yellowBall, readOnlyBalls);
    }

    @Test
    public void should_not_does_anything_when_yellow_ball_rule_is_not_violated() throws RuleViolationForColorException {
        balls.add(greenBall);
        balls.add(greenBall);
        balls.add(blueBall);

        ReadOnlyBalls readOnlyBalls = new ReadOnlyBalls(balls);

        rules.cryWhenRuleViolated(yellowBall, readOnlyBalls);
        assertTrue(true);
    }
}
