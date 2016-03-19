package probability;
/*
job of the class :-
   opertaions like and,not and or based on the probability

 */

import exceptions.InvalidProbabilityException;

public class Chance {
    private double value;

    private Chance(double value) {
        this.value = value;
    }

    public static Chance create(double value) throws InvalidProbabilityException {
        if (value > 1 || value < 0)
            throw new InvalidProbabilityException();
        return new Chance(value);
    }

    public Chance or(Chance otherChance) throws InvalidProbabilityException {
        return create(this.value + otherChance.value);
    }

    public Chance and(Chance otherChance) throws InvalidProbabilityException {
        return create(this.value * otherChance.value);
    }

    public Chance not() throws InvalidProbabilityException {
        return create(1 - this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chance chance = (Chance) o;

        return Double.compare(chance.value, value) == 0;

    }

}