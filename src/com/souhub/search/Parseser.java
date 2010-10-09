package com.souhub.search;

import java.math.BigInteger;
import java.security.MessageDigest;

import com.souhub.config.SearchType;

public class Parseser {
	public static String getHashKey(String kw, SearchType type) throws Exception {
		String string = kw + type;
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(string.getBytes(), 0, kw.length());
		return String.format("%1$032X", new BigInteger(1, md.digest()));
	}
	
}
