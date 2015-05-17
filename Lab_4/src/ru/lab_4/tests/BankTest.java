package ru.lab_4.tests;

import static org.junit.Assert.*;
import org.junit.*;
import ru.lab_4.Bank;
import static org.mockito.Mockito.*;

public class BankTest {
	private Bank bank;
	
	@Before
	public void init() {
		bank = mock(Bank.class);
	}

	@Test
	public void testConvert(){
		when(bank.convert(10, "usd", "eur")).thenReturn(8);
		int result = (bank.convert(10, "usd", "eur"));
		assertEquals(8, result);
	}
}
