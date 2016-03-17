public class Square {
    private double side;

    private Square(double side) {
        this.side = side;
    }

    public static Square createSquare(double side) throws InvalidInputException {
        if (side <= 0) {
            throw new InvalidInputException();
        } else
            return new Square(side);
    }

    public double calculateArea() {
        return side * side;
    }

    public double calculatePerimeter() {
        return 4 * side;
    }
}

