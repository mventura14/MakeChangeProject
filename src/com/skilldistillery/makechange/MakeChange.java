package com.skilldistillery.makechange;

public class MakeChange {

	public static void main(String[] args) {
		double itemCost = randomDbl();
		double amountPayed = payedAmount(itemCost);
		double difference = amountPayed - itemCost;
		System.out.printf("Item Cost:    $%.2f %n", itemCost);
		System.out.printf("Amount payed: $%.2f %n", amountPayed);
	}

	public static double randomDbl() {

		double randomNum = Math.random() * (20 + 1);
		double value = Math.round(randomNum * 100.0) / 100.0;

		System.out.println(randomNum + " " + value);

		return value;
	}

	public static double payedAmount(double itemCost) {

		double randomNum = randomDbl();

		while (itemCost > randomNum) {
			randomNum = randomDbl();
		}

		return 12.2;
	}

}
