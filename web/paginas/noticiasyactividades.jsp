<%@page import="Model.dao.ListarImg"%>
<%@page import="Dao.P_Actividad"%>
<%@page import="Dao.P_Imagenes"%>
<%@page import="Model.dao.ListarActividades"%>
<%@page import="Model.dao.ListarNoticias"%>
<%@page import="Dao.P_Noticia"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
.article{ display: inline-block;width: 210px;position: relative;vertical-align: top;padding: 0.5em;}
.article figure{ width: 99%;}
.article figure{padding: 0; margin: 0;}
.article figure img{width: 100%;height: 160px;border: solid 5px rgba(250,250,250,0.8);border-radius: 3px;box-shadow: 0 0 2px rgba(0,0,0,0.5);}
div.background img {margin: 10% auto 0 ;border: solid 5px #FFF ;width: auto;height: auto;}
div.background {display: none;position: fixed;top: 0;left: 0;right: 0;bottom: 0;height: 100%;width: 100%;text-align: center;text-align: center;z-index: 1;background-color: rgba(65,66,66,0.5);}
div.background:target {display: inline;}
div.background .close{display: block;width: 700px;height: 0px;top: 10;text-align: right;right: 0px;position: relative;color: #DA1035;font-size: 19px;font-weight: bold;text-shadow: 0 0 4px #DA1035;margin: -30px auto 0;}
div.background .close:hover{font-size: 20px;}
  </style>
<div class="bce-postcontent bce-postcontent-0 clearfix">
    <blockquote>NOTICIAS Y NOVEDADES </blockquote>
  <%
     LinkedList<P_Noticia> listNoticia = ListarNoticias.getNoticia("0");
for (int i=0;i<listNoticia.size(); i++){
 P_Noticia noticia = listNoticia.get(i);%>
 <h3><a name="noticia<%=noticia.getIdnoticias()%>"> <%=noticia.getTitulo()%></a></h3>
<p><span style="font-weight: bold;"><%=noticia.getNombre()%></span></p>
<p><%=noticia.getDescripcion()%></p>
 <%
        LinkedList<P_Imagenes> listimgnoti = ListarImg.getImgNoticias(noticia.getIdnoticias());
        for (int x=0;x<listimgnoti.size(); x++){
            P_Imagenes imgacti = listimgnoti.get(x);%>
<article class="article">
<figure><a href="#<%=imgacti.getIdimagenes()%>" title=""><img src="<%=imgacti.getImg()%>" alt=""></a></figure></article>
<a href="#"><div id="<%=imgacti.getIdimagenes()%>" class="background ">
<img src="<%=imgacti.getImg()%>" alt="<%=imgacti.getTitulo()%>">
 </div></a><%}%><%}%>
        <blockquote>NUESTRAS ACTIVIDADES</blockquote>    
          <%
     LinkedList<P_Actividad> listActividad = ListarActividades.getActividades("0");
for (int i=0;i<listActividad.size(); i++){
 P_Actividad actividades = listActividad.get(i);%>
 <h3><a name="actividades<%=actividades.getIdactividades()%>"> <%=actividades.getTitulo()%></a></h3>
<p><span style="font-weight: bold;"><%=actividades.getNombre()%></span></p>
<p><%=actividades.getDescripcion()%></p>
          <%
        LinkedList<P_Imagenes> listimgacti = ListarImg.getImgActividades(actividades.getIdactividades());
        for (int x=0;x<listimgacti.size(); x++){
            P_Imagenes imgacti = listimgacti.get(x);%>
<article class="article">
<figure><a href="#<%=imgacti.getIdimagenes()%>" title=""><img src="<%=imgacti.getImg()%>" alt=""></a></figure></article>
<a href="#"><div id="<%=imgacti.getIdimagenes()%>" class="background ">
<img src="<%=imgacti.getImg()%>" alt="<%=imgacti.getTitulo()%>">
 </div></a><%}%>
 <br clear="all">
 <a href="<%=actividades.getUrl()%>" class="bce-button" target="_blank">Ver mas...</a>
<%}%>


