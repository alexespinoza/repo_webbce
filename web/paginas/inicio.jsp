<%@page import="java.util.Random"%>
<%@page import="Model.dao.ListarPromociones"%>
<%@page import="Dao.P_Promociones"%>
<%@page import="Model.dao.ListarImg"%>
<%@page import="Dao.P_Imagenes"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="bce-postmetadataheader"><h2 class="bce-postheader">Nuestras Tiendas</h2></div>
<div class="bce-postcontent bce-postcontent-0 clearfix">
<div class="bce-content-layout">
<div class="bce-content-layout-row">
<div class="bce-layout-cell layout-item-old-1" style="width: 100%">
<!-- IMAGENES-->
<div class="image-caption-wrapper" >
<div id="5f4d0"  class="bce-collage bce-sliderimg">
<div class="bce-slider bce-slidecontainer5f4d0">
 <div class="bce-slider-inner">
  <%
LinkedList<P_Imagenes> lista = ListarImg.getImg();
for (int i=0;i<lista.size(); i++){
 P_Imagenes img = lista.get(i);%>
 <img src="<%=img.getImg()%>" class="bce-slide-item" title="<%=img.getTitulo()%>">
 <%}%>
    </div>
</div>
<div class="bce-slidenavigator bce-slidenavigator5f4d0">
<a href="#" class="bce-slidenavigatoritem"></a>
      <%
LinkedList<P_Imagenes> lista_ = ListarImg.getImg();
for (int i=0;i<lista_.size(); i++){
 P_Imagenes img = lista_.get(i);%>
 <a href="#" class="bce-slidenavigatoritem"></a>
 <%}%>
</div>
</div>
</div>
<!-- FIN IMAGENES-->
</div>
</div>
</div>
 <div class="bce-content-layout-br layout-item-old-0">  </div>
  <div class="bce-postmetadataheader bce-postheader" >PROMOCIONES Y OFERETAS</div>
<%
LinkedList<P_Promociones> lista_p = ListarPromociones.getPromoOferInicio();
for (int a=0;a<lista_p.size(); a++){
 P_Promociones PO = lista_p.get(a);
 if(a%2==0){%>
        <div class="bce-content-layout-row">
     <div class="bce-layout-cell layout-item-old-2" style="width: 50%">
<h3><%=PO.getTitulo()%></h3>
<h4><%=PO.getNombre()%></h4>
<p><%=PO.getDescripcion()%></p>
<p> <b><%=PO.getValido()%> </b></p>
<p><a href="?promocionesyofertas=promocionesyofertas#promooferta<%=PO.getIdpromo_oferta()%>" class="bce-button">Ver Mas.. .</a></p>
</div>
<% }else {%>
     <div class="bce-layout-cell layout-item-old-2" style="width: 50%">
<h3><%=PO.getTitulo()%></h3>
<h4><%=PO.getNombre()%></h4>
<p><%=PO.getDescripcion()%></p>
<p> <b><%=PO.getValido()%> </b></p>
<p><a href="?promocionesyofertas=promocionesyofertas#promooferta<%=PO.getIdpromo_oferta()%>" class="bce-button">Ver Mas.. .</a></p>
</div>    
</div>  
  <%}
}%>
      
</div>

</div>
<!--</div>-->
<!-- end dinamico -->
