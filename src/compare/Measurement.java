package compare;

//Compares between 2 measurement when they are of same type

public abstract class Measurement<MeasurementType extends Measurement, Unit extends MeasurementUnit> {
    private compare.MeasurementUnit unit;
    private double value;

    public Measurement(double value, compare.MeasurementUnit unit) {
        this.unit = unit;
        this.value = value;
    }

    protected double convertToBase() {
        return unit.convertToBase(value);
    }

    public int compare(Measurement anotherMeasurement) throws MeasurementTypeException {
        throwExceptionWhenTypeMissmatched(anotherMeasurement, "Cannot compare two different measurement");
        double delta = unit.convertToBase(value) - anotherMeasurement.convertToBase();
        if (delta == 0)
            return 0;
        return new Double(delta / Math.abs(delta)).intValue();
    }

    public MeasurementType add(MeasurementType anotherMeasurement, Unit resultUnit) {
        double sum = convertToBase() + anotherMeasurement.convertToBase();
        return createMeasurement(sum, resultUnit);
    }

    protected abstract MeasurementType createMeasurement(double sum, Unit resultUnit);

    private void throwExceptionWhenTypeMissmatched(Measurement anotherMeasurement, String message) throws MeasurementTypeException {
        String thisUnitType = unit.getClass().getName();
        String anotherUnitType = anotherMeasurement.unit.getClass().getName();
        if (!thisUnitType.equals(anotherUnitType))
            throw new MeasurementTypeException(message);
    }
}
