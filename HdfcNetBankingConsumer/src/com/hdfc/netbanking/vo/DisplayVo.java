package com.hdfc.netbanking.vo;

import java.util.Date;

public class DisplayVo {
	private String fromAccount;
	private String fromaccountHolderName;
	private String toAccount;
	private String toaccountHolderName;
	private float amount;
	private Date transactionDt;
	private String remarks;
	public String getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	public String getFromaccountHolderName() {
		return fromaccountHolderName;
	}
	public void setFromaccountHolderName(String fromaccountHolderName) {
		this.fromaccountHolderName = fromaccountHolderName;
	}
	public String getToAccount() {
		return toAccount;
	}
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	public String getToaccountHolderName() {
		return toaccountHolderName;
	}
	public void setToaccountHolderName(String toaccountHolderName) {
		this.toaccountHolderName = toaccountHolderName;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getTransactionDt() {
		return transactionDt;
	}
	public void setTransactionDt(Date transactionDt) {
		this.transactionDt = transactionDt;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "DisplayVo [fromAccount=" + fromAccount + ", fromaccountHolderName=" + fromaccountHolderName
				+ ", toAccount=" + toAccount + ", toaccountHolderName=" + toaccountHolderName + ", amount=" + amount
				+ ", transactionDt=" + transactionDt + ", remarks=" + remarks + "]";
	}



}
