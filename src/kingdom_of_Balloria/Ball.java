package kingdom_of_Balloria;

public class Ball {
    private Color color;

    public Ball(Color color) {

        this.color = color;
    }

    public boolean isOfSpecificColor(Color colorToBeChecked) {
        return color == colorToBeChecked;
    }

    public char represent() {
        return color.represent();
    }


}
