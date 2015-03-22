package ru.lab_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Program {

	private List<Double> listOfNumber = new ArrayList<Double>();

	public Program() {
		readFile();
	}

	private void readFile() {
		FileReader fr;
		try {
			fr = new FileReader("st15.txt");
			BufferedReader br = new BufferedReader(fr);
			String tmp;
			while ((tmp = br.readLine()) != null) {
				listOfNumber.add(Double.parseDouble(tmp));
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error reading file.");
		}
	}

}
