package kingdom_of_Balloria;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BallTest {
    @Test
    public void should_give_true_when_ball_color_matches_the_given_color() {
        Ball redBall = Ball.createRedBall();

        assertTrue(redBall.isOfColor(Color.RED));
        assertFalse(redBall.isOfColor(Color.GREEN));
    }

    @Test
    public void should_give_red_ball_when_createRedBall_is_called() {
        Ball redBall = Ball.createRedBall();
        assertTrue(redBall.isOfColor(Color.RED));
    }
    @Test
    public void should_give_green_ball_when_createGreenBall_is_called() {
        Ball redBall = Ball.createGreenBall();
        assertTrue(redBall.isOfColor(Color.GREEN));
    }
    @Test
    public void should_give_blue_ball_when_createBlueBall_is_called() {
        Ball redBall = Ball.createBlueBall();
        assertTrue(redBall.isOfColor(Color.BLUE));
    }
    @Test
    public void should_give_yellow_ball_when_createYellowBall_is_called() {
        Ball redBall = Ball.createYellowBall();
        assertTrue(redBall.isOfColor(Color.YELLOW));
    }
}