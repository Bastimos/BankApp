

public class Account {

	private String accountNo = "0000";
	private int transaction = 0;
	private double balance = 0.0;
	protected String accountType = "";
	
	public Account(String accountNo,int transaction,double balance){
		this.accountNo = accountNo;
		this.transaction = transaction;
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getTranscation() {
		return transaction;
	}
	public void setTranscation(int transcation) {
		this.transaction = transcation;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
