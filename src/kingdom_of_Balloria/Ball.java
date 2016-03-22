package kingdom_of_Balloria;

public class Ball {
    private Color color;

    public Ball(Color color) {

        this.color = color;
    }

    public boolean isOfGreenColor(){
        return color == Color.GREEN;
    }

    public boolean isOfRedColor(){
        return color == Color.RED;
    }

    public boolean isOfBlueColor(){
        return color == Color.BLUE;
    }

    public void use(){
    }
}
