package com.souhub;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souhub.search.Fetcher;

@SuppressWarnings("serial")
public class FetchServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String kw = req.getParameter("q");
		int key  = Integer.parseInt(req.getParameter("k"));
		try {
			Fetcher.fetch(kw, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
