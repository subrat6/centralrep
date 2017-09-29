package com.mc.accessor;

import java.io.IOException;
import java.util.Properties;

public class IntrestPropertiesAcessor implements IAcessor {

	private String key;

	public IntrestPropertiesAcessor() {
		key = IntrestPropertiesConst.key;
	}

	@Override
	public String getKey() {

		return key;
	}

	@Override
	public Object getData() throws IOException {
		Properties props = null;

		props = new Properties();
		props.load(this.getClass().getClassLoader().getResourceAsStream("intrest.properties"));

		return props;
	}

}
