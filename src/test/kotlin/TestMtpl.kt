import org.junit.Assert
import org.junit.Test


class TestMtpl {

    @Test
    fun testSimple() {
        val fraction = TestUtils.createFraction(3, 5)
        val result = fraction.times(NotImplementedFraction(3, 5))

        Assert.assertEquals(9, result.numerator)
        Assert.assertEquals(25, result.denominator)
    }

    @Test
    fun testNormalisation() {
        val fraction = TestUtils.createFraction(2, 8)
        val result = fraction.times(NotImplementedFraction(4, 2))

        Assert.assertEquals(1, result.numerator)
        Assert.assertEquals(2, result.denominator)
    }
}
