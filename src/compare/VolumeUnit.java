package compare;

public enum  VolumeUnit {
    GALLON(3780),
    LITER(1000);

    private double oneUnitValueInML;

    VolumeUnit(double oneUnitValueInML) {
        this.oneUnitValueInML = oneUnitValueInML;
    }
    public double inBaseUnit(double value){
        return oneUnitValueInML * value;
    };
}