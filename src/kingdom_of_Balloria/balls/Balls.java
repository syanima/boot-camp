package kingdom_of_Balloria.balls;

import kingdom_of_Balloria.Ball;
import kingdom_of_Balloria.Color;

import java.util.ArrayList;

public class Balls {
    private final ArrayList<Ball> balls;

    public Balls() {
        balls = new ArrayList<Ball>();
    }

    public boolean add(Ball ball) {
        return balls.add(ball);
    }

    public int size() {
        return balls.size();
    }

    public int countOf(Color color) {
        int count = 0;
        for (Ball ball : balls) {
            if (ball.isOfColor(color))
                count++;
        }
        return count;
    }
}
