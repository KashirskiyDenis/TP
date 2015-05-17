package ru.lab_4;

import java.io.*;
import java.util.Date;

public class MoneyLagger {

	private FileWriter fileWriter;

	public MoneyLagger(String path) throws IOException {
		fileWriter = new FileWriter(path, true);
	}

	public void log(String message) throws IOException {
		Date date = new Date();
		fileWriter.write(date + ": -> " + message + "\n");
	}

	public void commit() throws IOException {
		fileWriter.close();
	}
}
