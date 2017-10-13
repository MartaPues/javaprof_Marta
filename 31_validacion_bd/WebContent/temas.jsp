<%@page import="beans.Tema"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>TEMAS</h1>

Tema: <select name="tema">
<% ArrayList<Tema> temas=(ArrayList)request.getAttribute("temas");

   for (Tema t:temas){%>

		<option value=<%=t.getIdTema()%> t.><%=t.getTema()%></option>
  <%} %>
</select> 
</br>
	<a href="Controller?op=toInicio">Volver</a>

</body>
</html>