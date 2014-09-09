

public class Customer {
	
	private Account account;
	private String name ="";
	private String address ="";
	private String phoneNo ="";
	protected String customerType = "";
	
	public Customer(String name,String address,String phoneNo){
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
	}
	public String getCustomerType(){
		return customerType;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
