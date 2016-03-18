package shapes;

import exception.InvalidInputException;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class SquareTest {

    private Square square;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws InvalidInputException {
        square =Square.createSquare(3);

    }
    @Test
    public void calculatesAreaOfSquare() {
        assertEquals(9,square.calculateArea(),0.0);

    }

    @Test
    public void calculatesPerimeterOfSquare() {
        assertEquals(12,square.calculatePerimeter(),0.0);
    }

    @Test
    public void generateInvalidInputExceptionWhenSideIsNonPositive() throws InvalidInputException {
        exception.expectMessage(CoreMatchers.is("Invalid input ,only positive values are allowed"));
        exception.expect(InvalidInputException.class);

        Square.createSquare(0);
    }
}