package ru.lab_1;

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

	public void task1() {
		for (double d : listOfNumber) {
			System.out.println(d);
		}
	}

	public void task2() {
		for (double d : listOfNumber) {
			printStars(Math.round(d));
		}
	}

	public void task3() {
		int a[] = trend();
		for (int i = 0; i < listOfNumber.size(); i++) {
			System.out.println(i + 1 + "\t" + listOfNumber.get(i) + "\t"
					+ (a[i] == -1 ? "Sold" : a[i] == 1 ? "Buy" : ""));
		}
	}

	public void task4(double capital) {
		double money = capital, stock = 0;
		System.out.println("Ïåðèîä\tÖåíà\tÄåíüãè\tÀêöèè\tÊàïèòàë");
		for (int i = 0; i < 40; i++)
			System.out.print("-");
		System.out.println();

		int a[] = trend();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 1 && money != 0) {
				stock = money / listOfNumber.get(i);
				money = 0;
			}
			if (a[i] == -1 && stock != 0) {
				money = stock * listOfNumber.get(i);
				stock = 0;
			}
			capital = money + stock * listOfNumber.get(i);
			System.out.println(i + 1 + "\t" + round(listOfNumber.get(i), 3)
					+ "\t" + round(money, 2) + "\t" + round(stock, 2) + "\t"
					+ round(capital, 2));
		}
	}

	private int[] trend() {
		int up = 0, down = 0, n = listOfNumber.size();
		int a[] = new int[n];
		String previous = null;

		for (int i = 1; i < n; i++) {
			double cur = listOfNumber.get(i), prev = listOfNumber.get(i - 1);
			String current = null;
			if (cur > prev) {
				up++;
				current = new String("up");
			}
			else if (cur < prev) {
				down++;
				current = new String("down");
			}
			else {
				previous = null;
				down = 0;
				up = 0;
				continue;
			}
			if (up >= 3 && down == 1) {
				up = 0;
				a[i] = -1;
			}
			if (down >= 3 && up == 1) {
				down = 0;
				a[i] = 1;
			}
			if (!current.equals(previous) && previous != null) {
				if (current.equals("down"))
					up = 0;
				if (current.equals("up"))
					down = 0;
			}
			previous = new String(current);
		}
		return a;
	}

	private void printStars(long n) {
		for (int i = 0; i < n; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

	private double round(double d, int r) {
		return new BigDecimal(d).setScale(r, RoundingMode.UP).doubleValue();
	}
}
