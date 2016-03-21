package compare;
//adds 2 Volume
public class Volume extends Measurement<Volume,VolumeUnit> {
    public Volume(double value, VolumeUnit unit) {
        super(value, unit);
    }

    public Volume add(Volume anotherVolume, VolumeUnit resultUnit){
        double sum = super.convertToBase() + anotherVolume.convertToBase();
        return new Volume( resultUnit.convertToThis(sum), resultUnit);
    }
}