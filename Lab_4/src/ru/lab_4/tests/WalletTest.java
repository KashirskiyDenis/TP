package ru.lab_4.tests;

import static org.junit.Assert.*;

import org.junit.*;

import ru.lab_4.BankStub;
import ru.lab_4.LackOfFundsException;
import ru.lab_4.MoneyLaggerStub;
import ru.lab_4.Wallet;

public class WalletTest {

	private Wallet wallet;

	@Before
	public void init() {
		wallet = new Wallet();
		wallet.setMoneyLogger(new MoneyLaggerStub());
		wallet.setBank(new BankStub());
		wallet.addMoney("RUB", 500);
		wallet.addMoney("USD", 50);
	}
	
	@After
	public void testFinalize(){
		wallet.finalize();
	}
	
	@Test
	public void testAddMoney() {
		assertEquals(500, wallet.getMoney("RUB"));
	}

	@Test(expected = Exception.class)
	public void testRemoveMoney() throws LackOfFundsException {
		wallet.removeMoney("RUB", 550);
	}
	
	@Test
	public void testRemoveMoney2() {
		try {
			wallet.removeMoney("RUB", 500);
		} catch (LackOfFundsException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testGetMoney() {
		assertEquals(500, wallet.getMoney("RUB"));
	}

	@Test
	public void testGetMoney2() {
		assertEquals(50, wallet.getMoney("USD"));
	}

	@Test
	public void testGetCountCurrency() {
		assertEquals(2, wallet.getCountCurrency());
	}

	@Test
	public void testToString() {
		assertEquals("{ 50 USD, 500 RUB }", wallet.toString());
	}
	
	@Test
	public void testGetTotalMoney(){
		assertEquals(66, wallet.getTotalMoney("USD"));
	}

}
