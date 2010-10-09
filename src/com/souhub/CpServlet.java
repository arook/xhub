package com.souhub;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.souhub.model.Engine;
import com.souhub.model.PMF;

@SuppressWarnings("serial")
public class CpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		if (null != req.getParameter("action") && req.getParameter("action").equals("edit")) {
			
			Key k = KeyFactory.createKey(Engine.class.getSimpleName(), Integer.parseInt(req.getParameter("key")));
			Engine engine = (Engine) pm.getObjectById(Engine.class, k);
			req.setAttribute("engine", engine);
			
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/tasks/edit.jsp");
			dispatch.forward(req, resp);
		}
		resp.sendRedirect("/tasks/admin.jsp");
	}

}
