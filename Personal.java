public class Personal extends Customer {

	String dateOfBirth = "";
	String ppsNo = "";

	public Personal(String name, String address,String phoneNo,String dateOfBirth,String ppsNo) {
		super(name, address, phoneNo);
		customerType = "Personal";
		this.dateOfBirth = dateOfBirth;
		this.ppsNo = ppsNo;
	}
	public void setDateOfBirth(String dateOfBirth){

		this.dateOfBirth = dateOfBirth;
	}
	public String getDateOfBirth(){
		return dateOfBirth;
	}
	public void setPpsNo(String ppsNo){

		this.ppsNo = ppsNo;
	}
	public String getPpsNo(){
		return ppsNo;
	}
}
