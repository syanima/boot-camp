package compare;

//Adds 2 Length
public class Length extends Measurement<Length, LengthUnit> {

    public Length(double value, LengthUnit unit) {
        super(value, unit);
    }

    @Override
    public Length add(Length anotherLength, LengthUnit resultUnit) {
        double sum = super.convertToBase() + anotherLength.convertToBase();
        return new Length(resultUnit.convertToThis(sum), resultUnit);
    }
}
