package com.hdfc.netbanking.util;

import java.io.IOException;
import java.util.Properties;

public abstract class CommonLoadAbstract {
	private Properties props;

	public void init() throws IOException {
		props = new Properties();
		try {
			props.load(this.getClass().getClassLoader().getResourceAsStream("env.properties"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getServiceKey(String serviceNm) {
		String env = props.getProperty("wsdl.env");
		String wsdlKey = props.getProperty(env + "." + serviceNm +"."+"wsdl");
		return wsdlKey;

	}

}
