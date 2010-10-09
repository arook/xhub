package com.souhub.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.appengine.api.labs.taskqueue.Queue;
import com.google.appengine.api.labs.taskqueue.QueueFactory;
import com.google.appengine.api.labs.taskqueue.TaskOptions;
import com.souhub.config.SearchType;
import com.souhub.model.Engine;
import com.souhub.model.Result;

public class Fetcher {
	private static ArrayList<Engine> engines;

	static {
		engines = Enginer.getInstance().getEngines();
	}

	public static void dispatch(String kw) {
		Queue queue = QueueFactory.getDefaultQueue();

		for (int i = 0; i < engines.size(); i++) {
			queue.add(TaskOptions.Builder.url("/tasks/fetch").param("q", kw)
					.param("k", String.format("%d", i)));
		}
	}

	public static void fetch(String kw, int key) throws Exception {
		Engine engine = engines.get(key);
		String storageKey = Parseser.getHashKey(kw, SearchType.WEB);  

		String html = fetchUrl(String.format("%s?%s=%s", engine.getAction(),
				engine.getKw(), URLEncoder.encode(kw, engine.getEncode())), engine.getRefer(), engine.getEncode());

		pushHtml(html, engine.getPrepare(), storageKey, engine.getWeight());
	}
	
	public static ArrayList<Result> testFetch(Engine eg) {
		String html = fetchUrl(String.format("%s?%s=%s", eg.getAction(), 
				eg.getKw(), "java"), eg.getRefer(), eg.getEncode());
		return testHtml(html, eg.getPrepare(), eg.getWeight());
	}

	private static String fetchUrl(String url, String refer, String charset) {
		String html = "";
		try {
			URL target = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) target
					.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("x-souhub-version", "2.0.0");

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(connection.getInputStream(), charset.toUpperCase()));
				String line;

				while (null != (line = reader.readLine())) {
					html += line;
				}
			} else {
				// Server returned HTTP error code.
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return html;
	}
	
	private static void pushHtml(String html, String regex, String key, long weight) {
		Pattern p = Pattern.compile(regex, Pattern.DOTALL | Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(html);
		int i = 1;
		while (m.find()) {
			
			Result result = new Result();
			result.setRank(i++);
			result.setEngineWeight(weight);
			result.setUrl(m.group(3));
			result.setTitle(m.group(1));
			result.setBody(m.group(2));
			Storage.getInstance().append(key, result);
		}
	}
	
	private static ArrayList<Result> testHtml(String html, String regex, long weight) {
		Pattern p = Pattern.compile(regex, Pattern.DOTALL | Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(html);
		int i = 1;
		ArrayList<Result> list = new ArrayList<Result>();
		while (m.find()) {
			
			Result result = new Result();
			result.setRank(i++);
			result.setEngineWeight(weight);
			result.setUrl(m.group(3));
			result.setTitle(m.group(1));
			result.setBody(m.group(2));
			list.add(result);
		}
		return list;
	}
}
