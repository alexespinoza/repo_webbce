<%@page import="Model.dao.ListarNoticias"%>
<%@page import="Dao.P_Noticia"%>
<%@page import="Model.dao.ListarMenu"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Dao.P_Menu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="es">
<head>
<meta charset="utf-8"/>
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Pragma" content="no-cache" />
<title> Bazar Central del Ejercito del Perú</title>
<link rel="shortcut icon" href="images/BCEIco.ico"/>
<meta name="viewport" content="initial-scale = 1.0, maximum-scale = 1.0, user-scalable = no, width = device-width"/>
<!--[if lt IE 9]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<link rel="stylesheet" href="css/style.css" media="screen"/>
<!--[if lte IE 7]><link rel="stylesheet" href="style.ie7.css" media="screen" /><![endif]-->
<link rel="stylesheet" href="css/style.responsive.css" media="all"/>
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Ubuntu&amp;subset=latin"/>
<link rel="stylesheet" type="text/css" href="css/bce_style.css"/>
<script src="js/jquery.js"></script>
 <script src="js/script.js"></script>
<script src="js/script.responsive.js"></script>
<script src="js/validar.js"></script>
<script>
    jQuery(function($) {
    'use strict';
    if ($.fn.slider) {
        $(".bce-slidecontainer5f4d0").each(function () {
            var slideContainer = $(this), tmp;
            var inner = $(".bce-slider-inner", slideContainer);
            var helper = null;
            inner.children().eq(0).addClass("active");
            slideContainer.slider({
                pause: 2600,
                speed: 600,
                repeat: true,
                animation: "fade",
                direction: "next",
                navigator: slideContainer.siblings(".bce-slidenavigator5f4d0"),
                helper: helper
                            });
        });
    }
});
</script>
<meta name="description" content="Bazar Central del Ejercito del PERÚ"/>
</head>
<body>
<div id="bce-main">
<header class="bce-header clearfix">
<div class="bce-shapes">
<h3 class="bce-headline" data-left="31.59%">
 Bazar Central del Ejército
</h3>
<h2 class="bce-slogan" data-left="36.98%">Bazar central del PERÚ</h2>
<div class="bce-object1997802817" data-left="0%"></div>
</div>
<div class="bce-user" data-left="100%">
    <%
        String user ="";
        String logeo ="" ;
        if(session.getAttribute("NomAnexo") !=  null && session.getAttribute("CodAnexo") != null){
            user=(session.getAttribute("NomAnexo")).toString();
    logeo=("Bienvenido:  <br>" + user + " <a href='paginas/Logout.jsp' >Salir</a>");
    
        }else{%>
        <a href="https://www.facebook.com/pages/Bazar-Central-del-Ej%C3%A9rcito-Oficial/1437488386503042" target="_blank">
            <img src="http://www.cultivohidroponico.com/imagenes_hidroponia/btn_facebook.png"></a>
       <% }
        %>
    <h4 ><%=logeo%></h4> 
</div>
</header>
<div class="bce-sheet clearfix">
<nav class="bce-nav clearfix">
<ul class="bce-hmenu">
<%
    LinkedList<P_Menu> lista = ListarMenu.getMenu();
for (int i=0;i<lista.size(); i++){
 P_Menu menu = lista.get(i);%>
   <li><a href="?content=<%=menu.getUrl()%>"><%=menu.getTitulo()%></a>
    <%
    LinkedList<P_Menu> lista_sub = ListarMenu.getMenu_submenu(menu.getIdmenu());
    if(lista_sub.size()>0){
        out.println(" <ul> ");
      for (int x=0;x<lista_sub.size(); x++){
 P_Menu menu_sub = lista_sub.get(x);
 %> 
  <li><a href="?content=<%=menu_sub.getUrl()%>"><%=menu_sub.getTitulo()%></a></li>
  <%}
  out.println(" </ul> ");
  }
 out.println(" </li> ");
}
 %>
</ul> 
    </nav>
<div class="bce-layout-wrapper clearfix">
                <div class="bce-content-layout">
                    <div class="bce-content-layout-row">
                        <div class="bce-layout-cell bce-sidebar1 clearfix">

<%
String nombres ;String codanexo;String aut;String sucess="";String ms ="";
if( session.getAttribute("NomAnexo") !=  null && session.getAttribute("CodAnexo") != null){
 nombres = (session.getAttribute("NomAnexo")).toString() ;
 codanexo = (session.getAttribute("CodAnexo")).toString() ;
 ms=request.getParameter("ms");%>
 <div class="bce-block clearfix">
        <div class="bce-blockcontent">
   <div class="bce-square">
    <blockquote>Bienvenido:</blockquote>
    <br clear="all">
      <p> <%=nombres %> </p><br clear="all">
    <a href="Logout.jsp">Salir</a>
    <br clear="all"><br clear="all">
  </div>
    <br clear="all">
    <div class="bce-square">
    <blockquote>Administrar</blockquote>
        <jsp:include page="option_user.jsp" flush="true" />
   </div>
</div></div>
    <%
}else{
    %>
    <div class="bce-block clearfix">
        <div class="bce-blockcontent">
    <div class="bce-square">
    <blockquote>Iniciar Sesión</blockquote>
 <form action="LoginServlet" >
 <br clear="all"> 
<div> <label for="Usuario">Nro. Administrativo</label></div>
<div class="bce-log" >
<input type="text" name="codanexo" autocomplete="off" title="Ingrese su Nro. Administrativo" id="codanexo" MaxLength="9" title="Ingrese su Nro. Administrativo" required required onkeypress="numero()">
</div>
<div><label for="documento" >DNI</label></div>
<div class="bce-log"> <input type="text" name="documento" autocomplete="off"  id="documento" MaxLength="8"  title="Ingrese su Nro. DNI" required required onkeypress="numero()">
</div>
     <div><label for="password">Contraseña</label> </div>
     <div class="bce-log"> <input type="password" name="password"  id="password" title="Ingrese su contraseña"></div>
<div class="Acceder"> <br clear="all">
 <a href="?content=recuperar-clave">Olvido su clave</a><br clear="all"><br clear="all">
<input type="submit" class="bce-button bce-button" value="Acceder" name="submit">
 <br clear="all"><br clear="all"> 
         <% if(session.getAttribute("ms")!=null){%>
           <p class="bce_error">${ms}</p>  
        <% }%>
         
</div>
</form>
 <br clear="all">
  </div>
 <br clear="all">
    <div class="bce-square">
    <blockquote>Registrese</blockquote>
    <br clear="all">
    <a href="?content=registro">Registrese</a>
    <br clear="all"><br clear="all">
  </div>
     <%
 nombres = "";
 codanexo="";
aut ="";
    %>
    </div>
    </div>
    <%}%>
<!--<p> <%=ms%>  </p>-->
<!---->
 <div class="bce-block clearfix">
        <div class="bce-blockcontent">
   <div class="bce-square">
    <blockquote>Noticias y Actividades</blockquote>
    <%
     LinkedList<P_Noticia> listNoticia = ListarNoticias.getNoticia("1");
for (int i=0;i<listNoticia.size(); i++){
 P_Noticia noticia = listNoticia.get(i);%>
<h3><%=noticia.getTitulo()%></h3>
<p><span style="font-weight: bold;"><%=noticia.getNombre()%></span></p>
<p><%=noticia.getDescripcion()%></p>
<p><a href="?noticiasyactividades=noticiasyactividades#conten<%=noticia.getIdnoticias()%>" class="bce-button">Ver Mas..</a></p>
    <br clear="all"> 
        <%}%>
  </div></div></div>
 </div>

<!--content-->
<div class="bce-layout-cell bce-content clearfix">
<article class="bce-post bce-article">