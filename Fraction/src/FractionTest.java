import org.junit.Test;

import org.junit.Assert;

public class FractionTest {
	
	@Test
	public void equalsTest() {
		Assert.assertEquals(true, new Fraction(3,4).equals(new Fraction(3,4)));
		Assert.assertEquals(false, new Fraction(1,2).equals(new Fraction(3,4)));
		
	}

	
	@Test
	public void basic_addTest() {
		Fraction a = new Fraction(1,2);
		Fraction b = new Fraction(1,4);
		
		Fraction actualResult = a.add(b);
		
		Assert.assertEquals(new Fraction(3,4), actualResult);
	}

	
	@Test
	public void basic_calculateGreatestCommonDivisorTest() {
		Assert.assertEquals(10, Fraction.calculateGreatestCommonDivisor(10, 20));
		Assert.assertEquals(10, Fraction.calculateGreatestCommonDivisor(20, 10));
		
		Assert.assertEquals(3, Fraction.calculateGreatestCommonDivisor(9, 6));
		Assert.assertEquals(1, Fraction.calculateGreatestCommonDivisor(9, 7));
	}
	
	@Test
	public void zero_calculateGreatestCommonDivisorTest() {
		//0 0 
		//pos 0
		//0 pos
		Assert.fail();
	}
	
	@Test
	public void negative_calculateGreatestCommonDivisorTest() {
		Assert.fail();
	}
	
	@Test
	public void toStringTest() {
		Assert.assertEquals("1/2", new Fraction(1,2).toString());
	}
	
}
