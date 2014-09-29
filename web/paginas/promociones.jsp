<%@page import="Model.dao.ListarPromociones"%>
<%@page import="Dao.P_Promociones"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="bce-postcontent bce-postcontent-0 clearfix">
<div class="bce-content-layout-br layout-item-old-0">  </div>

         <%
LinkedList<P_Promociones> lista_p = ListarPromociones.getPromoOfer(0, 0);
for (int a=0;a<lista_p.size(); a++){
 P_Promociones PO = lista_p.get(a);
%>


    <% if(a%2==0){
        %>
        <div class="bce-content-layout-row">
     <div class="bce-layout-cell layout-item-old-2" style="width: 50%">
<h3><%=PO.getNombre()%></h3>
<h4><%=PO.getTitulo()%></h4>
<p><%=PO.getDescripcion()%></p>
<img src="<%=PO.getImg()%>">
<p><%=PO.getSubtitulo()%></p>


</div>
<% }else {%>
     <div class="bce-layout-cell layout-item-old-2" style="width: 50%">
<h3><%=PO.getNombre()%></h3>
<h4><%=PO.getTitulo()%></h4>
<p><%=PO.getDescripcion()%></p>
<img src="<%=PO.getImg()%>">
<p><%=PO.getSubtitulo()%></p>

</div>    
</div>  
  <%}%>
  
<%}%>
</div>       
