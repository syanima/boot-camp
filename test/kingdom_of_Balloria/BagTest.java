package kingdom_of_Balloria;

import kingdom_of_Balloria.exceptions.BagFullException;
import kingdom_of_Balloria.exceptions.GreenBallRuleViolationException;
import kingdom_of_Balloria.exceptions.RuleViolationForColorException;
import kingdom_of_Balloria.rules.*;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class BagTest {

    private Ball blueBall;
    private Ball yellowBall;
    private Ball redBall;
    private Ball greenBall;
    private ReadOnlyRules readOnlyRules;

    @Before
    public void setUp() throws Exception {
        blueBall = Ball.createBlueBall();
        greenBall = Ball.createGreenBall();
        redBall = Ball.createRedBall();
        yellowBall = Ball.createYellowBall();

        Rules rules = new Rules();
        rules.addRule(new GreenBallRule(3));
        rules.addRule(new RedBallRule());
        rules.addRule(new YellowBallRule(0.4));

        readOnlyRules = new ReadOnlyRules(rules);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_be_able_to_add_ball_upto_the_given_limit() throws BagFullException, RuleViolationForColorException {
        Bag bag = new Bag(3, readOnlyRules);

        assertTrue(bag.add(blueBall));
        assertTrue(bag.add(blueBall));
        assertTrue(bag.add(blueBall));

        thrown.expect(BagFullException.class);
        thrown.expectMessage(CoreMatchers.is("Bag can hold only 3 Balls"));
        bag.add(greenBall);
    }

    @Test
    public void should_throw_exception_when_more_than_3_green_ball_is_added() throws RuleViolationForColorException, BagFullException {
        Bag bag = new Bag(10, readOnlyRules);

        assertTrue(bag.add(greenBall));
        assertTrue(bag.add(greenBall));
        assertTrue(bag.add(greenBall));

        thrown.expect(GreenBallRuleViolationException.class);
        thrown.expectMessage(CoreMatchers.is("Only 3 GREEN Balls Allowed"));
        bag.add(greenBall);
    }
}
