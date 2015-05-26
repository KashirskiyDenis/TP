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

	public void log(String message) throws IOException {
		Date date = new Date();
		fileWriter.write(date + ": -> " + message + "\n");
	}

	public void commit() throws IOException {
		fileWriter.close();
	}
}
