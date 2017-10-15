
public final class Fraction {

	private final long numerator;
	private final long denominator;

	public Fraction(long numerator) {
		this(numerator, 1);
	}

	public Fraction(long numerator, long denumerator) {
		validate(denumerator);
		this.numerator = numerator;
		this.denominator = denumerator;
	}

	private void validate(long denumerator) throws IllegalArgumentException {
		if(denumerator == 0) {
			throw new IllegalArgumentException("Denumerator cannot be 0.");
		}
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

		Fraction other = ((Fraction) obj).reduce();
		Fraction t = this.reduce();
		
		return t.numerator == other.numerator && t.denominator == other.denominator;
	}
	
	@Override
	public String toString() {
		return String.format("%s/%s", numerator, denominator);
	}
	
	private Fraction reduce() {		
		long gcd = 0;
		long num = this.numerator;
		long denom = this.denominator;
		while(gcd != 1) {			
			gcd = calculateGreatestCommonDivisor(num, denom);
			num /= gcd;
			denom /= gcd;
		}
		return new Fraction(num, denom);
	}
	
	public Fraction add(Fraction augend) {
		long newDenominator = this.denominator * augend.denominator;
		long newNumerator = (newDenominator / this.denominator * this.numerator) + (newDenominator / augend.denominator * augend.numerator); 
		return new Fraction(newNumerator, newDenominator).reduce();
	}
	
	public Fraction subtract(Fraction subtrahend) {
		long newDenominator = this.denominator * subtrahend.denominator;
		long newNumerator = (newDenominator / this.denominator * this.numerator) - (newDenominator / subtrahend.denominator * subtrahend.numerator); 
		return new Fraction(newNumerator, newDenominator).reduce();
	}
	
	public Fraction multiply(Fraction multiplicand) {
		long newDenominator = this.denominator * multiplicand.denominator;
		long newNumerator = this.numerator * multiplicand.numerator;
		return new Fraction(newNumerator, newDenominator).reduce();
	}
	
	public Fraction divide(Fraction divisor) {
		return multiply(new Fraction(divisor.denominator, divisor.numerator));
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
