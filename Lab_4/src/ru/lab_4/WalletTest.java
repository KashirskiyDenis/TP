package ru.lab_4;

import static org.junit.Assert.*;

import org.junit.*;

public class WalletTest {

	private Wallet wallet;

	@Before
	public void init() {
		wallet = new Wallet();
		wallet.addMoney("RUB", 500);
		wallet.addMoney("USD", 0);
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
	public void testGetMoney() {
		assertEquals(500, wallet.getMoney("RUB"));
	}

	@Test
	public void testGetMoney2() {
		assertEquals(0, wallet.getMoney("USD"));
	}

	@Test
	public void TtestGetCountCurrency() {
		assertEquals(1, wallet.getCountCurrency());
	}

	@Test
	public void testToString() {
		assertEquals("{ 0 USD, 500 RUB }", wallet.toString());
	}
}
