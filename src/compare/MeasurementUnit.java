package compare;

public interface MeasurementUnit {
    double convertToBase(double value);

    double convertToThis(double value);
}