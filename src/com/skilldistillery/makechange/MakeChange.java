package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean userInput = true;

		while (true) {
			System.out.print("(1)Run Test | (2) Run App: ");
			String runTest = sc.nextLine().toLowerCase();
			if (runTest.equals("1")) {
				userInput = false;
				break;

			} else if (runTest.equals("2")) {
				userInput = true;
				break;
			}

		}

		while (true) {
			System.out.println();
			System.out.println("--------------------------");
			System.out.println("-- Welcome Register App --");
			System.out.println("--------------------------");

			runApp(userInput, sc);

			System.out.printf("%nPress enter to continue: Enter \"exit\" to quit: ");
			sc.nextLine();
			String quit = sc.nextLine().toLowerCase();

			if (quit.equals("exit")) {
				break;
			}
			System.out.println();
			System.out.println("**************************************");

		}

		sc.close();

	}

	public static void runApp(boolean userInput, Scanner scanner) {
		double amountDue;
		double tendered;

		if (userInput) {
			System.out.print("What is the total Amount Due:  $");
			amountDue = scanner.nextDouble();

			System.out.print("What amount is being tindered: $");
			tendered = scanner.nextDouble();

		} else {

			amountDue = randomDbl();
			tendered = randomDbl();

			System.out.printf("Amount Tendered:  $%.2f %n", tendered);
			System.out.printf("Purchase Price:   $%.2f %n", amountDue);

		}

		double difference = tendered - amountDue;
		System.out.printf("Change:    	  $%.2f %n", difference);

		if (amountDue == tendered) {
			System.out.println("Thank you, have a nice day.");

		} else if (tendered > amountDue) {

			getChange(difference);

		} else {

			System.out.println("Sorry, you dont have enough");

		}

	};

	public static double randomDbl() {

		int max = 500;
		int min = 0;

		double randomNum = (Math.random() * (max + 1)) + min;
		double value = Math.round(randomNum * 100.0) / 100.0;

//		System.out.printf("RandomDbl: %.2f from %f", value,randomNum);

		return value;
	}

	public static void getChange(double change) {

		String changeStr = "";

		double getChange = change;
		double prevVal = getReduction(getChange);

		int count = 0;

		while (getChange > 0) {

			double reduce = getReduction(getChange);

			if (prevVal != reduce) {

				changeStr += getCurrencyStr(prevVal, count);
//				changeStr += ", ";

				count = 0;
			}

			getChange -= reduce;
			getChange = Math.round(getChange * 100.0) / 100.0;

			prevVal = reduce;
			count++;

		}

		System.out.println("--------------------------");
		changeStr += getCurrencyStr(prevVal, count);
//		changeStr += ".";
		System.out.println(changeStr);

	}

	public static double getReduction(double getChange) {
		double reduceBy = 0;

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

	public static String getCurrencyStr(double prev, int count) {

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
			currency = count > 1 ? "Pennies" : "Penny";
			break;

		default:
			break;

		}
		;

		if (count > 1 && prev > 0.01) {
			currency += "s";
		}
		;

		return String.format("%d %s%n", count, currency);

	}

}
