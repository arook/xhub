package com.souhub.search;

import java.util.ArrayList;

import com.souhub.config.SearchType;
import com.souhub.model.Result;

public class Searcher {
	
	@SuppressWarnings("rawtypes")
	public static ArrayList search(String kw, int page) {
		String hashKey = "";
		try {
			hashKey = Parseser.getHashKey(kw, SearchType.WEB);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Storage storage = Storage.getInstance();
		ArrayList<Result> results;
		if (null == (results = storage.get(hashKey))) {
			Fetcher.dispatch(kw);
			while (true) {
				results = storage.get(hashKey);
				if (null != results) {
					return results;
				}
			}
		} else {
			return results;
		}
	}
	
}
