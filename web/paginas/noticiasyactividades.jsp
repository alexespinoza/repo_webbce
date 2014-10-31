<%@page import="Dao.P_Actividad"%>
<%@page import="Dao.P_Imagenes"%>
<%@page import="Model.dao.ListarActividades"%>
<%@page import="Model.dao.ListarNoticias"%>
<%@page import="Dao.P_Noticia"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="bce-postcontent bce-postcontent-0 clearfix">
 <blockquote>Noticias y Novedades</blockquote>
  <%
     LinkedList<P_Noticia> listNoticia = ListarNoticias.getNoticia("0");
for (int i=0;i<listNoticia.size(); i++){
 P_Noticia noticia = listNoticia.get(i);%>
 <h3><a name="noticia<%=noticia.getIdnoticias()%>"> <%=noticia.getTitulo()%></a></h3>
<p><span style="font-weight: bold;"><%=noticia.getNombre()%></span></p>
<p><%=noticia.getDescripcion()%></p>
    <br clear="all"> 
        <%}%>
     <blockquote>Noticias y Novedades</blockquote>    
          <%
     LinkedList<P_Actividad> listActividad = ListarActividades.getActividades("0");
for (int i=0;i<listActividad.size(); i++){
 P_Actividad actividades = listActividad.get(i);%>
 <h3><a name="actividades<%=actividades.getIdactividades()%>"> <%=actividades.getTitulo()%></a></h3>
<p><span style="font-weight: bold;"><%=actividades.getNombre()%></span></p>
<p><%=actividades.getDescripcion()%></p>
    <br clear="all"> 
        <%}%>


