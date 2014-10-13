<script src="js/FancyZoomHTML.js" type="text/javascript"></script>
<script src="js/FancyZoomHTML.js" type="text/javascript"></script>
<%@page import="Model.dao.ListarTiendas"%><%@page import="java.util.LinkedList"%><%@page import="Dao.P_tiendas"%><%@page contentType="text/html" pageEncoding="UTF-8"%>
<style type="text/css">
h2 { text-align:center;}  h2 a { text-decoration:none;}  
.titulo {background:#FF3300;}  
.bce-img
{ border-radius:5px; margin: 10px 10px; width:190px;    height:100px;   }
</style>
<table width="100%" >
<tr><td>PUNTO DE VENTA</td><td>DIRECCIÓN</td></tr>       
<%
LinkedList<P_tiendas> lista = ListarTiendas.getTiendas();
for (int i=0;i<lista.size(); i++){
 P_tiendas tiendas = lista.get(i);%>
<tr><td><img src="<%=tiendas.getImg1()%>" class="bce-img" title="<%=tiendas.getDescripcion()%>"/></td>
<td ><h3><%=tiendas.getNombre()%> </h3>
<strong>Dorección:</strong> <%=tiendas.getDireccion()%> <br clear='all'>
<strong>Correo:</strong> <%=tiendas.getCorreo()%><br clear='all'>
<% if(session.getAttribute("NomAnexo") !=  null && session.getAttribute("CodAnexo") != null){%>
<strong>TELEFONO:</strong> <%=tiendas.getTelefono()%> <br clear='all'><strong>CELULAR:</strong> <%=tiendas.getCelular()%> <br clear='all'><strong>RPM:</strong> <%=tiendas.getRpm()%> <br clear='all'><a href="<%=tiendas.getMapa()%>" target="_blank">Ver mapa</a><br clear='all'><br clear='all'>
<%}else{%>
<br><p style="color:#F8E0E0;font-style: italic">Para ver todo inicie sesion por favor...</p><%}%><td ></td></tr>
<%}%>                          
</table>