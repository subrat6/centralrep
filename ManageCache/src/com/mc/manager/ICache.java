package com.mc.manager;

import java.util.Map;

public interface ICache {
	void put(String key,Object value);
	Object get(String key);
	boolean containsKey(String key);
    void putAll(Map<String,Object> objectMap);
}
