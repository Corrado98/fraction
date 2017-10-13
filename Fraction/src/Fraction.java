
public final class Fraction {

	private final long numerator;
	private final long denumerator;

	public Fraction(long numerator) {
		this(numerator, 1);
	}

	public Fraction(long numerator, long denumerator) {
		this.numerator = numerator;
		this.denumerator = denumerator;
	}

	public Fraction(Fraction fraction) {
		this.numerator = fraction.numerator;
		this.denumerator = fraction.denumerator;
	}

	public long getNumerator() {
		return numerator;
	}

	public long getDenumerator() {
		return denumerator;
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

		return this.numerator == other.numerator && this.denumerator == other.denumerator;
	}
	
	@Override
	public String toString() {
		return String.format("%s/%s", numerator, denumerator);
	}
	
	public Fraction add(Fraction augend) {
		return null;
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
