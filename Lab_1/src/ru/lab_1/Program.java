package ru.lab_1;

import java.io.BufferedReader;
import java.io.FileReader;
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
		double money = capital;
		System.out.println("������\t����\t������\t�����\t�������");
		for (int i = 0; i < 40; i++)
			System.out.print("-");
		System.out.println();
		
		int a[] = trend();
		for (int i = 0; i < a.length; i++) {
			System.out.println(i + 1+"\t" + listOfNumber.get(i) + "\t" + money + "\t�����\t�������");
		}
	}

	private int[] trend() {
		int a[] = new int[listOfNumber.size()];
		int up = 0, down = 0;

		for (int i = 1; i < listOfNumber.size(); i++) {
			if (listOfNumber.get(i) > listOfNumber.get(i - 1))
				up++;
			if (listOfNumber.get(i) < listOfNumber.get(i - 1))
				down++;
			if (up >= 3 && down == 1) {
				up = 0;
				a[i] = -1;
			}
			if (down >= 3 && up == 1) {
				down = 0;
				a[i] = 1;
			}
		}
		return a;
	}

	private void printStars(long n) {
		for (int i = 0; i < n; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}