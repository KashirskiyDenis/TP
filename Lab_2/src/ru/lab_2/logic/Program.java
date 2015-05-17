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
		createMatrixA();
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

	private void print() {
		for (GroupOfStories g : listOfGroups) {
			System.out.println("Итерация " + listOfGroups.indexOf(g));
			g.sortByName();
			g.print();
		}
	}

	private void createMatrixA() {
		while (listOfStories.size() != 0) {
			int n = listOfStories.size();
			int dp[][] = new int[speed + 1][n + 1];
			for (int j = 1; j <= n; j++) {
				for (int w = 1; w <= speed; w++) {
					if (listOfStories.get(j - 1).getComplexity() <= w) {
						dp[w][j] = Math
								.max(dp[w][j - 1],
										dp[w - listOfStories.get(j - 1).getComplexity()][j - 1]
												+ listOfStories.get(j - 1).getComplexity());
					} else {
						dp[w][j] = dp[w][j - 1];
					}
				}
			}
			List<Integer> groupIndex = new ArrayList<Integer>();
			findGroupIndex(groupIndex, dp, dp.length - 1, dp[0].length - 1);
			updateLists(groupIndex, new GroupOfStories());
		}
	}
	
	private void findGroupIndex(List<Integer> groupIndex, int a[][], int n, int s) {
		if (a[n][s] == 0)
			return;
		if (a[n][s - 1] == a[n][s])
			findGroupIndex(groupIndex, a, n, s - 1);
		else {
			findGroupIndex(groupIndex, a, n - listOfStories.get(s - 1).getComplexity(), s - 1);
			groupIndex.add(s - 1);
		}
	}
	
	private void updateLists(List<Integer> groupIndex, GroupOfStories group) {
		for (int i : groupIndex) 
			group.add(this.listOfStories.get(i).copy());

		this.listOfGroups.add(group);

		List<Story> listOfStories = new ArrayList<Story>();
		for (int i = 0; i < this.listOfStories.size(); i++)
			if (!groupIndex.contains(i))
				listOfStories.add(this.listOfStories.get(i).copy());
		
		this.listOfStories = listOfStories;
	}	

}
