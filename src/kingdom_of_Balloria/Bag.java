package kingdom_of_Balloria;

import java.util.ArrayList;

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
        int counter = 0;
        for (Ball ball : balls) {
            if (ball.isOfGreenColor())
                counter++;
        }
        return counter == 3;

    }

    private boolean isFullOfRedColor() {
        int countOfGreenBalls = getCountOfGreenBalls();
        int counter = 0;
        for (Ball ball : balls) {
            if (ball.isOfRedColor())
                counter++;
        }

        if(countOfGreenBalls == 0)
            return true;
        return counter == (countOfGreenBalls * 2) - 1;

    }

    private int getCountOfGreenBalls() {
        int counter = 0;
        for (Ball ball : balls) {
            if (ball.isOfGreenColor())
                counter++;
        }
        return counter;
    }

    public void addBall(Ball ball) throws BallCantBeAddedBecauseConstraintIsBroken {
        if(ball.isOfGreenColor())
            addGreenColorBall(ball);
        if (ball.isOfRedColor())
            addRedColorBall(ball);
        if(ball.isOfBlueColor())
            addBlueColorBall(ball);
        return;
    }

    private void addBlueColorBall(Ball newBall) throws BallCantBeAddedBecauseConstraintIsBroken {
        if(isFull())
            throw new BallCantBeAddedBecauseConstraintIsBroken();
        balls.add(newBall);
        return;
    }

    private void addRedColorBall(Ball newBall) throws BallCantBeAddedBecauseConstraintIsBroken {
        if(isFull())
            throw new BallCantBeAddedBecauseConstraintIsBroken();
        if(isFullOfRedColor())
            throw new BallCantBeAddedBecauseConstraintIsBroken();
        balls.add(newBall);
    }

    private void addGreenColorBall(Ball newBall) throws BallCantBeAddedBecauseConstraintIsBroken {
        if(isFull())
            throw new BallCantBeAddedBecauseConstraintIsBroken();
        if(isFullOfGreenColor())
            throw new BallCantBeAddedBecauseConstraintIsBroken();
        balls.add(newBall);
    }
}
