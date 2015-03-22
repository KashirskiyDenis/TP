package ru.lab_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GUI {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Program prg = new Program();

	public GUI() {
		try {
			int i = 0;
			do {
				i = mainMenu();
				if (i == 1) {
				} else if (i == 2) {

				} else
					System.out.println(i != 0 ? "Нет такого пункта меню" : "Exit...");
			} while (i != 0);
		} catch (Exception e) {
			System.out.println("Навигация при помощи цифр");
		}
	}

	private int mainMenu() throws Exception {
		System.out.println("Выберите действие");
		System.out.println("1: Task 1");
		System.out.println("2: Task 2");
		System.out.println("0 to Exit");
		int selection = Integer.parseInt(br.readLine());
		return selection;
	}

}
