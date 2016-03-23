package kingdom_of_Balloria;

import exceptions.BallCantBeAddedBecauseConstraintIsBroken;

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
    public void addBall(Ball ball) throws BallCantBeAddedBecauseConstraintIsBroken {
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

    private void addYellowColorBall(Ball ball) throws BallCantBeAddedBecauseConstraintIsBroken {
        if(isFull())
            throw new BallCantBeAddedBecauseConstraintIsBroken("The Bag is full. You can't add any more balls.");
        if(isFullOfYellowColor())
            throw new BallCantBeAddedBecauseConstraintIsBroken("The Bag cannot add Yellow Ball at this point");
        balls.add(ball);
    }

    private boolean isFullOfYellowColor() {
        return getCountOfYellowBalls()+1 > Math.round((40)*(balls.size()+1)/100);
    }

    private int getCountOfYellowBalls() {
        int counter = getCountOfSpecificColoredBalls(Color.YELLOW);
        return counter;
    }

    private void addBlueColorBall(Ball newBall) throws BallCantBeAddedBecauseConstraintIsBroken {
        if(isFull())
            throw new BallCantBeAddedBecauseConstraintIsBroken("The Bag is full. You can't add any more balls.");
        balls.add(newBall);
        return;
    }

    private void addRedColorBall(Ball newBall) throws BallCantBeAddedBecauseConstraintIsBroken {
        if(isFull())
            throw new BallCantBeAddedBecauseConstraintIsBroken("The Bag is full. You can't add any more balls.");
        if(isFullOfRedColor())
            throw new BallCantBeAddedBecauseConstraintIsBroken("The Bag cannot add Red Ball at this point.");
        balls.add(newBall);
    }

    private void addGreenColorBall(Ball newBall) throws BallCantBeAddedBecauseConstraintIsBroken {
        if(isFull())
            throw new BallCantBeAddedBecauseConstraintIsBroken("The Bag is full. You can't add any more balls.");
        if(isFullOfGreenColor())
            throw new BallCantBeAddedBecauseConstraintIsBroken("The Bag cannot contain more than 3 Green Balls.");
        balls.add(newBall);
    }

    public HashMap<String,Integer> getSummary() {
        HashMap<String,Integer> summary = new HashMap<>();
        summary.put("Bag",balls.size());
        summary.put("Blue",getCountOfSpecificColoredBalls(Color.BLUE));
        summary.put("Green",getCountOfSpecificColoredBalls(Color.GREEN));
        summary.put("Red",getCountOfSpecificColoredBalls(Color.RED));
        summary.put("Yellow",getCountOfSpecificColoredBalls(Color.YELLOW));
        return summary;
    }

    public ArrayList<Character> getOrderedSummary(){
        ArrayList<Character> orderedSummary = new ArrayList<>();
        for (Ball ball : balls) {
            orderedSummary.add(ball.represent());
        }
        return orderedSummary;
    }

}
