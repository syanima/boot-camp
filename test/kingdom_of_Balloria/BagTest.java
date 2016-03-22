package kingdom_of_Balloria;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BagTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_add_the_ball() throws BallCantBeAddedBecauseConstraintIsBroken {
        Bag bag = new Bag();
        Ball greenBall = new Ball(Color.GREEN);
        bag.addBall(greenBall);

    }


    @Test
    public void should_throw_exception_if_the_green_color_ball_cant_be_added() throws BallCantBeAddedBecauseConstraintIsBroken {
        thrown.expect(BallCantBeAddedBecauseConstraintIsBroken.class);
        Bag bag = new Bag();
        Ball greenColorBall = new Ball(Color.GREEN);
        bag.addBall(greenColorBall);
        bag.addBall(greenColorBall);
        bag.addBall(greenColorBall);
        bag.addBall(greenColorBall);
    }





    @Test
    public void should_add_12_blue_color_balls() throws BallCantBeAddedBecauseConstraintIsBroken {
        Bag bag = new Bag();

        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));

    }

    @Test
    public void should_throw_exception_when_13_ball_is_added() throws BallCantBeAddedBecauseConstraintIsBroken {
        thrown.expect(BallCantBeAddedBecauseConstraintIsBroken.class);
        Bag bag = new Bag();

        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));
        bag.addBall(new Ball(Color.BLUE));

    }

    @Test
    public void should_throw_exception_if_the_red_color_ball_cant_be_added() throws BallCantBeAddedBecauseConstraintIsBroken {
        thrown.expect(BallCantBeAddedBecauseConstraintIsBroken.class);

        Bag bag = new Bag();
        Ball greenColorBall = new Ball(Color.GREEN);
        Ball redColorBall = new Ball(Color.RED);

        bag.addBall(greenColorBall);
        bag.addBall(greenColorBall);
        bag.addBall(redColorBall);
        bag.addBall(redColorBall);
        bag.addBall(redColorBall);
        bag.addBall(redColorBall);
    }


    @Test
    public void should_throw_exception_if_a_red_ball_is_added_when_there_is_no_green_ball() throws BallCantBeAddedBecauseConstraintIsBroken {
        thrown.expect(BallCantBeAddedBecauseConstraintIsBroken.class);
        Bag bag = new Bag();
        Ball redBall = new Ball(Color.RED);
        bag.addBall(redBall);
    }
}
