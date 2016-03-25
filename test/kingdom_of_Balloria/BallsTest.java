package kingdom_of_Balloria;

import kingdom_of_Balloria.balls.Balls;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BallsTest {

    private Ball blueBall;
    private Ball yellowBall;
    private Ball redBall;
    private Ball greenBall;

    @Before
    public void setUp() throws Exception {
        blueBall = Ball.createBlueBall();
        greenBall = Ball.createGreenBall();
        redBall = Ball.createRedBall();
        yellowBall = Ball.createYellowBall();
    }

    @Test
    public void should_return_true_when_a_ball_is_added() {
        Balls balls = new Balls();
        assertTrue(balls.add(redBall));
    }

    @Test
    public void should_tell_the_no_of_balls_it_has() {
        Balls balls = new Balls();
        balls.add(blueBall);
        balls.add(greenBall);
        balls.add(blueBall);

        assertEquals(3, balls.size());
    }

    @Test
    public void should_give_the_count_of_balls_of_a_particular_color() {
        Balls balls = new Balls();
        balls.add(blueBall);
        balls.add(greenBall);
        balls.add(blueBall);
        balls.add(yellowBall);
        balls.add(greenBall);
        balls.add(redBall);

        assertEquals(2, balls.countOf(Color.GREEN));
        assertEquals(1, balls.countOf(Color.YELLOW));
        assertEquals(1, balls.countOf(Color.RED));
        assertEquals(2, balls.countOf(Color.BLUE));
    }
}
