package com.mc.test;

import com.mc.beans.CalculateIntrest;
import com.mc.manager.CacheManager;

public class CMTest {

	public static void main(String[] args) throws Exception {
		CacheManager cm=new CacheManager();
		CalculateIntrest cl = new CalculateIntrest();
		cl.getIntrest("kolkata", 1000, 12);

	}

}
