package com.hdfc.netbanking.test;

import java.io.IOException;

import com.hdfc.netbanking.delegate.CustomerFundsTransferBusinessDelegate;
import com.hdfc.netbanking.vo.AccountVo;

public class HDFCNBTest {

	public static void main(String[] args) throws IOException {
		AccountVo avo=new AccountVo();
		avo.setAmount(5000);
		avo.setFromAccount("ac1222");
		avo.setToAccount("ac90123");
		avo.setRemarks("sucesss payment");
		CustomerFundsTransferBusinessDelegate cfbd=new CustomerFundsTransferBusinessDelegate("UddiGateWayManagerImplService",avo.getAmount());
		System.out.println(cfbd.proceedTx(avo));
		
		

	}

}
