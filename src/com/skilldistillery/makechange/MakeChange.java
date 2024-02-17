package com.skilldistillery.makechange;

public class MakeChange {

	public static void main(String[] args) {
		double itemCost = randomDbl();
		double amountPayed = payedAmount(itemCost);
		double difference = amountPayed - itemCost;
		System.out.printf("Item Cost:    $%.2f %n", itemCost);
		System.out.printf("Amount payed: $%.2f %n", amountPayed);
		System.out.printf("Difference:   $%.2f %n", difference);

		getChange(difference);

	}

	public static double randomDbl() {

		int max = 20;
		int min = 0;

		double randomNum = (Math.random() * (max + 1)) + min;
		double value = Math.round(randomNum * 100.0) / 100.0;

		System.out.println("ran Gen: " + randomNum + " " + value);

		return value;
	}

	public static double payedAmount(double itemCost) {

		double randomNum = randomDbl();

		while (itemCost > randomNum) {
			randomNum = randomDbl();
		}

		return randomNum;
	}

	public static void getChange(double change) {
		int hundread = 0;
		int fifty = 0;
		int twenty = 0;
		int tens = 0;
		int fives = 0;
		int ones = 0;
		int penny = 0;
		int nickel = 0;
		int dimes = 0;
		int quarters = 0;

		double getChange = change;
		System.out.println("gg" + getChange);

		while (getChange > 0) {

			double reduce = reduction(getChange);

			getChange -= reduce;
			getChange = Math.round(getChange * 100.0) / 100.0;
			System.out.println("getChange: " + getChange);
		}

	}

	public static double reduction(double getChange) {
		double reduceBy = 100.0;

		reduceBy = getChange >= 00.01 ? 00.01 : reduceBy;
		reduceBy = getChange >= 00.05 ? 00.05 : reduceBy;
		reduceBy = getChange >= 00.10 ? 00.15 : reduceBy;
		reduceBy = getChange >= 00.25 ? 00.20 : reduceBy;
		reduceBy = getChange >= 01.00 ? 01.00 : reduceBy;
		reduceBy = getChange >= 05.00 ? 05.00 : reduceBy;
		reduceBy = getChange >= 10.00 ? 10.00 : reduceBy;
		reduceBy = getChange >= 20.00 ? 20.00 : reduceBy;
		reduceBy = getChange >= 50.00 ? 50.00 : reduceBy;
		reduceBy = getChange >= 100.00 ? 100.00 : reduceBy;

		System.out.println("reducing: " + reduceBy);

		return reduceBy;
	}

}
