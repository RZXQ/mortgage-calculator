import java.text.NumberFormat;
import java.util.Scanner;

public class Calculator {

	private static final String PRINCIPAL = "Principal: ";

	private static final String ANNUAL_INTEREST_RATE = "Annual Interest Rate: ";

	private static final String PERIOD = "Period (Years): ";

	private static final String MORTGAGE = "Mortgage: ";

	private static final int MONTH_IN_A_YEAR = 12;

	private static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(PRINCIPAL);
		int principal = SCANNER.nextInt();

		System.out.println(ANNUAL_INTEREST_RATE);
		double annualInterestRate = SCANNER.nextDouble();

		System.out.println(PERIOD);
		int years = SCANNER.nextInt();

		double monthlyInterestRate = annualInterestRate / MONTH_IN_A_YEAR;
		int numberOfPayments = years * MONTH_IN_A_YEAR;

		double mortgage = calculateMortgage(principal, monthlyInterestRate, numberOfPayments);
		String formattedMortage = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println(MORTGAGE + formattedMortage);

	}

	public static double calculateMortgage(int principal, double monthlyInterestRate, int numberOfPayments) {
		return (principal + monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
				/ (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
	}

}