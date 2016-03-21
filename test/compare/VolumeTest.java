package compare;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class VolumeTest {

    @Test
    public void should_gives_zero_when_compare_1_gallon_with_3_point_78_liter() throws MeasurementTypeException {
        Volume oneGallon = new Volume(1, VolumeUnit.GALLON);
        Volume threePoint78Liter = new Volume(3.78, VolumeUnit.LITER);
        assertEquals(0,oneGallon.compare(threePoint78Liter));
    }

    @Test
    public void should_gives_1_when_compare_1_gallon_with_1_liter() throws MeasurementTypeException {
        Volume oneGallon = new Volume(1, VolumeUnit.GALLON);
        Volume oneLiter = new Volume(1, VolumeUnit.LITER);
        assertEquals(1,oneGallon.compare(oneLiter));
    }

    @Test
    public void should_gives_minus_1_when_compare_1_gallon_with_2_gallon() throws MeasurementTypeException {
        Volume oneGallon = new Volume(1, VolumeUnit.GALLON);
        Volume twoGallon = new Volume(2, VolumeUnit.GALLON);
        assertEquals(-1,oneGallon.compare(twoGallon));
    }

    @Test
    public void should_add_gallon_with_liter() throws MeasurementTypeException {
        Volume oneGallon = new Volume(1, VolumeUnit.GALLON);
        Volume oneLiter = new Volume(1, VolumeUnit.LITER);
        Volume addedValue = oneGallon.add(oneLiter, VolumeUnit.LITER);
        assertEquals(0,addedValue.compare(new Volume(4.78, VolumeUnit.LITER)));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_MeasurementTypeException_when_volume_is_compared_with_length() throws MeasurementTypeException {
        thrown.expect(MeasurementTypeException.class);
        thrown.expectMessage(CoreMatchers.is("Cannot compare two different measurement"));
        Volume oneGallon = new Volume( 1, VolumeUnit.GALLON );
        Length oneInch = new Length( 1, LengthUnit.INCH );
        oneGallon.compare(oneInch);
    }
}