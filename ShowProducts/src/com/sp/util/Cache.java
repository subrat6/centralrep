package com.sp.util;

import java.util.Map;

public class Cache
{
  private static Cache instance;
  private Map<String, Object> datamap;
  
  public Cache() {
    datamap = new java.util.HashMap();
  }
  
  public void put(String key, Object value) {
    datamap.put(key, value);
  }
  
  public Object get(String key) {
    return datamap.get(key);
  }
  
  public boolean ContainsKey(String key) {
    return datamap.containsKey(key);
  }
  
  public void clear() { datamap.clear(); }
  
  public static synchronized Cache getInstance() {
    if (instance == null) {
      instance = new Cache();
    }
    return instance;
  }
}
