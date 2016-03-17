import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;


public class RectangleTest {

    private Rectangle rectangle;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws InvalidInputException {
        rectangle = Rectangle.createRectangle(2.5, 3);

    }

    @Test
    public void calculatesAreaOfTheRectangle() throws Exception {
        assertEquals(7.5, rectangle.calculateArea(), 0.0);
    }

    @Test
    public void calculatesPerimeterOfTheRectangle() throws Exception {
        assertEquals(11.0, rectangle.calculatePerimeter(), 0.0);
    }

    @Test
    public void InvalidInputExceptionShouldGenerateWhenAtleastAnyOfTheDimensionsOfRectangleIsZeroOrLessThanZero()throws InvalidInputException{
        exception.expectMessage(CoreMatchers.is("Invalid input ,only positive values are allowed"));
        exception.expect(InvalidInputException.class);

        Rectangle.createRectangle(0,0);
    }

}

