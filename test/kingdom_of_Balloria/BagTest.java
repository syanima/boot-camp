//package kingdom_of_Balloria;
//
//import kingdom_of_Balloria.exceptions.BagLimitException;
//import kingdom_of_Balloria.exceptions.GreenBallLimitException;
//import kingdom_of_Balloria.exceptions.RedBallLimitException;
//import kingdom_of_Balloria.exceptions.YellowBallLimitException;
//import org.hamcrest.CoreMatchers;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//
//import java.util.HashMap;
//
//import static junit.framework.TestCase.assertEquals;
//
//public class BagTest {
//
//    @Rule
//    public ExpectedException thrown = ExpectedException.none();
//
//    @Test
//    public void should_add_the_ball() throws BagLimitException, YellowBallLimitException, RedBallLimitException, GreenBallLimitException {
//        Bag bag = new Bag();
//        Ball greenBall = new Ball(Color.GREEN);
//        bag.addBall(greenBall);
//
//    }
//
//
//    @Test
//    public void should_throw_exception_if_the_green_color_ball_cant_be_added() throws GreenBallLimitException, BagLimitException, YellowBallLimitException, RedBallLimitException {
//        thrown.expect(GreenBallLimitException.class);
//        thrown.expectMessage(CoreMatchers.is("The Bag cannot contain more than 3 Green Balls."));
//        Bag bag = new Bag();
//        Ball greenColorBall = new Ball(Color.GREEN);
//        bag.addBall(greenColorBall);
//        bag.addBall(greenColorBall);
//        bag.addBall(greenColorBall);
//        bag.addBall(greenColorBall);
//    }
//
//
//    @Test
//    public void should_add_12_blue_color_balls() throws BagLimitException, YellowBallLimitException, RedBallLimitException, GreenBallLimitException {
//        Bag bag = new Bag();
//
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//
//    }
//
//    @Test
//    public void should_throw_exception_when_13_ball_is_added() throws BagLimitException, YellowBallLimitException, RedBallLimitException, GreenBallLimitException {
//        thrown.expect(BagLimitException.class);
//        thrown.expectMessage(CoreMatchers.is("The Bag is full. You can't add any more balls."));
//
//        Bag bag = new Bag();
//
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//
//    }
//
//    @Test
//    public void should_throw_exception_if_the_red_color_ball_cant_be_added() throws RedBallLimitException, BagLimitException, GreenBallLimitException, YellowBallLimitException {
//        thrown.expect(RedBallLimitException.class);
//        thrown.expectMessage(CoreMatchers.is("The Bag cannot add Red Ball at this point."));
//
//
//        Bag bag = new Bag();
//        Ball greenColorBall = new Ball(Color.GREEN);
//        Ball redColorBall = new Ball(Color.RED);
//
//        bag.addBall(greenColorBall);
//        bag.addBall(greenColorBall);
//        bag.addBall(redColorBall);
//        bag.addBall(redColorBall);
//        bag.addBall(redColorBall);
//        bag.addBall(redColorBall);
//    }
//
//
//    @Test
//    public void should_throw_exception_if_a_red_ball_is_added_when_there_is_no_green_ball() throws RedBallLimitException, BagLimitException, GreenBallLimitException, YellowBallLimitException {
//        thrown.expect(RedBallLimitException.class);
//        thrown.expectMessage(CoreMatchers.is("The Bag cannot add Red Ball at this point."));
//
//        Bag bag = new Bag();
//        Ball redBall = new Ball(Color.RED);
//        bag.addBall(redBall);
//    }
//
//    @Test
//    public void should_add_yellow_ball_when_the_bag_contains_eight_ball() throws BagLimitException, YellowBallLimitException, RedBallLimitException, GreenBallLimitException {
//        Bag bag = new Bag();
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.YELLOW));
//    }
//
//    @Test
//    public void should_throw_exception_if_a_yellow_ball_is_added_cannot_be_added() throws YellowBallLimitException, BagLimitException, GreenBallLimitException, RedBallLimitException {
//        thrown.expect(YellowBallLimitException.class);
//        thrown.expectMessage(CoreMatchers.is("The Bag cannot add Yellow Ball at this point"));
//
//        Bag bag = new Bag();
//        Ball blueBall = new Ball(Color.BLUE);
//        Ball yellowBall = new Ball(Color.YELLOW);
//        bag.addBall(blueBall);
//        bag.addBall(yellowBall);
//    }
//
//    @Test
//    public void should_return_summary_of_the_bag_telling_how_much_balls_are_contained() throws BagLimitException, YellowBallLimitException, RedBallLimitException, GreenBallLimitException {
//        Bag bag = new Bag();
//
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.BLUE));
//        bag.addBall(new Ball(Color.GREEN));
//        bag.addBall(new Ball(Color.GREEN));
//        bag.addBall(new Ball(Color.RED));
//        bag.addBall(new Ball(Color.YELLOW));
//        HashMap<String, Integer> expected = new HashMap<>();
//        expected.put("Bag", 8);
//        expected.put("Blue", 4);
//        expected.put("Green", 2);
//        expected.put("Red", 1);
//        expected.put("Yellow", 1);
//        SummaryFormat summaryFormat = new OrderedByColorSummary();
//        assertEquals(expected, bag.getSummary(summaryFormat));
//    }
//
//
//}
//
