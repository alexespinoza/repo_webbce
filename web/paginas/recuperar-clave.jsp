<%@page import="java.util.List"%>
<%@page import="Dao.AnexoWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
	<script src="js/jquery.js"></script>
	<script src="js/jquery.validate.js"></script>
     <script type="text/javascript" src="js/jquery.form.js"></script>
	
        <script>
	$().ready(function() {
		// validate the comment form when it is submitted
		$("#commentForm").validate();

		// validate signup form on keyup and submit
		$("#frmRestablecerPass").validate({
			rules: {
                                TxtCod: {
					required: true,
					minlength: 9
				},
				TxtDoc: {
					required: true,
					minlength: 8
				},
                                Txtpass1: {
					required: true,
					minlength: 5
				},
				Txtpass2: {
					required: true,
					minlength: 5,
					equalTo: "#Txtpass1"
				},
                                DdlPregunta:"required",
                                TxtPalabraclave:"required"
	
			},
			messages: {
                        TxtCod: {
				required: "Por favor ingrese su número Administrativo",
				minlength: "Número Administrativo incorrecto"
				},
				TxtDoc: {
					required: "Por favor ingrese su número DNI",
					minlength: "Número DNI incorrecto"
				},
				Txtpass1: {
					required: "Por favor, ingrese nueva contraseña",
					minlength: "Tu contraseña debe tener al menos 5 caracteres"
				},
				Txtpass2: {
					required: "Por favor, ingrese su contraseña",
					minlength: "Tu contraseña debe tener al menos 5 caracteres",
					equalTo: "Por favor, introduzca la misma contraseña que el anterior"
				},
                                DdlPregunta:"Selecciones una opcion",
                                TxtPalabraclave:"Ingrese la palabra clave "

			}
		});

	});
	</script>
        
              
<article class="bce-regis">
<!-- AnexoWeb?a=buscar -->    
<form  name="frmRestablecerPass" id="frmRestablecerPass" method="post" action="AnexoWeb?a=pass" >
<br clear="all">
<fieldset>
<legend>Restablecer la contraseña </legend>
<p>
<label for="TxtCod">Ingrese su Número Administrativo</label>
<input type="text" name="TxtCod"  id="TxtCod"  autocomplete="off"  MaxLength="9"   onkeypress="numero()" >
</p>
<p>
<label for="TxtDoc">Ingrese su Número DNI</label>
<input type="text" name="TxtDoc"  id="TxtDoc" autocomplete="off" MaxLength="8"   onkeypress="numero()" >
</p>
 <p>
<Label for="DdlPregunta" >Seleccione Pregunta de seguridad </Label><br>
<select name="DdlPregunta"  ID="DdlPregunta"  title="Seleccione una pregunta" >
<OPTION></OPTION>
<OPTION value="Lugar de Nacimiento">Lugar de Nacimiento</OPTION>
<OPTION value="Mejor amigo">Mejor amigo</OPTION>
<OPTION value="Ocuoación del abuelo">Ocuoación del abuelo</OPTION>
<OPTION value="Nombre de mascota">Nombre de mascota</OPTION>
</select>
</p>
<p>
<label for="TxtPalabraclave">Palabra clave  </label>
<input type="text" name="TxtPalabraclave"  id="TxtPalabraclave" autocomplete="off"  >
</p>
 <p>
<label for="Txtpass1">Nueva Contraseña</label>
<input type="Password" name="Txtpass1"  id="Txtpass1" autocomplete="off"  >
</p>
<p>
<label for="Txtpass2">Repita la Contraseña</label>
<input type="Password" name="Txtpass2"  id="Txtpass2" autocomplete="off" >
</p>
<br clear="all">
<p>
<input type="submit" value="Cambiar Contraseña" class="bce-button"  id="btnBuscar" />
&nbsp;  <input type="button" class="bce-button" value="Cancelar" onclick="cancelar()" >

</p>

</fieldset>
</form>
<%
    HttpSession sesion = request.getSession();
sesion.setMaxInactiveInterval(5);
if( session.getAttribute("sucess") == "1")
{%>
  <p class="bce-success">    ${msgPostOperacion}   </p>
<%   
}else if (session.getAttribute("sucess") == "0")    {%>
     <!--<script>window.location="/webbce/?p=registro-detalle";</script>-->
     <p class="bce_error"> ${msgPostOperacion}   </p>

<%}
%>
 </article>
</body>
</html>

