package compare;

public class Length implements Measurement{
    private LengthUnit unit;
    private double value;

    public Length(LengthUnit unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public double inBaseUnit(){
        return unit.inBaseUnit(value);
    }
    public boolean compare(Measurement anotherLength){
        return unit.inBaseUnit(value) == anotherLength.inBaseUnit();
    }

    public Length add(Length anotherLength, LengthUnit resultUnit){
        double sum = inBaseUnit() + anotherLength.inBaseUnit();
        return new Length(resultUnit, convertTo(resultUnit, sum));
    }

    private double convertTo(LengthUnit lengthUnit,double value){
        return value/lengthUnit.inBaseUnit(1);
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Length)) return false;
        Length givenLength = (Length) obj;
        if(givenLength.unit != unit) return false;
        return Math.round(value) == Math.round(givenLength.value);
    }
}