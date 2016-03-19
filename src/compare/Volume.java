package compare;

public class Volume implements Measurement {
    private final VolumeUnit unit;
    private final double value;

    public Volume(VolumeUnit unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public double inBaseUnit(){
        return unit.inBaseUnit(value);
    }
    public boolean compare(Measurement anotherVolume){
        return Math.round(inBaseUnit()) == Math.round(anotherVolume.inBaseUnit());
    }
}