<%@page import="java.io.File"%>
<%@ page errorPage="paginas/error.jsp"%>
<jsp:include page="paginas/header.jsp" flush="true"/>
<% 
 String nombre;
if(request.getParameter("content")!=null){  
    String nom = request.getParameter("content");
    nombre = "paginas/"+nom + ".jsp";
 }else if(request.getParameter("OFERTAS")!=null){
         nombre = "mail.jsp";
     }else{
nombre =  "paginas/inicio.jsp";
}

%>
<jsp:include page="<%=nombre%>" flush="true"/> 
<jsp:include page="paginas/footer.jsp" flush="true"/>
