package compare;

//Adds 2 Length

public class Length extends Measurement<Length, LengthUnit> {

    public Length(double value, LengthUnit unit) {
        super(value, unit);
    }

    @Override
    protected Length createMeasurement(double sum, LengthUnit resultUnit) {
        return new Length(resultUnit.convertToThisUnit(sum), resultUnit);
    }
}
