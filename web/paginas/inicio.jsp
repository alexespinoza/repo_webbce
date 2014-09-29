<%@page import="Model.dao.ListarPromociones"%>
<%@page import="Dao.P_Promociones"%>
<%@page import="Model.dao.ListarImg"%>
<%@page import="Dao.P_Imagenes"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="bce-postmetadataheader"><h2 class="bce-postheader">Nuestras Tiendas</h2>
</div>
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
<!-- <div class="bce-slide-item">
     --><img src="<%=img.getImg()%>" class="bce-slide-item" title="<%=img.getTitulo()%>">
     <!--</div>-->
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

<!-- IMAGENES-->
</div>
</div>
</div>
 <div class="bce-content-layout-br layout-item-old-0">  </div>
<%
LinkedList<P_Promociones> lista_p = ListarPromociones.getPromoOferInicio();
for (int a=0;a<lista_p.size(); a++){
 P_Promociones PO = lista_p.get(a);
 if(a%2==0){%>
        <div class="bce-content-layout-row">
     <div class="bce-layout-cell layout-item-old-2" style="width: 50%">
<h3><%=PO.getNombre()%></h3>
<h4><%=PO.getTitulo()%></h4>
<p><%=PO.getDescripcion()%></p>
<p><a href="?OFERTAS=OFERTAS<%=PO.getIdpromo_oferta()%>" class="bce-button">Ver Mas.. .</a></p>
</div>
<% }else {%>
     <div class="bce-layout-cell layout-item-old-2" style="width: 50%">
<h3><%=PO.getNombre()%></h3>
<h4><%=PO.getTitulo()%></h4>
<p><%=PO.getDescripcion()%></p>
<p><a href="#" class="bce-button">Ver Mas.. .</a></p>

</div>    
</div>  
  <%}
}%>
         
<!--
<div class="bce-content-layout-row">
<div class="bce-layout-cell layout-item-old-2" style="width: 50%">
<h3>Temporada Verano 2014 - bce</h3>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et </p>
<p><a href="#" class="bce-button">Ver Mas.. .</a></p>
</div>

<div class="bce-layout-cell layout-item-old-2" style="width: 50%">
<h3>Promociones bce</h3>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrxcepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum..</p>
<p><a href="#" class="bce-button">Ver Mas...</a></p>
</div>

</div>
    

    
<div class="bce-content-layout-row">
<div class="bce-layout-cell layout-item-old-2" style="width: 50%">
<h3>Temporada Verano 2014 -bce </h3>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
<p><a href="#" class="bce-button">Ver Mas...</a></p>
</div>

<div class="bce-layout-cell layout-item-old-2" style="width: 50%">
<h3>Promociones</h3>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum..</p>
<p><a href="#" class="bce-button">Ver Mas...</a></p>
</div>

</div>
  
<div class="bce-content-layout-row">
<div class="bce-layout-cell layout-item-old-2" style="width: 50%">
<h3>Temporada Verano 2014 -bce </h3>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
<p><a href="#" class="bce-button">Ver Mas...</a></p>
</div>

<div class="bce-layout-cell layout-item-old-2" style="width: 50%">
<h3>Promociones</h3>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum..</p>
<p><a href="#" class="bce-button">Ver Mas...</a></p>
</div>

</div>
    
    <div class="bce-content-layout-row">
<div class="bce-layout-cell layout-item-old-2" style="width: 50%">
<h3>Temporada Verano 2014 -bce </h3>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
<p><a href="#" class="bce-button">Ver Mas...</a></p>
</div>

<div class="bce-layout-cell layout-item-old-2" style="width: 50%">
<h3>Promociones</h3>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
proident, sunt in culpa qui officia deserunt mollit anim id est laborum..</p>
<p><a href="#" class="bce-button">Ver Mas...</a></p>
</div>

</div>
 -->
    
</div>

</div>
<!--</div>-->
<!-- end dinamico -->
