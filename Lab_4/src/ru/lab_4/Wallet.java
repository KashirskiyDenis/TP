package ru.lab_4;

import java.util.HashMap;
import java.util.Map.Entry;

public class Wallet {

	private HashMap<String, Integer> wallet;
	// private MoneyLagger moneyLogger;
	private MoneyLaggerStub mls;

	public Wallet() {
		wallet = new HashMap<String, Integer>();
		//moneyLogger = new MoneyLagger();
		mls = new MoneyLaggerStub();
	}

	public void finalize() {
		// moneyLogger.commit();
		mls.commit();
	}

	public void addMoney(String currency, int money) {
		currency = currency.toUpperCase();
		if (!wallet.containsKey(currency))
			wallet.put(currency, 0);
		int newCash = wallet.get(currency) + money;
		wallet.replace(currency, newCash);
		// moneyLogger.log("В кошелёк добавлено " + money + " " + currency);
		mls.log("В кошелёк добавлено " + money + " " + currency);
	}

	public void removeMoney(String currency, int money)
			throws LackOfFundsException {
		currency = currency.toUpperCase();
		if (wallet.get(currency) < money || wallet.get(currency) == 0)
			throw new LackOfFundsException();
		int newCash = wallet.get(currency) - money;
		wallet.replace(currency, newCash);
		// moneyLogger.log("Из кошелёка взято " + money + " " + currency);
		mls.log("Из кошелёка взято " + money + " " + currency);
	}

	public int getMoney(String currency) {
		currency = currency.toUpperCase();
		if (!wallet.containsKey(currency))
			return 0;
		return wallet.get(currency.toUpperCase());
	}

	public int getCountCurrency() {
		int count = 0;
		for (Entry<String, Integer> entry : wallet.entrySet())
			if (entry.getValue() != 0)
				count++;
		return count;
	}

	@Override
	public String toString() {
		if (wallet.size() == 0)
			return "{ }";
		String str = "{ ";
		for (Entry<String, Integer> entry : wallet.entrySet())
			str += entry.getValue() + " " + entry.getKey() + ", ";
		
		str = str.substring(0, str.length() - 2) + " }";
		return str;
	}

	public int getTotalMoney(String currency) {
		//Bank bank = new Bank();
		BankStub bank = new BankStub();
		currency = currency.toUpperCase();
		int sum = 0;
		for (Entry<String, Integer> entry : wallet.entrySet()) {
			if (!currency.equalsIgnoreCase(entry.getKey())) {
				sum += bank.convert(entry.getValue(), entry.getKey(), currency);
				// sum += (int) entry.getValue() / 51.86;
			}
			else
				sum += entry.getValue();
		}
		return sum;
	}
}
