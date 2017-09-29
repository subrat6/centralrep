package com.don.accessor;

import java.io.IOException;
import java.util.Properties;

public class IntrestRatePropertiesAcessor implements IAcessor{
	private String key;
	

	public IntrestRatePropertiesAcessor(String key) {
		this.key = key;
	}
	

	@Override
	public String getkey() {
		
		return key;
	}

	@Override
	public Object getData() throws IOException {
		Properties props=null;
		props=new Properties();
		props.load(this.getClass().getClassLoader().getResourceAsStream("intrest-ri.properties"));
		
		return props;
	}

}
