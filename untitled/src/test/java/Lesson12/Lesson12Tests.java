package Lesson12;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lesson12Tests {
    @Test
    public void factorialShouldWorkWithPositiveNumber() {
        Assertions.assertEquals(120, Lesson12.calculateFactorial(5));
    }

    @Test
    public void factorialShouldWorkWithNegativeNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Lesson12.calculateFactorial(-4));
    }

    @Test
    public void factorialShouldWorkWith0() {
        Assertions.assertEquals(1, Lesson12.calculateFactorial(0));
    }
}
