package com.skilldistillery.makechange;

public class MakeChange {

	public static void main(String[] args) {
		double itemCost = randomDbl();
		double amountPayed = randomDbl();
		double difference = amountPayed - itemCost;

		System.out.printf("Item Cost:    $%.2f %n", itemCost);
		System.out.printf("Amount payed: $%.2f %n", amountPayed);
		System.out.printf("Difference:   $%.2f %n", difference);

		if (amountPayed > itemCost) {
			getChange(difference);
		} else {
			System.out.println("Sorry, you dont have enough");
		}

	}

	public static double randomDbl() {

		int max = 500;
		int min = 0;

		double randomNum = (Math.random() * (max + 1)) + min;
		double value = Math.round(randomNum * 100.0) / 100.0;

//		System.out.println("ran Gen: " + randomNum + " " + value);

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
		String changeStr = "";
		String str2 = "";

		double getChange = change;

		double prevVal = reduction(getChange);

		int count = 0;

		while (getChange > 0) {

			double reduce = reduction(getChange);

			if (prevVal != reduce) {

				changeStr += String.format("%d : %.2f %n", count, prevVal);
//				System.out.println(changeStr);

				str2 += getDollarCurrency(prevVal, count);
//				System.out.println(str2);

				count = 0;
			}

			getChange -= reduce;
			getChange = Math.round(getChange * 100.0) / 100.0;

			prevVal = reduce;
			count++;

//			System.out.println();
//			System.out.println("Current Count:" + count + " prevVal: " + prevVal);
//			System.out.printf("getChange: %.2f %n", getChange);
//			System.out.println();

		}
		changeStr += String.format("%d : %.2f %n", count, prevVal);
		System.out.println(changeStr);
		str2 += getDollarCurrency(prevVal, count);
		System.out.println(str2);

	}

	public static double reduction(double getChange) {
		double reduceBy = 100.0;

		reduceBy = getChange >= 00.01 ? 00.01 : reduceBy;
		reduceBy = getChange >= 00.05 ? 00.05 : reduceBy;
		reduceBy = getChange >= 00.10 ? 00.10 : reduceBy;
		reduceBy = getChange >= 00.25 ? 00.25 : reduceBy;
		reduceBy = getChange >= 01.00 ? 01.00 : reduceBy;
		reduceBy = getChange >= 05.00 ? 05.00 : reduceBy;
		reduceBy = getChange >= 10.00 ? 10.00 : reduceBy;
		reduceBy = getChange >= 20.00 ? 20.00 : reduceBy;
		reduceBy = getChange >= 50.00 ? 50.00 : reduceBy;
		reduceBy = getChange >= 100.00 ? 100.00 : reduceBy;

//		System.out.println("reducing: " + reduceBy);
		return reduceBy;
	}

	public static String getDollarCurrency(double prev, int count) {
		String currency = "";

		switch (String.format("%.2f", prev)) {
		case "100.00":
			currency = "One Hundred bill";
			break;
		case "50.00":
			currency = "Fifty Dollar bill";
			break;
		case "20.00":
			currency = "Twenty Dollar bill";
			break;
		case "10.00":
			currency = "Ten Dollar bill";
			break;
		case "5.00":
			currency = "Five Dollar bill";
			break;
		case "1.00":
			currency = "One Dollar bill";
			break;
		case "0.25":
			currency = "Quarter";
			break;
		case "0.10":
			currency = "Dime";
			break;
		case "0.05":
			currency = "Nickel";
			break;
		case "0.01":
			currency = count > 1 ? "Penny" : "Pennies";
			break;

		default:
			break;

		}

		if (count > 1 && count > 0.01) {
			currency += "s";
		}
		;
//		System.out.printf("%d %s %n", count, currency);
		return String.format("%d %s, ", count, currency);

	}
}
