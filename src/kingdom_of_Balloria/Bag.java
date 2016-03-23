package kingdom_of_Balloria;

import java.util.ArrayList;
import java.util.HashMap;

/*
Job Of Class::
to store 12 balls
should give the ball to use
 */
public class Bag {
    ArrayList<Ball> balls = new ArrayList();

    private boolean isFull() {
        return balls.size() == 12;
    }


    private boolean isFullOfGreenColor() {
        return getCountOfSpecificColoredBalls(Color.GREEN) == 3;
    }

    private boolean isFullOfRedColor() {
        int countOfGreenBalls = getCountOfSpecificColoredBalls(Color.GREEN);
        int counter = getCountOfSpecificColoredBalls(Color.RED);
        if(countOfGreenBalls == 0)
            return true;
        return counter == (countOfGreenBalls * 2) - 1;

    }

    private int getCountOfSpecificColoredBalls(Color color){
        int counter = 0;
        for (Ball ball : balls) {
            if(ball.isOfSpecificColor(color))
                counter++;
        }
        return counter;

    }
    public void addBall(Ball ball) throws BagLimitException, GreenBallLimitException, RedBallLimitException, YellowBallLimitException {
        if(ball.isOfSpecificColor(Color.GREEN))
            addGreenColorBall(ball);
        if (ball.isOfSpecificColor(Color.RED))
            addRedColorBall(ball);
        if(ball.isOfSpecificColor(Color.BLUE))
            addBlueColorBall(ball);
        if(ball.isOfSpecificColor(Color.YELLOW))
            addYellowColorBall(ball);
        return;
    }

    private void addYellowColorBall(Ball ball) throws BagLimitException, YellowBallLimitException {
        if(isFull())
            throw new BagLimitException();
        if(isFullOfYellowColor())
            throw new YellowBallLimitException();
        balls.add(ball);
    }

    private boolean isFullOfYellowColor() {
        return getCountOfYellowBalls()+1 > Math.round((40)*(balls.size()+1)/100);
    }

    private int getCountOfYellowBalls() {
        int counter = getCountOfSpecificColoredBalls(Color.YELLOW);
        return counter;
    }

    private void addBlueColorBall(Ball newBall) throws BagLimitException {
        if(isFull())
            throw new BagLimitException();
        balls.add(newBall);
        return;
    }

    private void addRedColorBall(Ball newBall) throws BagLimitException , RedBallLimitException {
        if(isFull())
            throw new BagLimitException();
        if(isFullOfRedColor())
            throw new RedBallLimitException();
        balls.add(newBall);
    }

    private void addGreenColorBall(Ball newBall) throws BagLimitException, GreenBallLimitException {
        if(isFull())
            throw new BagLimitException();
        if(isFullOfGreenColor())
            throw new GreenBallLimitException();
        balls.add(newBall);
    }

    public HashMap<String,Integer> getSummary(SummaryFormat summaryFormat) {
        ArrayList<Character> bagData = new ArrayList<>();
        for (Ball ball : balls) {
            bagData.add(ball.represent());
        }

        return summaryFormat.summarizeBagData(bagData);
    }

}
