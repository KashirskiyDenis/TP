package ru.lab_4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class Wallet {

	private HashMap<String, Integer> wallet;
	private MoneyLagger moneyLogger;
	private Bank bank;
	
	public Wallet() {
		wallet = new HashMap<String, Integer>();
	}
	
	public void finalize() {
		try {
			moneyLogger.commit();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}	
	
	public MoneyLagger getMoneyLogger() {
		return moneyLogger;
	}

	public void setMoneyLogger(MoneyLagger moneyLogger) {
		this.moneyLogger = moneyLogger;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public void addMoney(String currency, int money) {
		currency = currency.toUpperCase();
		if (!wallet.containsKey(currency))
			wallet.put(currency, 0);
		int newCash = wallet.get(currency) + money;
		wallet.replace(currency, newCash);
		try {
			moneyLogger.log("В кошелёк добавлено " + money + " " + currency);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void removeMoney(String currency, int money)
			throws LackOfFundsException {
		currency = currency.toUpperCase();
		if (wallet.get(currency) < money || wallet.get(currency) == 0)
			throw new LackOfFundsException();
		int newCash = wallet.get(currency) - money;
		wallet.replace(currency, newCash);
		try {
			moneyLogger.log("Из кошелёка взято " + money + " " + currency);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
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
		currency = currency.toUpperCase();
		int sum = 0;
		for (Entry<String, Integer> entry : wallet.entrySet()) {
			if (!currency.equalsIgnoreCase(entry.getKey()))
				sum += bank.convert(entry.getValue(), entry.getKey(), currency);
			else
				sum += entry.getValue();
		}
		return sum;
	}
}
