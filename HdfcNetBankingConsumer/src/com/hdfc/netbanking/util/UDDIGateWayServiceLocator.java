package com.hdfc.netbanking.util;

import java.io.IOException;
import java.net.MalformedURLException;

import org.uddi.digitalindiatx.service.UddiGateWayManager;
import org.uddi.digitalindiatx.service.UddiGateWayManagerImplService;

public class UDDIGateWayServiceLocator extends CommonLoadAbstract {
	private static UDDIGateWayServiceLocator instance;

	private UDDIGateWayServiceLocator() throws IOException {
		super.init();
	}

	public static UDDIGateWayServiceLocator getInstance() throws IOException {
		if (instance == null) {
			instance = new UDDIGateWayServiceLocator();
		}
		return instance;
	}

	public UddiGateWayManager getPort(String serviceName) throws MalformedURLException {
		String wsdlKey = getServiceKey(serviceName);
		UddiGateWayManagerImplService umis = new UddiGateWayManagerImplService(new java.net.URL(wsdlKey));
		UddiGateWayManager managerPort = umis.getUddiGateWayManagerImplPort();
		return managerPort;

	}

}
