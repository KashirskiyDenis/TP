package ru.lab_4.tests;

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
		bank.convert(250, "USD", "RUB");
		verify(bank).convert(250, "USD", "RUB");
	}
}
