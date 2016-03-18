package shapes;
/*
    job of class :
        calculate any operations which includes side of the square.
 */

import exception.InvalidInputException;

public class Square extends Rectangle {

    private Square(double side) {
        super(side,side);
    }

    public static Square createSquare(double side) throws InvalidInputException {
        if (side <= 0)
            throw new InvalidInputException();
         else
            return new Square(side);
    }


}

