package com.ci.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
	private static Cache instance;
	private Map<String, Object> datamap = new ConcurrentHashMap<String, Object>();
	private static String ri;
	private static Properties props = new Properties();
	static {
		ri = PropertiesConst.ri;
		/*
		 * ClassLoader classLoader =
		 * Thread.currentThread().getContextClassLoader(); try {
		 * props.load(classLoader.getResourceAsStream(
		 * "/WEB-INF/intrest.properties")); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		InputStream is = null;
		try {
			is = new FileInputStream("E:/DataStructuresprogram/CalculateIntrest/WebContent/WEB-INF/intrest.properties");
			props.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// props.load(new
		// FileInputStream(request.getServletContext().getRealPath("/WEB-INF/intrest.properties")));
		// props.load(request.getServletContext().getResourceAsStream("/WEB-INF/intrest.properties"));
		/*
		 * try { FileReader reader=new FileReader(
		 * "E:/DataStructuresprogram/ReadProperties/WebContent/WEB-INF/intrest.properties"
		 * ); props.load(reader); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		//instance.put(ri, props);
	}

	private Cache() {
		// datamap=new ConcurrentHashMap<String,Object>();
		/*
		 * if (instance != null) { instance.put(ri, props); } else {
		 * System.out.println("empty"); }
		 */

	}

	public static synchronized Cache getInstance() {
		if (instance == null) {
			instance = new Cache();
			instance.put(ri, props);
		}
		return instance;
	}

	public void put(String key, Object value) {
		datamap.put(key, value);
	}

	public Object get(String key) {
		return datamap.get(key);
	}

	public boolean containsKey(String key) {
		return datamap.containsKey(key);
	}

}
