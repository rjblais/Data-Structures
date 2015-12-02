package assignment01;

public class Loan {

	private double annualInterestRate;
	private int numberOfYears;
	private double balance;

	protected Loan() {
	}

	protected Loan(double annualInterestRate, int numberOfYears,
			double loanAmount) {
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.balance = loanAmount;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public double getMonthlyInterst() {
		return balance * (annualInterestRate / 100 / 12);
	}

	public double getTotalInterest() {
		return getTotalPayment() - balance;
	}

	public int getNumberOfYears() {
		return numberOfYears;
	}

	public double getLoanAmount() {
		return balance;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	public void setLoanAmount(double loanAmount) {
		this.balance = loanAmount;
	}

	// The getMonthlyPayment method returns the
	// calculated the equated monthly installment.
	public double getMonthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 100 / 12;
		double monthlyPayment = balance
				* (monthlyInterestRate
				* Math.pow(1 + monthlyInterestRate, 12 * numberOfYears) /
				(Math.pow(1 + monthlyInterestRate, 12 * numberOfYears) - 1));
		return monthlyPayment;
	}

	// The getTotalPayment method returns the total payment
	// for the entire loan period.
	public double getTotalPayment() {
		double totalPayment = getMonthlyPayment() * 12 * numberOfYears;
		return totalPayment;
	}
		
	// The getAmortizationTable method returns the table array. The correct
	// values for the amortization table are put into table by the for loop.
	public double[][] getAmortizationTable() {
		double[][] table = new double[4][(numberOfYears * 12) + 1];
		double loanAmount = balance;
		double monthlyPayment = getMonthlyPayment();
		table [3][0] = balance;
		
		for (int i = 1; i < 13; i++) {
			double interest = getMonthlyInterst();
			double principle = monthlyPayment - interest;
			setLoanAmount(getLoanAmount() - (principle));
			table [0][i] = monthlyPayment;
			table [1][i] = interest;
			table [2][i] = principle;
			table [3][i] = balance;
		}
		balance = loanAmount;
		return table;
	}
}
