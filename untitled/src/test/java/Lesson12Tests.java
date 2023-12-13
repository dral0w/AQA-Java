import org.testng.Assert;
import org.testng.annotations.Test;

public class Lesson12Tests {
    @Test
    public void factorial() {
        Assert.assertEquals(120, Lesson12.calculateFactorial(5));
        Assert.assertEquals(1, Lesson12.calculateFactorial(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> Lesson12.calculateFactorial(-2));
    }
}
