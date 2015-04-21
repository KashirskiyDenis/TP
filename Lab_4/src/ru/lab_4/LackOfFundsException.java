package ru.lab_4;

public class LackOfFundsException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String message;

	public LackOfFundsException() {
		this.message = "������������ ������� � ��������� ������";
	}

	public LackOfFundsException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
