<%@page import="javax.jdo.PersistenceManager"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.souhub.search.Enginer" %>
<%@ page import="com.souhub.model.*" %>
<html>
  <body>
  <h1>Souhub Control Panel</h1>
  <input type="button" value="Rebuild Engine Cache" />
  <input type="button" value="New Engine" />
  <hr />
  
  <%
  
  Engine engine = (Engine) request.getAttribute("engine");
 
	%>
	<%= engine.getName() %>
	
  </body>
</html>