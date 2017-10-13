
public final class Fraction {

	private final long numerator;
	private final long denominator;

	public Fraction(long numerator) {
		this(numerator, 1);
	}

	public Fraction(long numerator, long denumerator) {
		this.numerator = numerator;
		this.denominator = denumerator;
	}

	public Fraction(Fraction fraction) {
		this.numerator = fraction.numerator;
		this.denominator = fraction.denominator;
	}

	public long getNumerator() {
		return numerator;
	}

	public long getDenumerator() {
		return denominator;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Fraction)) {
			return false;
		}

		Fraction other = (Fraction) obj;

		return this.numerator == other.numerator && this.denominator == other.denominator;
	}
	
	@Override
	public String toString() {
		return String.format("%s/%s", numerator, denominator);
	}
	
	public Fraction add(Fraction augend) {
		long newDenominator = this.denominator * augend.denominator;
		long newNumerator = (newDenominator / this.denominator * this.numerator) + (newDenominator / augend.denominator * augend.numerator); 
		return new Fraction(newNumerator, newDenominator);
	}
	
	public Fraction subtract(Fraction subtrahend) {
		return null;
	}
	
	public Fraction multiply(Fraction multiplicand) {
		return null;
	}
	
	public Fraction divide(Fraction divisor) {
		return null;
	}

	static long calculateGreatestCommonDivisor(long a, long b) {
		long r = a % b;

		while (r != 0) {
			a = b;
			b = r;
			r = a % b;
		}

		return b;
	}

}
