package compare;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LengthTest {

    @Test
    public void should_add_2_inch_and_2_inch_and_gives_4_inch() throws Exception {
        Length twoInches = new Length(LengthUnit.INCH, 2);
        assertTrue(twoInches.add(twoInches, LengthUnit.INCH).equals(new Length(LengthUnit.INCH, 4)));
    }

    @Test
    public void should_add_2_inch_and_2_and_half_centimeter_and_gives_3_inch() throws Exception {
        Length twoInches = new Length(LengthUnit.INCH, 2);
        Length twoAndHalfCM = new Length(LengthUnit.CENTIMETER, 2.5);
        assertTrue(twoInches.add(twoAndHalfCM, LengthUnit.INCH).equals(new Length(LengthUnit.INCH, 3)));
    }
}