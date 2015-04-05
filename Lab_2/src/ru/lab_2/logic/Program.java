package ru.lab_2.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import ru.lab_2.entities.*;

public class Program {

	private List<Story> listOfStories = new ArrayList<Story>();
	private List<GroupOfStories> listOfGroups = new ArrayList<GroupOfStories>();
	private int speed;

	public Program() {
		readFile();
		grouping();
		print();
	}

	private void readFile() {
		FileReader fr;
		try {
			fr = new FileReader("data.txt");
			BufferedReader br = new BufferedReader(fr);
			String tmp = br.readLine();

			String mas[] = tmp.toString().split(" ");
			this.speed = Integer.parseInt(mas[0]);
			int countStories = Integer.parseInt(mas[1]);

			for (int i = 0; i < countStories; i++) {
				tmp = br.readLine();
				mas = tmp.toString().split(" ");
				listOfStories.add(new Story(mas[0], Integer.parseInt(mas[1])));
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error reading file.");
		}
	}

	public void grouping() {
		int speed = this.speed;
		GroupOfStories group = new GroupOfStories();

		while (listOfStories.size() != 0) {
			int max = Integer.MIN_VALUE;
			int index = 0;
			for (int i = 0; i < listOfStories.size(); i++) {
				int cur = listOfStories.get(i).getComplexity();
				if (cur > max && cur <= speed) {
					max = cur;
					index = i;
				}
			}

			if (max != Integer.MIN_VALUE) {
				group.add(listOfStories.get(index).copy());
				listOfStories.remove(index);
				speed -= max;
			} else
				speed = 0;

			if (speed == 0 || listOfStories.size() == 0) {
				speed = this.speed;
				listOfGroups.add(group);
				group = new GroupOfStories();
			}
		}
	}

	private void print() {
		for (GroupOfStories g : listOfGroups) {
			System.out.println("Итерация " + listOfGroups.indexOf(g));
			g.sortByName();
			g.print();
		}
	}
}
