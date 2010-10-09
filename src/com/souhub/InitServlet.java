package com.souhub;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souhub.model.Engine;
import com.souhub.search.Enginer;

@SuppressWarnings("serial")
public class InitServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Engine e = new Engine();
		e.setName("百度");
		e.setType("web");
		e.setSite("www.baidu.com");
		e.setWeight(2);
		e.setEnable(true);
		e.setEncode("gbk");
		e.setRefer("http://www.baidu.com/gaoji/advanced.html");
		e.setAction("http://www.baidu.com/s");
		e.setMethod("get");
		e.setKw("wd");
		e.setStart("start");
//		e.setPrepare("<table[^<>]+class=\"result\"[^<>]+>.*?<a[^<>]+onmousedown=[^<>]+href=\"(?P<url>[^\"]*)\"[^<>]+><font size=\"3\">(?P<title>.*?)</font></a><br><font size=-1>(?P<body>.*?)<br>.*?<a href=\"(?P<cache>[^\"]*)\"[^<>]+class=\"m\">.*?</table>");
		e.setPrepare("<table[^<>]+class=\"result\"[^<>]+>.*?<a[^<>]+onmousedown=[^<>]+href=\"([^\"]*)\"[^<>]+><font size=\"3\">(.*?)</font></a><br><font size=-1>(.*?)<br>.*?<a href=\"([^\"]*)\"[^<>]+class=\"m\">.*?</table>");
		
		Enginer.getInstance().addEngine(e);
		
		e = new Engine();
		e.setName("有道");
		e.setType("web");
		e.setSite("www.youdao.com");
		e.setWeight(1);
		e.setEnable(true);
		e.setEncode("utf-8");
		e.setRefer("http://www.youdao.com/");
		e.setAction("http://www.youdao.com/search");
		e.setMethod("get");
		e.setKw("q");
		e.setStart("start");
//		e.setPrepare("<a href=\"([^\"]*)\" id=\"hitURL[0-9]+\"[^<>]+><span id=\"title[0-9]+\">(?P<title>.*?)</span></a>\n.*?</h3>\n<div id=\"summary[0-9]+\"><p>(?P<body>.*?)</p></div>.*?<a id=\"snapshotLink[0-9]+\" href=\"(?P<cache>[^\"]*?)\"");
		e.setPrepare("<a href=\"([^\"]*)\" id=\"hitURL[0-9]+\"[^<>]+><span id=\"title[0-9]+\">(.*?)</span></a>\n.*?</h3>\n<div id=\"summary[0-9]+\"><p>(.*?)</p></div>.*?<a id=\"snapshotLink[0-9]+\" href=\"([^\"]*?)\"");
		Enginer.getInstance().addEngine(e);
	}
}
