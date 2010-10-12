package com.souhub.search;

import java.util.Collections;

import net.sf.jsr107cache.Cache;
import net.sf.jsr107cache.CacheException;
import net.sf.jsr107cache.CacheFactory;
import net.sf.jsr107cache.CacheManager;

public class Cacher {
	private static Cache cache;
	static {
		try {
			CacheFactory cacheFactory = CacheManager.getInstance()
					.getCacheFactory();
			cache = cacheFactory.createCache(Collections.emptyMap());
		} catch (CacheException e) {
			e.printStackTrace();
		}
	}

	private Cacher() {};

	public static Cache get() {
		return cache;
	}
}
