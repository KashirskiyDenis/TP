package ru.lab_4;

public class MoneyLaggerStub extends MoneyLagger {

	String str = new String();
	String tmp= new String();
	
	public MoneyLaggerStub() {
	}
	
	public void log(String str) {
		this.tmp += str = "\n";
	}
	
	public void commit() {
		str = new String(tmp);
	}
}
