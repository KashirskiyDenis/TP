package ru.lab_1;

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
					prg.task1();
				} else if (i == 2) {
					prg.task2();
				} else if (i == 3) {
					prg.task3();
				} else if (i == 4) {
					prg.task4(10000);
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
		System.out.println("3: Task 3");
		System.out.println("4: Task 4");
		System.out.println("0 to Exit");
		int selection = Integer.parseInt(br.readLine());
		return selection;
	}

}
