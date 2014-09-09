

public class Current extends Account implements Auditable{
	private double maxOverDraw = -100.00;
	private boolean isCheque = false;
	
	
	public Current(String accountNo, int transaction, double balance,double maxOverDraw, boolean isCheque) {
		super(accountNo, transaction, balance);
		this.maxOverDraw = maxOverDraw;
		this.isCheque = isCheque;
		accountType = "Current";
	}
	public double getMaxOverDraw() {
		return maxOverDraw;
	}
	public void setMaxOverDraw(double maxOverDraw) {
		this.maxOverDraw = maxOverDraw;
	}
	public boolean isCheque() {
		return isCheque;
	}
	public void setCheque(boolean isCheque) {
		this.isCheque = isCheque;
	}
	@Override
	public void audit() {
	
		
	}
}
