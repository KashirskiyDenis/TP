package ru.lab_4;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Bank {

	private static HashMap<String, Double> currencyRate = new HashMap<String, Double>();

	public Bank() {
		setCurrencyRate();
	}

	public int convert(int money, String from, String to) {
		from = from.toUpperCase();
		to = to.toUpperCase();
		if (to.equalsIgnoreCase("rub"))
			return (int) (money * currencyRate.get(from));
		else if (from.equalsIgnoreCase("rub"))
			return (int) (money / currencyRate.get(to));
		else
			return (int) (money * (currencyRate.get(from)/currencyRate.get(to)));
	}

	private void setCurrencyRate() {
		URL bank = null;
		try {
			bank = new URL("http://www.cbr.ru/scripts/XML_daily.asp");
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
		Document document = null;
		try {
			if (db != null)
				document = db.parse(bank.openStream());
		} catch (SAXException | IOException e) {
			System.out.println(e.getMessage());
		}
		Element root = document.getDocumentElement();
		NodeList listValute = root.getElementsByTagName("Valute");
		for (int i = 0; i < listValute.getLength(); i++) {
			Element valute = (Element) listValute.item(i);
			String currency = valute.getElementsByTagName("CharCode").item(0)
					.getTextContent();
			double money = Double.parseDouble(valute
					.getElementsByTagName("Value").item(0).getTextContent()
					.toString().replace(',', '.'));
			currencyRate.put(currency, money);
		}
	}
}
