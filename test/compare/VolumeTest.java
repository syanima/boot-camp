package compare;

import exceptions.MeasurementTypeException;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class VolumeTest {

    @Test
    public void should_compare_gallon_with_liter() throws MeasurementTypeException {
        Volume oneGallon = new Volume(1, VolumeUnit.GALLON);
        Volume threePoint78Liter = new Volume(3.78, VolumeUnit.LITER);
        assertTrue(oneGallon.compare(threePoint78Liter));
    }

    @Test
    public void should_add_gallon_with_liter() throws MeasurementTypeException {
        Volume oneGallon = new Volume(1, VolumeUnit.GALLON);
        Volume oneLiter = new Volume(1, VolumeUnit.LITER);
        assertTrue(oneGallon.add(oneLiter, VolumeUnit.LITER).equals(new Volume(4.78, VolumeUnit.LITER)));
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
