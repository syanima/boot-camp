package compare;

import exceptions.MeasurementTypeException;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class LengthTest {
    @Test
    public void should_add_2_inch_and_2_inch_and_gives_4_inch() throws Exception, MeasurementTypeException {
        Length twoInches = new Length( 2, LengthUnit.INCH );
        assertTrue(twoInches.add(twoInches, LengthUnit.INCH).equals(new Length( 4, LengthUnit.INCH )));
    }

    @Test
    public void should_add_2_inch_and_2_and_half_centimeter_and_gives_3_inch() throws Exception, MeasurementTypeException {
        Length twoInches = new Length( 2, LengthUnit.INCH );
        Length twoAndHalfCM = new Length( 2.5, LengthUnit.CENTIMETER );
        assertTrue(twoInches.add(twoAndHalfCM, LengthUnit.INCH).equals(new Length( 3, LengthUnit.INCH )));
    }

    @Test
    public void should_compare_feet_with_inches() throws Exception, MeasurementTypeException {
        Length sixtyInch = new Length( 60, LengthUnit.INCH );
        Length fiveFeet = new Length( 5, LengthUnit.FEET );
        assertTrue(fiveFeet.compare(sixtyInch));
    }

    @Test
    public void should_compare_inches_with_centimeter() throws Exception, MeasurementTypeException {
        Length twoInch = new Length( 2, LengthUnit.INCH );
        Length fiveCm = new Length( 5.08, LengthUnit.CENTIMETER );
        assertTrue(twoInch.compare(fiveCm));
    }

    @Test
    public void should_compare_centimeter_with_millimeter() throws Exception, MeasurementTypeException {
        Length oneCm = new Length( 1, LengthUnit.CENTIMETER );
        Length tenMm = new Length( 10, LengthUnit.MILLIMETER );
        assertTrue(oneCm.compare(tenMm));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_MeasurementTypeException_when_length_is_compared_with_volume() throws MeasurementTypeException {
        thrown.expect(MeasurementTypeException.class);
        thrown.expectMessage(CoreMatchers.is("Cannot compare two different measurement"));
        Volume oneGallon = new Volume( 1, VolumeUnit.GALLON );
        Length oneInch = new Length( 1, LengthUnit.INCH );
        oneInch.compare(oneGallon);
    }
}
