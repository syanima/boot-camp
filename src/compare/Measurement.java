package compare;

//Compares between 2 measurement when they are of same type
//adds 2 measurement if possible

import exceptions.MeasurementTypeException;

public class Measurement {
    private MeasurementUnit unit;
    private double value;

    public Measurement(double value, MeasurementUnit unit) {
        this.unit = unit;
        this.value = value;
    }

    private double convertToBase() {
        return unit.convertToBase(value);
    }

    public boolean compare(Measurement anotherMeasurement) throws MeasurementTypeException {
        throwExceptionWhenTypeMissmatched(anotherMeasurement, "Cannot compare two different measurement");
        return unit.convertToBase(value) == anotherMeasurement.convertToBase();
    }

    public Measurement add(Measurement anotherMeasurement, MeasurementUnit resultUnit) throws MeasurementTypeException {
        throwExceptionWhenTypeMissmatched(anotherMeasurement, "My teacher is an idiot");
        double sum = convertToBase() + anotherMeasurement.convertToBase();
        return new Measurement( convertTo(resultUnit, sum), resultUnit );
    }

    private void throwExceptionWhenTypeMissmatched(Measurement anotherMeasurement, String message) throws MeasurementTypeException {
        String thisUnitType = unit.getClass().getName();
        String anotherUnitType = anotherMeasurement.unit.getClass().getName();
        if (!thisUnitType.equals(anotherUnitType))
            throw new MeasurementTypeException(message);
    }

    private double convertTo(MeasurementUnit measurementUnit, double value) {
        return value / measurementUnit.convertToBase(1);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Measurement)) return false;
        Measurement givenMeasurement = (Measurement) obj;
        if (givenMeasurement.unit != unit) return false;
        return Math.round(value) == Math.round(givenMeasurement.value);
    }
}
