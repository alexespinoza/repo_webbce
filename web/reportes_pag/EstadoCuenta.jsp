<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title> Bazar Central del Ejercito del Perú</title>
    </head>
    <body onload="ecc()">
    <center><img src="http://host.campuseduca.net/wp-content/themes/admired/images/gif_carga.gif"/></center>
 <script>
function ecc(){
   document.ecc.submit()
}
</script>
<% 
 if( session.getAttribute("CodAnexo") != null){%>
<form  action="EstadoCuentaCliente" method="post" name="ecc">
    <input type="hidden" name="id" id="id" value="<%=session.getAttribute("CodAnexo")%>"/> 
</form>
 <%   
}else{
System.out.println("<script> window.close(); </script>");
System.out.println("Por favor inicie sesión...");
 }
%>
</body>
</html>