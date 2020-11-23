import org.junit.Assert
import org.junit.Test


class TestSubstr {

    @Test
    fun testSimple() {
        val fraction = TestUtils.createFraction(3, 4)
        val result = fraction.minus(NotImplementedFraction(2, 5))

        Assert.assertEquals(7, result.numerator)
        Assert.assertEquals(20, result.denominator)
    }

    @Test
    fun testNormalisation() {
        val fraction = TestUtils.createFraction(3, 2)
        val result = fraction.minus(NotImplementedFraction(1, 2))

        Assert.assertEquals(1, result.numerator)
        Assert.assertEquals(1, result.denominator)
    }
}
