package ru.lab_4;

import java.io.*;
import java.util.Date;

public class MoneyLagger {

	private FileWriter fileWriter;

	public MoneyLagger() {
		try {
			fileWriter = new FileWriter("Log.txt", true);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void log(String message) {
		Date date = new Date();
		try {
			fileWriter.write(date + ": -> " + message + "\n");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void commit() {
		try {
			fileWriter.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}		
	}
}
