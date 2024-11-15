import java.text.NumberFormat;
import java.util.Scanner;

public class Calculator {

	private static final String PRINCIPAL = "Principal: ";

	private static final String ANNUAL_INTEREST_RATE = "Annual Interest Rate: ";

	private static final String PERIOD = "Period (Years): ";

	private static final String MORTGAGE = "Mortgage: ";

	private static final int MONTHS_IN_A_YEAR = 12;

	private static final int PERCENT = 100;

	private static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print(PRINCIPAL);
		int principal = SCANNER.nextInt();

		System.out.print(ANNUAL_INTEREST_RATE);
		double annualInterestRate = SCANNER.nextDouble();

		System.out.print(PERIOD);
		int years = SCANNER.nextInt();
		int numberOfPayments = years * MONTHS_IN_A_YEAR;

		double monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_A_YEAR;

		double mortgage = calculateMortgage(principal, monthlyInterestRate, numberOfPayments);
		String formattedMortage = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println(MORTGAGE + formattedMortage);

	}

	public static double calculateMortgage(int principal, double monthlyInterestRate, int numberOfPayments) {
		return (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
				/ (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
	}

}