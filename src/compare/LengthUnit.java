package compare;

public enum LengthUnit {
    FEET(304.8),
    INCH(25.4),
    CENTIMETER(10),
    MILLIMETER(1);

    private double oneUnitValueInMM;

    LengthUnit(double oneUnitValueInMM) {
        this.oneUnitValueInMM = oneUnitValueInMM;
    }
    public double inBaseUnit(double value){
        return oneUnitValueInMM * value;
    };
}