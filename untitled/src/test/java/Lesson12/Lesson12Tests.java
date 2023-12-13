package Lesson12;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lesson12Tests {
    @Test
    public void factorial() {
        Assertions.assertEquals(120, Lesson12.calculateFactorial(5));
        Assertions.assertEquals(1, Lesson12.calculateFactorial(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Lesson12.calculateFactorial(-4));
    }
}
