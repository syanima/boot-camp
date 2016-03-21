package compare;

//Compares between 2 measurement when they are of same type

import exceptions.MeasurementTypeException;

public abstract class Measurement<MeasurementType, MeasurementUnit> {
    private compare.MeasurementUnit unit;
    private double value;

    public Measurement(double value, compare.MeasurementUnit unit) {
        this.unit = unit;
        this.value = value;
    }

    protected double convertToBase() {
        return unit.convertToBase(value);
    }

    public boolean compare(Measurement anotherMeasurement) throws MeasurementTypeException {
        throwExceptionWhenTypeMissmatched(anotherMeasurement, "Cannot compare two different measurement");
        return unit.convertToBase(value) == anotherMeasurement.convertToBase();
    }

    public abstract MeasurementType add(MeasurementType anotherMeasurement, MeasurementUnit resultUnit);

    private void throwExceptionWhenTypeMissmatched(Measurement anotherMeasurement, String message) throws MeasurementTypeException {
        String thisUnitType = unit.getClass().getName();
        String anotherUnitType = anotherMeasurement.unit.getClass().getName();
        if (!thisUnitType.equals(anotherUnitType))
            throw new MeasurementTypeException(message);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Measurement)) return false;
        Measurement givenMeasurement = (Measurement) obj;
        if (givenMeasurement.unit != unit) return false;
        return Math.round(value) == Math.round(givenMeasurement.value);
    }
}