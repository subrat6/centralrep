package com.mc.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache implements ICache {
	private static Cache instance;
	private Map<String, Object> datamap;

	private Cache() {
		datamap = new ConcurrentHashMap<String, Object>();
	}

	public static synchronized Cache getInstance() {
		if (instance == null) {
			instance = new Cache();
		}
		return instance;
	}

	@Override
	public void put(String key, Object value) {
		datamap.put(key, value);

	}

	@Override
	public Object get(String key) {
		return datamap.get(key);
	}

	@Override
	public boolean containsKey(String key) {
		return datamap.containsKey(key);
	}

	@Override
	public void putAll(Map<String, Object> objectMap) {
		datamap.putAll(objectMap);
	}

}
