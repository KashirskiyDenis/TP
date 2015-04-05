package ru.lab_2.entities;

import java.util.ArrayList;
import java.util.List;

public class GroupOfStories {

	List<Story> group = new ArrayList<Story>();

	public void add(Story story) {
		this.group.add(story);
	}

	public void sortByName() {
		for (int i = 0; i < group.size() - 1; i++) {
			for (int j = 0; j < group.size() - i - 1; j++) {
				char a = group.get(j).getName().charAt(0);
				char b = group.get(j + 1).getName().charAt(0);
				if (a > b) {
					swap(group.get(j), group.get(j + 1));
				}
			}
		}
	}

	private void swap(Story s1, Story s2) {
		String tmpName = s1.getName();
		int tmpComplexity = s1.getComplexity();

		s1.setName(s2.getName());
		s1.setComplexity(s2.getComplexity());

		s2.setName(tmpName);
		s2.setComplexity(tmpComplexity);
	}

	public void print() {
		for (Story story : this.group) {
			System.out.println(story.toString());
		}
	}

}
