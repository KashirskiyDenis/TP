package ru.lab_2.entities;

public class Story {

	private String name;
	private int complexity;

	public Story(String name, int complexity) {
		this.name = name;
		this.complexity = complexity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setComplexity(int complexity) {
		this.complexity = complexity;
	}

	public String getName() {
		return this.name;
	}

	public int getComplexity() {
		return this.complexity;
	}

	public Story copy() {
		return new Story(this.name, this.complexity);
	}
	
	public String toString() {
		return this.name + " " + this.complexity;
	}
}
