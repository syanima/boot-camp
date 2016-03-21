package compare;

public interface MeasurementUnit {
    double convertToBase(double value);

    double convertToThisUnit(double value);
}
