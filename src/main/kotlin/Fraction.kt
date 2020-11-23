import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Fraction(@get:Override
               override val numerator: Int, @get:Override
               override val denominator: Int) : IFraction {

    init {

        if (denominator == 0) throw ArithmeticException("Cannot Divide by 0")
    }

    override operator fun plus(other: IFraction): IFraction {
        val lcm = commonD(denominator, other.denominator)
        val n1 = lcm / (denominator * numerator)
        val n2 = lcm / (other.denominator * other.numerator)

        return createNormalised(n1 + n2, lcm)
    }

    override operator fun minus(other: IFraction): IFraction {
        val lcm = commonD(denominator, other.denominator)
        val n1 = lcm / (denominator * numerator)
        val n2 = lcm / (other.denominator * other.numerator)

        return createNormalised(n1 - n2, lcm)
    }

    private fun commonD(i: Int, i1: Int): Int {
        if (i == 0 || i1 == 0) {
            return 0
        }
        val absNumber1 = abs(i)
        val absNumber2 = abs(i1)
        val absHigherNumber = max(absNumber1, absNumber2)
        val absLowerNumber = min(absNumber1, absNumber2)
        var d = absHigherNumber
        while (d % absLowerNumber != 0) {
            d += absHigherNumber
        }
        return d
    }

    override operator fun times(other: IFraction): IFraction {
        return createNormalised(numerator * other.numerator, denominator * other.denominator)
    }

    override fun div(other: IFraction): IFraction {
        return createNormalised(numerator * other.denominator, denominator * other.numerator)
    }

    override fun toString(): String {
        return "Fraction $numerator/$denominator"
    }

    companion object {

        fun main(args: Array<String>) {
            val fr1 = Fraction(1, 3)
            val fr2 = Fraction(2, 6)
            println("Fraction " + fr1.plus(fr2).numerator + "/" + fr1.plus(fr2).denominator)
        }

        private fun createNormalised(numerator: Int, denominator: Int): Fraction {
            var numerator = numerator
            var denominator = denominator
            var lcd = commonD2(numerator, denominator)

            while (lcd > 1) {
                numerator /= lcd
                denominator /= lcd
                lcd = commonD2(numerator, denominator)
            }

            return Fraction(numerator, denominator)
        }

        private fun commonD2(i: Int, i1: Int): Int {
            return if (i1 == 0) {
                i
            } else commonD2(i1, i % i1)
        }
    }
}
