<%@page import="Model.dao.ListarPromociones"%>
<%@page import="Dao.P_Promociones"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="bce-postcontent bce-postcontent-0 clearfix">
    <blockquote>PROMOCIONES Y OFERETAS</blockquote>
    <%
        LinkedList<P_Promociones> lista_p = ListarPromociones.getPromoOfer();
        for (int a = 0; a < lista_p.size(); a++) {
            P_Promociones PO = lista_p.get(a);
            if (a % 2 == 0) {
    %>
    <div class="bce-content-layout-row">
        <div class="bce-layout-cell layout-item-old-2" style="width: 50%">
             <h3><a name="promooferta<%=PO.getIdpromo_oferta()%>"><%=PO.getTitulo()%></a></h3>
               <h4><%=PO.getNombre()%></h4>
            <p><%=PO.getDescripcion()%></p>
            <p> <b><%=PO.getValido()%></b> </p>
            <a href="<%=PO.getUrl()%>" target="_blank">Ver mas...</a>
        </div>
        <% } else {%>
        <div class="bce-layout-cell layout-item-old-2" style="width: 50%">
             <h3><a name="promooferta<%=PO.getIdpromo_oferta()%>"><%=PO.getTitulo()%></a></h3>
               <h4><%=PO.getNombre()%></h4>
            <p><%=PO.getDescripcion()%></p>
            <p> <b><%=PO.getValido()%></b> </p>
            <a href="<%=PO.getUrl()%>" target="_blank">Ver mas...</a>
        </div>    
    </div>  
    <%}%>
    <%}%>
</div>       
