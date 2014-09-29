<%@page import="Model.dao.ListarMenu"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Dao.P_Menu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

</article>
</div>
</div>
 </div>
 </div>
    </div>


<footer class="bce-footer clearfix">
  <div class="bce-footer-inner">
<div class="bce-content-layout">
    <div class="bce-content-layout-row">
   <div class="bce-layout-cell layout-item-0" style="width: 20%">
  <p style="font-size: 17px; color: #FFB0A3;">Páginas</p>
        <br>
        <ul>
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
}%>
  
        </ul>
    </div>
         <div class="bce-layout-cell layout-item-0" style="width: 20%">
        <p style="font-size: 17px; color: #FFB0A3;">Sociales</p>
        <br>
        <ul>
        <li><a href="https://www.facebook.com/pages/Bazar-Central-del-Ej%C3%A9rcito-Oficial/1437488386503042" target="_blank">Fecebook</a></li>
        </ul>
    </div>
        <div class="bce-layout-cell layout-item-0" style="width: 40%">
            <p style="text-align:right;font-size: 20px">      <b>Visitante Nro: </b> 00015       </p>
            <!--
        <p style="text-align:right"><br>
        <a href="https://www.facebook.com/pages/Bazar-Central-del-Ej%C3%A9rcito-Oficial/1437488386503042" target="_blank"><img width="48" height="48" alt="" src="images/facebook1.png" class=""></a>
        <a href="#"><img width="48" height="48" alt="" src="images/flickr1.png" class=""></a>
        <a href="#"><img width="48" height="48" alt="" src="images/myspace1.png" class=""></a>
        </p>-->
    <script type="text/javascript">
			$(function() {
    			$('a[rel*=leanModal]').leanModal({ top : 200, closeButton: ".modal_close" });		
			});
		</script>
		<script type="text/javascript">

		  var _gaq = _gaq || [];
		  _gaq.push(['_setAccount', 'UA-3318823-14']);
		  _gaq.push(['_trackPageview']);
		
		  (function() {
		    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		  })();

		</script>
    </div>
    </div>
</div>
 <script src="js/jquery.leanModal.min.js" type="text/javascript"></script>
<div class="bce-content-layout">
    <div class="bce-content-layout-row">
    <div class="bce-layout-cell" align="right">
        <p style="text-align:right">
            <a id="go" rel="leanModal" name="test" href="#test">Desarrollado Por DINFO - Bazar Central Del Ejercito del Perú</a> 
       </p>
    </div>
    </div>
</div>

  </div>
</footer>

</div>

<div id="test">

<p>ÁREA DE DESARROLLO DE SISTEMAS<br />
  EQUIPO DE TRABAJO:<br />
  &nbsp;  &nbsp;  &nbsp;Sr. Aliaga Colquechagua,  Bryan (Programador Web Page)<br />
  &nbsp;  &nbsp;  &nbsp;Sr. Cabanillas Humeres, Fredy  (Administrador  Data base)<br />
  &nbsp;  &nbsp;  &nbsp;Sr. Espinoza Luna, Alex (Administrador  Web Server)<br />
  &nbsp;  &nbsp;  &nbsp;Sr. Huamán  Jhong, Alejandro (Desarrollador System  Web)<br />
  COORDINADORES<br />
  &nbsp;  &nbsp;  &nbsp;Sr. Fernando  de la Torre (Jefe de Publicidad)<br />
  &nbsp;  &nbsp;  &nbsp;Sr.  Israel  Caldas (Arte y Diseño)<br />
 JEFE DE DEPARTAMENTO DE INFORMÁTICA<br />
  &nbsp;  &nbsp;  &nbsp;Sr. TCO 2 Raúl Delgado Vargas</p>

</div>

<div id="signup">
			<div id="signup-ct">
				<div id="signup-header">
					<h2>Create a new account</h2>
					<p>It's simple, and free.</p>
					<a class="modal_close" href="#"></a>
				</div>
				
				<form action="">
     
				  <div class="txt-fld">
				    <label>Username</label>
				    <input  class="good_input" name="" type="text" />

				  </div>
				  <div class="txt-fld">
				    <label >Email address</label>
				    <input name="" type="text" />
				  </div>
				  <div class="txt-fld">
				    <label >Password</label>
				    <input   type="text" />

				  </div>
				  <div class="btn-fld">
				  <button type="submit">Sign Up &raquo;</button>
</div>
				 </form>
			</div>
		</div>

</body></html>
