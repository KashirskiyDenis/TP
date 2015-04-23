package ru.lab_4.tests;

import static org.junit.Assert.*;

import org.junit.*;

import ru.lab_4.Bank;

public class BankTest {
	private Bank bank;
	
	@Before
	public void init(){
		try {
			bank = new Bank();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testConvert(){
		assertEquals(9, bank.convert(10, "USD", "eur"));
	}
}
