package kingdom_of_Balloria;

import kingdom_of_Balloria.balls.Balls;
import kingdom_of_Balloria.balls.ReadOnlyBalls;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReadOnlyBallsTest {
    private Ball blueBall;
    private Ball greenBall;
    private Ball redBall;
    private Ball yellowBall;
    private Balls balls;

    @Before
    public void setUp() throws Exception {
        blueBall = Ball.createBlueBall();
        greenBall = Ball.createGreenBall();
        redBall = Ball.createRedBall();
        yellowBall = Ball.createYellowBall();
        balls = new Balls();
    }

    @Test
    public void should_tell_the_no_of_balls_it_has() {
        balls.add(blueBall);
        balls.add(greenBall);
        balls.add(blueBall);

        ReadOnlyBalls readOnlyBalls = new ReadOnlyBalls(balls);
        assertEquals(3, readOnlyBalls.size());
    }

    @Test
    public void should_give_the_count_of_balls_of_a_particular_color() {
        balls.add(blueBall);
        balls.add(greenBall);
        balls.add(blueBall);
        balls.add(yellowBall);
        balls.add(greenBall);
        balls.add(redBall);

        ReadOnlyBalls readOnlyBalls = new ReadOnlyBalls(balls);
        assertEquals(2, readOnlyBalls.countOf(Color.GREEN));
        assertEquals(1, readOnlyBalls.countOf(Color.YELLOW));
        assertEquals(1, readOnlyBalls.countOf(Color.RED));
        assertEquals(2, readOnlyBalls.countOf(Color.BLUE));
    }
}