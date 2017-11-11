package org.uddi.digitalindiatx.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.uddi.digitalindiatx.types.PayRecept;
import org.uddi.digitalindiatx.types.UddiPayment;


@WebService(endpointInterface = "org.uddi.digitalindiatx.service.UddiGateWayManager")
public class UddiGateWayManagerImpl {
	
	public PayRecept pay(UddiPayment toAccount, UddiPayment fromAccount, double balance)
			throws DatatypeConfigurationException {
	
		PayRecept recept = new PayRecept();
		recept.setFromAccount(fromAccount.getAccountNo());
		recept.setToaccount(toAccount.getAccountNo());
		XMLGregorianCalendar xgcal = null;
		GregorianCalendar cal = new GregorianCalendar();
		xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		recept.setTrnsferDate(xgcal);
		recept.setAmount(5000);
		return recept;
	}

}
