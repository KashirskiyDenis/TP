package ru.lab_4;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.*;

public class BigIntegerTest {
	
	private BigInteger number1;
	private BigInteger number2;
	
	@Test
	@Before
	public void init() {
		number1 = new BigInteger("10");
		number2 = new BigInteger("5");
	}
	
	@Test
	public void testAdd() {
		assertEquals(new BigInteger("15"), number1.add(number2));
	}
	
	@Test
	public void testSubtract() {
		assertEquals(new BigInteger("5"), number1.subtract(number2));
	}
	
	@Test
	public void testMultiply() {
		assertEquals(new BigInteger("50"), number1.multiply(number2));
	}
	
	@Test
	public void testDivide() {
		assertEquals(new BigInteger("2"), number1.divide(number2));
	}
	
	@Test(expected = Exception.class)
	public void testDivideException() {
		assertEquals(new BigInteger("2"), number1.divide(new BigInteger("0")));
	}
	
	@Test
	public void testMax() {
		assertEquals(new BigInteger("10"), number1.max(number2));
	}
	
	@Test
	public void testMin() {
		assertEquals(new BigInteger("5"), number1.min(number2));
	}
	
	@Test
	public void testCompereTo() {
		assertEquals(1, number1.compareTo(number2));
	}
	
	@Test
	public void testGcd() {
		assertEquals(new BigInteger("5"), number1.gcd(number2));
	}
	
	@Test
	public void testToString() {
		assertEquals("10", number1.toString());
	}
	
}
