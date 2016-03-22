package kingdom_of_Balloria;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class BallTest {
    @Test
    public void checking_ball_can_be_used() {
        Ball red = new Ball(Color.RED);
        red.use();
    }

    @Test
    public void should_return_true_only_if_the_ball_is_of_same_color() {
        Ball greenBall = new Ball(Color.GREEN);
        assertTrue(greenBall.isOfGreenColor());
    }

    @Test
    public void should_return_false_if_the_ball_is_of_different_color() {
        Ball greenBall = new Ball(Color.GREEN);
        assertFalse(greenBall.isOfRedColor());
        assertFalse(greenBall.isOfBlueColor());
    }
}
