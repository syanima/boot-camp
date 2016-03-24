package kingdom_of_Balloria.balls;

import kingdom_of_Balloria.Color;
import kingdom_of_Balloria.balls.Balls;

public class ReadOnlyBalls {

    private final Balls balls;

    public ReadOnlyBalls(Balls balls) {
        this.balls = balls;
    }

    public int size() {
        return balls.size();
    }

    public int countOf(Color color) {
        return balls.countOf(color);
    }
}