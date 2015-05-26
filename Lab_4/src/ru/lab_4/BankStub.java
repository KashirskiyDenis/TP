package ru.lab_4;

public class BankStub extends Bank {
	
	public int convert(int money, String from, String to) {
		return (int) (money / 30);
	}
}
