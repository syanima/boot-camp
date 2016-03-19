package compare;

public interface Measurement {
    boolean compare(Measurement second);

    double inBaseUnit();
}