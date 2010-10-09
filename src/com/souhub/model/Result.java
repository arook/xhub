package com.souhub.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Result implements Serializable, Comparable<Result> {
	private long engineWeight;
	private int rank;
	private String url;
	private String title;
	private String body;
	private String cache;
	
	public long getEngineWeight() {
		return engineWeight;
	}
	public void setEngineWeight(long engineWeight) {
		this.engineWeight = engineWeight;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCache() {
		return cache;
	}
	public void setCache(String cache) {
		this.cache = cache;
	}
	@Override
	public int compareTo(Result o) {
		Long range = rank/engineWeight;
		Long range1 = o.rank/o.engineWeight;
		return range.compareTo(range1);
	}
	
	
}
