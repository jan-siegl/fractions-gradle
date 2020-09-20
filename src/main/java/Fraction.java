public class Fraction implements IFraction {

    private final Integer numerator;
    private final Integer denominator;

    public static void main(String[] args) {
        Fraction fr1 = new Fraction(1, 3);
        Fraction fr2 = new Fraction(2, 6);
        System.out.println("Fraction " + fr1.plus(fr2).getNumerator() + "/" + fr1.plus(fr2).getDenominator());
        System.out.println(fr2.createNormalised(fr2.getNumerator(), fr2.getDenominator()));
    }

    public Fraction(Integer numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        if (denominator == 0) throw new ArithmeticException("Cannot Divide by 0");
    }

    @Override
    public Integer getNumerator() {
        return numerator;
    }

    @Override
    public Integer getDenominator() {
        return denominator;
    }

    @Override
    public IFraction plus(IFraction other) {
        int lcm = commonD(denominator, other.getDenominator());
        int n1 = lcm / denominator * numerator;
        int n2 = lcm / other.getDenominator() * other.getNumerator();

        return createNormalised(n1 + n2, lcm);
    }

    @Override
    public IFraction minus(IFraction other) {
        int lcm = commonD(denominator, other.getDenominator());
        int n1 = lcm / denominator * numerator;
        int n2 = lcm / other.getDenominator() * other.getNumerator();

        return createNormalised(n1 - n2, lcm);
    }
    private int commonD(int i, int i1) {
        if (i == 0 || i1 == 0) {
            return 0;
        }
        int absNumber1 = Math.abs(i);
        int absNumber2 = Math.abs(i1);
        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);
        int d = absHigherNumber;
        while (d % absLowerNumber != 0) {
            d += absHigherNumber;
        }
        return d;
    }

    @Override
    public IFraction times(IFraction other) {
        return createNormalised(numerator * other.getNumerator(), denominator * other.getDenominator());
    }

    @Override
    public IFraction dividedBy(IFraction other) {
        return createNormalised(numerator * other.getDenominator(), denominator * other.getNumerator());
    }

    private static Fraction createNormalised(Integer numerator, Integer denominator) {
        int lcd = commonD2(numerator, denominator);

        while(lcd > 1){
            numerator /= lcd;
            denominator /= lcd;
            lcd = commonD2(numerator, denominator);
        }

        return new Fraction(numerator, denominator);
    }
    private static int commonD2(int i, int i1) {
        if (i1 == 0) {
            return i;
        }
        return commonD2(i1, i % i1);
    }

    @Override
    public String toString() {
        return "Fraction " + numerator + "/" + denominator;
    }
}
