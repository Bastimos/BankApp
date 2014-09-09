public class Business extends Customer implements Auditable{

	private String vatNumber = "";
	private boolean isTaxClearance = false;

	public Business(String name, String address,String phoneNo,String vatNumber,boolean isTaxClearance ) {
		super(name, address, phoneNo);
		customerType = "Business";
		this.vatNumber = vatNumber;
		this.isTaxClearance = isTaxClearance;
	}
	public String getVatNumber() {
		return vatNumber;
	}
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}
	public boolean isTaxClearance() {
		return isTaxClearance;
	}
	public void setTaxClearance(boolean isTaxClearance) {
		this.isTaxClearance = isTaxClearance;
	}
	@Override
	public void audit() {
		// TODO Auto-generated method stub
		
	}
}
