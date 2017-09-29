package com.mc.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.mc.accessor.IAcessor;
import com.mc.accessor.IntrestPropertiesAcessor;

public class CacheManager {
	private Cache cache;
	private List<IAcessor> acessors;
	private Map<String, Object> loadData;

	public CacheManager() throws IOException {
		cache = Cache.getInstance();
		acessors = new ArrayList<IAcessor>();
		loadData = new ConcurrentHashMap<String, Object>();
		load();

	}

	public void load() throws IOException {
		IAcessor acessor = null;
		acessor = new IntrestPropertiesAcessor();
		acessors.add(acessor);
		for (IAcessor acessor1 : acessors) {
			acessor1 = acessor;
			loadData.put(acessor1.getKey(), acessor1.getData());
		}
		cache.putAll(loadData);

	}

}
