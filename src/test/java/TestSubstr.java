import org.junit.Assert;
import org.junit.Test;


public class TestSubstr {

    @Test
    public void testSimple() {
        var fraction = TestUtils.createFraction(3, 4);
        var result = fraction.minus(new NotImplementedFraction(2, 5));

        Assert.assertEquals((Integer) 7, result.getNumerator());
        Assert.assertEquals((Integer) 20, result.getDenominator());
    }

    @Test
    public void testNormalisation() {
        var fraction = TestUtils.createFraction(3, 2);
        var result = fraction.minus(new NotImplementedFraction(1, 2));

        Assert.assertEquals((Integer) 1, result.getNumerator());
        Assert.assertEquals((Integer) 1, result.getDenominator());
    }
}
