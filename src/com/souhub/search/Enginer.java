package com.souhub.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.print.attribute.standard.MediaSize.Engineering;

import net.sf.jsr107cache.Cache;
import net.sf.jsr107cache.CacheException;
import net.sf.jsr107cache.CacheFactory;
import net.sf.jsr107cache.CacheManager;

import com.souhub.model.Engine;
import com.souhub.model.PMF;


public class Enginer {
	private Cache cache;
	
	private Enginer() {
		try {
	        CacheFactory cacheFactory = CacheManager.getInstance().getCacheFactory();
	        cache = cacheFactory.createCache(Collections.emptyMap());
	    } catch (CacheException e) {
	        e.printStackTrace();
	    }
	}
	
	private static class SingletonContainerClass{
		private static Enginer instance = new Enginer();
	}
	
	public static Enginer getInstance() {
		return SingletonContainerClass.instance;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Engine> getEngines() {
		ArrayList<Engine> engines = (ArrayList<Engine>) cache.get("engines");
		if (null == engines) {
			initEngines();
			return getEngines();
		}
		return engines;
	}
	
	@SuppressWarnings("unchecked")
	private void initEngines() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + Engine.class.getName();
		List<Engine> engines = (List<Engine>) pm.newQuery(query).execute();
		
		cache.put("engines", new ArrayList<Engine>(engines));
	}
	
	
	public void addEngine(Engine engine) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.makePersistent(engine);
	}
}
