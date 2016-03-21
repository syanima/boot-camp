package compare;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class LengthTest {
    @Test
    public void should_add_2_inch_and_2_inch_and_gives_4_inch() throws Exception, MeasurementTypeException {
        Length twoInches = new Length(2, LengthUnit.INCH);
        Length addedValue = twoInches.add(twoInches, LengthUnit.INCH);
        assertEquals(0, addedValue.compare(new Length(4, LengthUnit.INCH)));
    }

    @Test
    public void should_add_2_inch_and_2_and_half_centimeter_and_gives_3_inch() throws Exception, MeasurementTypeException {
        Length twoInches = new Length(2, LengthUnit.INCH);
        Length twoAndHalfCM = new Length(2.5, LengthUnit.CENTIMETER);
        Length addedValue = twoInches.add(twoAndHalfCM, LengthUnit.INCH);
        assertEquals(0, addedValue.compare(new Length(3, LengthUnit.INCH)));
    }

    @Test
    public void should_gives_zero_when_5_feet_is_compared_with_60_inches() throws Exception, MeasurementTypeException {
        Length sixtyInch = new Length(60, LengthUnit.INCH);
        Length fiveFeet = new Length(5, LengthUnit.FEET);
        assertEquals(0, fiveFeet.compare(sixtyInch));
    }

    @Test
    public void should_gives_1_when_5_feet_is_compared_with_30_inches() throws Exception, MeasurementTypeException {
        Length _30Inch = new Length(30, LengthUnit.INCH);
        Length fiveFeet = new Length(5, LengthUnit.FEET);
        assertEquals(1, fiveFeet.compare(_30Inch));
    }

    @Test
    public void should_gives_minus_1_when_5_feet_is_compared_with_80_inches() throws Exception, MeasurementTypeException {
        Length _80Inch = new Length(80, LengthUnit.INCH);
        Length fiveFeet = new Length(5, LengthUnit.FEET);
        assertEquals(-1, fiveFeet.compare(_80Inch));
    }

    @Test
    public void should_gives_zero_when_2_inches_compared_with_5_point_08_centimeter() throws Exception, MeasurementTypeException {
        Length twoInch = new Length(2, LengthUnit.INCH);
        Length fiveCm = new Length(5.08, LengthUnit.CENTIMETER);
        assertEquals(0, twoInch.compare(fiveCm));
    }

    @Test
    public void should_gives_zero_when_1_centimeter_compared_with_10_millimeter() throws Exception, MeasurementTypeException {
        Length oneCm = new Length(1, LengthUnit.CENTIMETER);
        Length tenMm = new Length(10, LengthUnit.MILLIMETER);
        assertEquals(0, oneCm.compare(tenMm));
    }

    @Test
    public void should_gives_1_when_1_centimeter_compared_with_8_millimeter() throws Exception, MeasurementTypeException {
        Length oneCm = new Length(1, LengthUnit.CENTIMETER);
        Length eightMm = new Length(8, LengthUnit.MILLIMETER);
        assertEquals(1, oneCm.compare(eightMm));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_MeasurementTypeException_when_length_is_compared_with_volume() throws MeasurementTypeException {
        thrown.expect(MeasurementTypeException.class);
        thrown.expectMessage(CoreMatchers.is("Cannot compare two different measurement"));
        Volume oneGallon = new Volume(1, VolumeUnit.GALLON);
        Length oneInch = new Length(1, LengthUnit.INCH);
        oneInch.compare(oneGallon);
    }
}