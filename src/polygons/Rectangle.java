package polygons;

/*
    job of class :
        calculate any operations which includes length and/or breadth.
 */

import exceptions.InvalidInputException;

public class Rectangle {
    private final double length;
    private final double breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public static Rectangle createRectangle(double length, double breadth) throws InvalidInputException {
        if (length <= 0 || breadth <= 0)
            throw new InvalidInputException();
        else
            return new Rectangle(length, breadth);
    }

    public double calculateArea() {
        return length * breadth;
    }

    public double calculatePerimeter() {
        return 2 * (length + breadth);
    }
}
