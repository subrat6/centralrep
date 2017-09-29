package com.don.beans;

import java.util.Properties;

import com.don.util.Cache;

public class LoanPlaner {
	private Cache cache;
	public void getTotalRate(double princple,double tenure,String place) throws Exception{
		double intrestRate=0;
		double totalAmount=0;
		Properties props=null;
		props=(Properties) cache.get("rate-ri");
		if (props.containsKey(place)==false) {
			throw new Exception("plz provide proper place");
		}
		intrestRate=Double.parseDouble(props.getProperty(place));
		totalAmount=(princple * tenure * intrestRate)/100;
		System.out.println("Your total amount is ="+totalAmount);
		
	}
	/**
	 * @param cache the cache to set
	 */
	public final void setCache(Cache cache) {
		this.cache = cache;
	}
	

}
