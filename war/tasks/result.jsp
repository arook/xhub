<%@page import="javax.jdo.PersistenceManager"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.souhub.search.Enginer" %>
<%@ page import="com.souhub.model.*" %>
<html>
<style type="text/css">
body{font-size: 16px;}
textarea{width:500px; height: 1050px;}
</style>
  <body>
  <h1>Souhub Control Panel</h1>
  <input type="button" value="Rebuild Engine Cache" />
  <input type="button" value="New Engine" />
  <hr />
  
 	 <div style="position: relative;">
  	<% ArrayList<Result> result = ( ArrayList<Result>) request.getAttribute("result");%>
  	<textarea>
<% for (int i = 0; i < result.size(); i++) { %>
Rank=><%=result.get(i).getRank() %>
Title=><%=result.get(i).getTitle() %>
Url=><%=result.get(i).getUrl() %>
Body=><%=result.get(i).getBody() %>
Cache=><%=result.get(i).getCache() %>


	<%} %>
	</textarea>
	<div style="position: absolute;left:500px;top:0px;">
		<input type="button" name="back" value="Back" onclick="history.back();" />
	</div>
	
	
	</form>
	</div>
	
	
  </body>
</html>