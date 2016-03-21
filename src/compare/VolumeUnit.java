package compare;

public enum VolumeUnit implements MeasurementUnit {
    GALLON(3780),
    LITER(1000);

    private double oneUnitValueInML;

    VolumeUnit(double oneUnitValueInML) {
        this.oneUnitValueInML = oneUnitValueInML;
    }

    public double convertToBase(double value) {
        return Math.round(oneUnitValueInML * value);
    }

    public double convertToThisUnit(double value) {
        return value / oneUnitValueInML;
    }
}
