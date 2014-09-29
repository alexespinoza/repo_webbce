<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" %>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Logged Out</title> </head>
<body>

<br/>
<% 
   
request.getSession().removeAttribute("NomAnexo");
 session.invalidate();
  response.sendRedirect("/webbce");
%>

<br/>


</body>
</html>