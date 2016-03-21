package compare;

public enum LengthUnit implements MeasurementUnit {
    FEET(304.8),
    INCH(25.4),
    CENTIMETER(10),
    MILLIMETER(1);

    private double oneUnitValueInMM;

    LengthUnit(double oneUnitValueInMM) {
        this.oneUnitValueInMM = oneUnitValueInMM;
    }

    public double convertToBase(double value) {
        return Math.round(oneUnitValueInMM * value);
    }

    public double convertToThisUnit(double value) {
        return value/oneUnitValueInMM;
    }
}
