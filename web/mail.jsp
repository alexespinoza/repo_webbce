<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send an e-mail</title>
</head>
<body>
    
    <%
        String nombre;
if(request.getParameter("OFERTAS")!=null){  
    String x;
    String nom = request.getParameter("OFERTAS");
    x=nom.substring(7, 15);
     out.print(nom);
       // out.print(x);
    
 }
%>
	<form action="EmailSendingServlet" method="post">
		<table border="0" width="35%" align="center">
			<caption>
                            <h2>enviar Correo</h2>
                        </caption>
			<tr>
				<td width="50%">dirección del destinatario </td>
				<td><input type="text" name="recipient" size="50"/></td>
			</tr>
			<tr>
				<td>Asunto: </td>
				<td><input type="text" name="subject" size="50"/></td>
			</tr>
			<tr>
				<td>Contenido </td>
				<td><textarea rows="10" cols="39" name="content"></textarea> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Send"/></td>
			</tr>
		</table>
		
	</form>
</body>
</html>