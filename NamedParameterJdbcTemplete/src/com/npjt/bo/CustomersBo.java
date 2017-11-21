package com.npjt.bo;

public class CustomersBo {
	private int customer_no;
	private String first_nm;
	private String last_nm;
	private String email_addr;
	private String mobile_no;

	public int getCustomer_no() {
		return customer_no;
	}

	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}

	public String getFirst_nm() {
		return first_nm;
	}

	public void setFirst_nm(String first_nm) {
		this.first_nm = first_nm;
	}

	public String getLast_nm() {
		return last_nm;
	}

	public void setLast_nm(String last_nm) {
		this.last_nm = last_nm;
	}

	public String getEmail_addr() {
		return email_addr;
	}

	public void setEmail_addr(String email_addr) {
		this.email_addr = email_addr;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	@Override
	public String toString() {
		return "CustomersBo [customer_no=" + customer_no + ", first_nm="
				+ first_nm + ", last_nm=" + last_nm + ", email_addr="
				+ email_addr + ", mobile_no=" + mobile_no + "]";
	}

}
