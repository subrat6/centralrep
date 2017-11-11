package com.udds.test;

import javax.xml.ws.Endpoint;

import org.uddi.digitalindiatx.service.UddiGateWayManagerImpl;

public class UDDIGateWayTest {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8081/UDDIGatewayService/publisher", new UddiGateWayManagerImpl());
		

	}

}
