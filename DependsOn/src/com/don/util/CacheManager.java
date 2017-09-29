package com.don.util;

import java.io.IOException;
import java.util.List;

import com.don.accessor.IAcessor;

public class CacheManager {
	private Cache cache;
	private List<IAcessor> accessors;
	public CacheManager(Cache cache, List<IAcessor> accessors) throws IOException {
		this.cache = cache;
		this.accessors = accessors;
		load();
	}
	
	public void load() throws IOException{
		for (IAcessor acessor : accessors) {
			cache.put(acessor.getkey(),acessor.getData());
		}
		
		
	}
	

}
