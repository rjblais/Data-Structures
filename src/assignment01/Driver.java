/**
 * Data Structures
 * Assignment #1: What Will It Cost?
 * Ryan Blais
 * 09/02/15
 * 
 * This program is designed to calculate and output certain values to simulate
 * a loan. The user will enter in command values that will prompt
 * user input. The output values are a prompt for the user to enter values,
 * the equated monthly installment, the total amount of interest, the total
 * amount paid for the loan, and an amortization table.
 */

package assignment01;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
				
		// f is a decimal formatter that places a comma after three decimals.
		DecimalFormat f = new DecimalFormat("#,##0.00",
				DecimalFormatSymbols.getInstance());

		Scanner command = new Scanner(System.in);

		Loan loan = null;

		String input;

		do {
			input = command.nextLine();

			// n is the command that will prompt the user to enter
			// a loan principal, a interest rate, and a loan length.
			if (input.equals("n")) {
				System.out.println("Please enter the loan principal,"
						+ " the annual interest rate as %,"
						+ " and the length of the laon in years.");
				int principle = command.nextInt();
				double interest = command.nextDouble();
				int length = command.nextInt();

				loan = new Loan(interest, length, principle);
			}
				
			// The m command displays the monthly payment amount.
			else if (input.equals("m")) {
				System.out.println("Equated Monthly Installment:  $"
						+ f.format(loan.getMonthlyPayment()));
			}

			// The t command displays the total amount of interest
			// and the total to be paid.
			else if (input.equals("t")) {
				System.out.println("Total Payments");
				System.out.println("  Total interest:  $"
						+ f.format(loan.getTotalInterest()));
				System.out.println("  Total Loan Payments:  $"
						+ f.format(loan.getTotalPayment()));
			}

			// The a command displays the amortization table.
			else if (input.equals("a")) {
				System.out.println("Amortization Table");

				System.out.printf("%s %s %s %s %s\n", "Month", "Payment",
						"Interest", "Principle", "Balance");

				double[][] table = loan.getAmortizationTable();
				
				for (int i = 0; i < 13; i++) {
					
					System.out.printf("%-7d %-7s %-7s %-7s %-7s\n", i,
									f.format(table[0][i]),
									f.format(table[1][i]),
									f.format(table[2][i]),
									f.format(table[3][i]));
				}
			}
		// The q command terminates the program.
		} while (!input.equals("q"));

		System.out.println("Goodbye. Program terminated.");

		command.close();
	}
}
