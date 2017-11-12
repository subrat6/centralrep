package com.hdfc.netbanking.delegate;

import java.io.IOException;
import java.util.Date;

import org.uddi.digitalindiatx.service.UddiGateWayManager;
import org.uddi.digitalindiatx.types.PayRecept;
import org.uddi.digitalindiatx.types.UddiPayment;

import com.hdfc.netbanking.util.UDDIGateWayServiceLocator;
import com.hdfc.netbanking.vo.AccountVo;
import com.hdfc.netbanking.vo.DisplayVo;

public class CustomerFundsTransferBusinessDelegate {
	private String ServiceNm;
	private UddiPayment toAccount;
	private UddiPayment fromAccount;
	private PayRecept recept;
	private double balance;

	public CustomerFundsTransferBusinessDelegate(String serviceNm, double balance) {
		// super();
		ServiceNm = serviceNm;
		this.balance = balance;
	}

	public DisplayVo proceedTx(AccountVo aVo) throws IOException {
		UDDIGateWayServiceLocator locator = UDDIGateWayServiceLocator.getInstance();
		UddiGateWayManager port = locator.getPort(ServiceNm);
		toAccount = new UddiPayment();
		toAccount.setAccountHolderName("bunty");
		toAccount.setAccountNo(aVo.getToAccount());
		toAccount.setIfscCode("sbi2011");
		toAccount.setMobileNo("9937800443");
		fromAccount = new UddiPayment();
		fromAccount.setAccountHolderName("sweta");
		fromAccount.setAccountNo(aVo.getFromAccount());
		fromAccount.setIfscCode("hdfc9011");
		fromAccount.setMobileNo("7683982270");
		recept = port.pay(fromAccount, toAccount, balance);
		DisplayVo dvo = new DisplayVo();
		dvo.setAmount((float) recept.getAmount());
		dvo.setFromAccount(recept.getFromAccount());
		dvo.setFromaccountHolderName(fromAccount.getAccountHolderName());
		dvo.setToAccount(recept.getToaccount());
		dvo.setToaccountHolderName(toAccount.getAccountHolderName());
		dvo.setRemarks("succdess");
		dvo.setTransactionDt(new Date());
		return dvo;

	}
	/*
	 * public void setServiceNm(String serviceNm) { ServiceNm = serviceNm; }
	 */

}
