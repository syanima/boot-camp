package probability;

import exceptions.InvalidProbabilityException;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class ChanceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void andGivesAValueWhenGivenChanceValueIsMultipliedWithAnotherChanceValue() throws InvalidProbabilityException {
        Chance chance1 = Chance.create(0.3);
        Chance chance2 = Chance.create(0.3);
        Chance actualChance = chance1.and(chance2);
        Chance expectedChance = Chance.create(0.09);
        assertTrue(expectedChance.equals(actualChance));
    }

    @Test
    public void orGivesAValueWhenGivenChanceValueIsAddedWithAnotherChanceValue() throws InvalidProbabilityException {
        Chance chance1 = Chance.create(0.4);
        Chance chance2 = Chance.create(0.4);
        Chance actualChance = chance1.or(chance2);
        Chance expectedChance = Chance.create(0.8);
        assertTrue(expectedChance.equals(actualChance));
    }

    @Test
    public void notGivesAValueWhenChanceValueIsSubtractedFromOne() throws InvalidProbabilityException {
        Chance chance = Chance.create(0.75);
        Chance actualChance = chance.not();
        Chance expectedChance = Chance.create(0.25);
        assertTrue(expectedChance.equals(actualChance));
    }

    @Test
    public void chanceThrowsInvalidProbabilityExceptionWhenTheGivenValueIsGreaterThanOne() throws InvalidProbabilityException {
        exception.expectMessage(CoreMatchers.is("Expected value should be greater than zero and less than one"));
        exception.expect(InvalidProbabilityException.class);
        Chance.create(1.75);
    }

    @Test
    public void chanceThrowsInvalidProbabilityExceptionWhenTheGivenValueIsLessThanZero() throws InvalidProbabilityException {
        exception.expectMessage(CoreMatchers.is("Expected value should be greater than zero and less than one"));
        exception.expect(InvalidProbabilityException.class);
        Chance.create(-1);
    }

}