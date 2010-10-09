<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.souhub.search.Enginer" %>
<%@ page import="com.souhub.model.Engine" %>
<html>
  <body>
  <h1>Souhub Control Panel</h1>
  <input type="button" value="Rebuild Engine Cache" />
  <input type="button" value="New Engine" />
  <hr />
  <h2>Source Engines</h2>
  <%
  ArrayList<Engine> list = Enginer.getInstance().getEngines();
  for (Engine e : list) {
	%>
	<li><%= e.getName() %> <input type="button" value="Edit" onclick="location.href='cp?action=edit&key=<%= e.getKey().getId()%>';"/></li>
	
  <% } %>
  </body>
</html>