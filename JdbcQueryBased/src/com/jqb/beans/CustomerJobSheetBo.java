package com.jqb.beans;

import java.util.List;

public class CustomerJobSheetBo {
	private CustomerBo customer;
	private List<JobsheetBo> jobsheets;
	public CustomerBo getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerBo customer) {
		this.customer = customer;
	}
	public List<JobsheetBo> getJobsheets() {
		return jobsheets;
	}
	public void setJobsheets(List<JobsheetBo> jobsheets) {
		this.jobsheets = jobsheets;
	}
	@Override
	public String toString() {
		return "CustomerJobSheetBo [customer=" + customer + ", jobsheets="
				+ jobsheets + "]";
	}
	

}
