package com.souhub.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import net.sf.jsr107cache.Cache;
import net.sf.jsr107cache.CacheException;
import net.sf.jsr107cache.CacheFactory;
import net.sf.jsr107cache.CacheManager;

import com.souhub.model.Result;

public class Storage {
	private static Cache cache;
	
	static {
		try {
	        CacheFactory cacheFactory = CacheManager.getInstance().getCacheFactory();
	        cache = cacheFactory.createCache(Collections.emptyMap());
	    } catch (CacheException e) {
	        e.printStackTrace();
	    }
	}
	
	private Storage() {}
	
	private static class SingletonContainer {
		private static Storage instance = new Storage();
	}
	
	public static Storage getInstance() {
		return SingletonContainer.instance;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Result> get(String key) {
		return (ArrayList<Result>) cache.get(key);
	}
	
	public void append(String key, Result result) {
		ArrayList<Result> storage = get(key);
		if (null == storage) {
			storage = new ArrayList<Result>();
		}
		storage.add(result);
		Collections.sort(storage);
		cache.put(key, storage);
	}
	
	public void append(String key, ArrayList<Result> results) {
		ArrayList<Result> storage = get(key);
		Collections.sort(results);
		cache.put(key, storage);
	}
	

}
