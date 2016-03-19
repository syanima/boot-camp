package compare;

import exceptions.MeasurementTypeException;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class MeasurementTest {
    @Test
    public void should_add_2_inch_and_2_inch_and_gives_4_inch() throws Exception, MeasurementTypeException {
        Measurement twoInches = new Measurement(2, LengthUnit.INCH);
        assertTrue(twoInches.add(twoInches, LengthUnit.INCH).equals(new Measurement(4, LengthUnit.INCH)));
    }

    @Test
    public void should_add_2_inch_and_2_and_half_centimeter_and_gives_3_inch() throws Exception, MeasurementTypeException {
        Measurement twoInches = new Measurement(2, LengthUnit.INCH);
        Measurement twoAndHalfCM = new Measurement(2.5, LengthUnit.CENTIMETER);
        assertTrue(twoInches.add(twoAndHalfCM, LengthUnit.INCH).equals(new Measurement(3, LengthUnit.INCH)));
    }

    @Test
    public void should_add_1_gallon_and_1_liter_and_gives_4_78_liter() throws Exception, MeasurementTypeException {
        Measurement oneGallon = new Measurement(1, VolumeUnit.GALLON);
        Measurement oneLiter = new Measurement(1, VolumeUnit.LITER);
        assertTrue(oneGallon.add(oneLiter, VolumeUnit.LITER).equals(new Measurement(4.78, VolumeUnit.LITER)));
    }

    @Test
    public void should_compare_feet_with_inches() throws Exception, MeasurementTypeException {
        Measurement sixtyInch = new Measurement(60, LengthUnit.INCH);
        Measurement fiveFeet = new Measurement(5, LengthUnit.FEET);
        assertTrue(fiveFeet.compare(sixtyInch));
    }

    @Test
    public void should_compare_inches_with_centimeter() throws Exception, MeasurementTypeException {
        Measurement twoInch = new Measurement(2, LengthUnit.INCH);
        Measurement fiveCm = new Measurement(5.08, LengthUnit.CENTIMETER);
        assertTrue(twoInch.compare(fiveCm));
    }

    @Test
    public void should_compare_centimeter_with_millimeter() throws Exception, MeasurementTypeException {
        Measurement oneCm = new Measurement(1, LengthUnit.CENTIMETER);
        Measurement tenMm = new Measurement(10, LengthUnit.MILLIMETER);
        assertTrue(oneCm.compare(tenMm));
    }

    @Test
    public void should_compare_gallon_with_liter() throws MeasurementTypeException {
        Measurement oneGallon = new Measurement(1, VolumeUnit.GALLON);
        Measurement threePoint78Liter = new Measurement(3.78, VolumeUnit.LITER);
        assertTrue(oneGallon.compare(threePoint78Liter));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_MeasurementTypeException_when_volume_is_compared_with_length() throws MeasurementTypeException {
        thrown.expect(MeasurementTypeException.class);
        thrown.expectMessage(CoreMatchers.is("Cannot compare two different measurement"));
        Measurement oneGallon = new Measurement(1, VolumeUnit.GALLON);
        Measurement oneInch = new Measurement(1, LengthUnit.INCH);
        oneGallon.compare(oneInch);
    }
}
