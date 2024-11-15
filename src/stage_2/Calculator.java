package stage_2;

import java.text.NumberFormat;
import java.util.Scanner;

public class Calculator {

	private static final String PRINCIPAL = "Principal: ";

	private static final String ANNUAL_INTEREST_RATE = "Annual Interest Rate: ";

	private static final String PERIOD = "Period (Years): ";

	private static final String MORTGAGE = "Mortgage: ";

	private static final int MONTHS_IN_YEAR = 12;

	private static final int PERCENT = 100;

	private static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print(PRINCIPAL);

		int principal;
		while (true) {
			principal = SCANNER.nextInt();
			if (principal >= 1000 && principal <= 1000000) {
				break;
			}
			System.out.println("Enter a value between 1000 and 1000000");
		}

		double monthlyInterestRate;
		while (true) {
			System.out.print(ANNUAL_INTEREST_RATE);
			double annualInterestRate = SCANNER.nextDouble();
			if (annualInterestRate >= 1 && annualInterestRate <= 30) {
				monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
				break;
			}
			System.out.println("Enter a value between 1 and 30");
		}

		int numberOfPayments;
		while (true) {
			System.out.print(PERIOD);
			int years = SCANNER.nextInt();
			if (years >= 1 && years <= 30) {
				numberOfPayments = years * MONTHS_IN_YEAR;
				break;
			}
			System.out.println("Enter a value between 1 and 30");
		}

		double mortgage = calculateMortgage(principal, monthlyInterestRate, numberOfPayments);

		String mortageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println(MORTGAGE + mortageFormatted);

	}

	public static double calculateMortgage(int principal, double monthlyInterestRate, int numberOfPayments) {
		return (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
				/ (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
	}

}