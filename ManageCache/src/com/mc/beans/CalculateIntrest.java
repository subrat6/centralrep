package com.mc.beans;

import java.util.Properties;

import com.mc.accessor.IntrestPropertiesConst;
import com.mc.manager.Cache;

public class CalculateIntrest {
	private Cache cache;

	public void getIntrest(String city, double princpleamount, double tenure) throws Exception {
		double intrestrate = 0;
		double totalamount = 0;
		cache = Cache.getInstance();
		Properties props = (Properties) cache.get(IntrestPropertiesConst.key);
		if (props.containsKey(city) == false) {
			throw new Exception("PLZ enter valid city");
		}
		intrestrate = Double.parseDouble(props.getProperty(city));
		totalamount = (princpleamount * tenure * intrestrate) / 100;
		System.out.println("your total amount =" + totalamount);

	}

}
