public class Deposit extends Account {
	private double interestRate = 0.0;
	
	public Deposit(String accountNo, int transaction, double balance, double interestRate) {
		super(accountNo, transaction, balance);
		this.interestRate = interestRate;
		accountType = "Deposit";
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
