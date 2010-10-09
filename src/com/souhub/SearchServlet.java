package com.souhub;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souhub.model.Result;
import com.souhub.search.Searcher;

@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int page;
		if (null == req.getParameter("start")) {
			page = 0;
		} else {
			page = Integer.parseInt(req.getParameter("start"));
		}
		ArrayList<Result> lists = Searcher.search(req.getParameter("q"), page);
		resp.setCharacterEncoding("UTF-8");
		for (int i = 0; i < lists.size(); i++) {
			
			resp.getWriter().println(lists.get(i).getTitle());
			resp.getWriter().println(lists.get(i).getBody());
			resp.getWriter().println(lists.get(i).getUrl());
			resp.getWriter().println();
		}
//		resp.sendRedirect("");
	}
}
