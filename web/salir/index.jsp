<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" %>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Salir---> BCE</title> </head>
<body>

<br/>
<% 
   
request.getSession().removeAttribute("NomAnexo");
request.getSession().removeAttribute("CodAnexo");
session.invalidate();
 response.sendRedirect("/webbce");
%>

<br/>


</body>
</html>