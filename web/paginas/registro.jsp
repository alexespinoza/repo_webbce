<%@page import="java.util.List"%>
<%@page import="Dao.AnexoWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
	<script src="js/jquery.js"></script>
	<script src="js/jquery.validate.js"></script>

	<script>
            
	$().ready(function() {
		// validate the comment form when it is submitted
		$("#commentForm").validate();

		// validate signup form on keyup and submit
		$("#bce-form").validate({
			rules: {
				TxtApelidos: "required",
				TxtNombres: "required",
				TxtDni: {
					required: true,
					minlength: 8
				},
                                TxtDireción:"required",
                                TxtCelular:"required",
                                TxtEmail: {
					required: true,
					email: true
				},
				TxtContraseña1: {
					required: true,
					minlength: 5
				},
				TxtContraseña2: {
					required: true,
					minlength: 5,
					equalTo: "#TxtContraseña1"
				},
                                DdlPregunta:"required",
                                TxtPalabraclave:"required"
	
			},
			messages: {
				TxtApelidos: "Por favor ingrese sus apellidos",
				TxtNombres: "Por favor ingrese sus nombres",
				TxtDni: {
					required: "Por favor ingrese su número DNI",
					minlength: "Número DNI incorrecto"
				},
                                TxtDireción: "Por favor ingrese su dirección",
                                TxtCelular:"Por favor ingrese su númenero celular",
                                 TxtEmail:"Por favor, ingrese una dirección de correo electrónico válida",
	                           
				TxtContraseña1: {
					required: "Por favor, ingrese su contraseña",
					minlength: "Tu contraseña debe tener al menos 5 caracteres"
				},
				TxtContraseña2: {
					required: "Por favor, ingrese su contraseña",
					minlength: "Tu contraseña debe tener al menos 5 caracteres",
					equalTo: "Por favor, introduzca la misma contraseña que el anterior"
				},
                                DdlPregunta:"Selecciones una opcion",
                                TxtPalabraclave:"Ingrese la palabra clave"

			}
		});

		// propose username by combining first- and lastname
		$("#username").focus(function() {
			var firstname = $("#firstname").val();
			var lastname = $("#lastname").val();
			if (firstname && lastname && !this.value) {
				this.value = firstname + "." + lastname;
			}
		});

		//code to hide topic selection, disable for demo
		var newsletter = $("#newsletter");
		// newsletter topics are optional, hide at first
		var inital = newsletter.is(":checked");
		var topics = $("#newsletter_topics")[inital ? "removeClass" : "addClass"]("gray");
		var topicInputs = topics.find("input").attr("disabled", !inital);
		// show when newsletter is checked
		newsletter.click(function() {
			topics[this.checked ? "removeClass" : "addClass"]("gray");
			topicInputs.attr("disabled", !this.checked);
		});
	});
	</script>
 
<article class="bce-regis">

<%
String mensaje ="";
if(session.getAttribute("lstaAnexo") != null){
List<AnexoWeb> lstClientes = (List<AnexoWeb>)session.
getAttribute("lstaAnexo");
AnexoWeb   anexo = lstClientes.get(0) ;

if( "EXISTE".equals(anexo.getCodAnexo())){
mensaje="El Nro. Administrativo ya esta registrado";
HttpSession sesion = request.getSession();
sesion.setMaxInactiveInterval(2);
%>
<form  name="Vcod" id="Vcod" method="post" action="AnexoWeb?a=buscar" >
<br clear="all">
<fieldset>
<legend>Identifiquese </legend>

<div class="bce-postmetadataheader">
<h5>Para poder registrarse Ud. debe  ingresar su número administrativo.</h5>
</div>

<p>
<label for="TxtAdmin">Ingrese su Número Administrativo</label>
<input type="text" name="TxtAdmin"  id="TxtAdmin"  autocomplete="off" title="Ingrese su Nro. Administrativo" MaxLength="9"   onkeypress="numero()" required>
</p>
<p>
<label for="TxtDoc">Ingrese su Número DNI</label>
<input type="text" name="TxtDoc"  id="TxtDoc" autocomplete="off" title="Ingrese su Nro. DNI" MaxLength="8"   onkeypress="numero()" required>
</p>
<br clear="all">
<p>
<input type="submit" value="Buscar" class="bce-button"  id="btnBuscar" />
&nbsp;  <input type="button" class="bce-button" value="Cancelar" onclick="cancelar()" >

</p>
<p>

</p>
</fieldset>
</form>
<%
if(mensaje!=null){%>
    <p class="bce_error">  <%=mensaje%> </p>
<%}
}else{
HttpSession sesion = request.getSession();
sesion.setMaxInactiveInterval(300);
%>

<form class="cmxform" name="bce-form" id="bce-form" action="AnexoWeb?a=insertar" method="post"  >
<br clear="all">
<fieldset>
<legend>Registro </legend>
<p>
<Label for="TxtCodAnexo">Nro. Administrativo</Label>
<input type="text" name="TxtCodAnexo" ID="TxtCodAnexo"  value="<%=anexo.getCodAnexo()%>" readonly>
</p>

<p>
<Label for="TxtApelidos">Apellidos:</Label>
<input type="text"  name="TxtApelidos" ID="TxtApelidos"  value="<%=anexo.getApellidos()%>" autocomplete="off" Title="Escribe su apellido paterno y materno" >
</p>

<p>
<Label for="TxtNombres"  >Nombres:</Label>
<input type="text"  name="TxtNombres" ID="TxtNombres"  value="<%=anexo.getNombres()%>" autocomplete="off"  title="Escriba su nombre completo" >
</p>

<p>
<Label for="TxtDni" >DNI:</Label>
<input type="text" name="TxtDni" ID="TxtDni" value="<%=anexo.getDocumento()%>" autocomplete="off" MaxLength="8" onkeypress="ValidaSoloNumeros()" Title="Escriba su DNI  (8 digitos)" >
</p>

<p>
<Label for="TxtDireción">Direccion:</Label>
<input type="text" name="TxtDireción" ID="TxtDireción" value="<%=anexo.getDireccion()%>" autocomplete="off" title="Escriba su dirección(Ej: Av Boulevard S/N -San Borja)" >
</p>

<p>
<Label ID="TxtTelefono">Fijo:</Label>
<input type="text" name="TxtTelefono" ID="TxtTelefono" value="<%=anexo.getTelefono()%>"  autocomplete="off" MaxLength="12"  title="(Ej: 01 3171700)" >
</p>

<p>
<Label for="TxtCelular">Movil:</Label>
<input type="text" name="TxtCelular"  ID="TxtCelular"  value="<%=anexo.getCelular()%>" autocomplete="off" MaxLength="9" title="Escriba su N°  Cel. (9 digitos)" >
</p>

<p>
<Label for="TxppmRpc" >RPM/RPC:</Label>
<input type="text" name="TxppmRpc" ID="TxppmRpc"  autocomplete="off" MaxLength="24" title="Opcional">
</p>

<p>
<Label for="TxtEmail" > E-Mail:</Label>
<input type="text" name="TxtEmail" ID="TxtEmail" value="<%=anexo.getEmail()%>" autocomplete="off"  title="(Ej: sistemas@bcetubzar.com)" >
</p>
<p>
<Label for="TxtContraseña1">Contraseña</Label>
<input type="Password" name="TxtContraseña1" ID="TxtContraseña1"   MaxLength="10" title="La Contraseña debe constar 5-12 caracteres, (a-9), (aA-zZ)" >
</p>

<p>
<Label for="TxtContraseña2" >Repita la Contraseña</Label>
<input type="Password" name="TxtContraseña2" ID="TxtContraseña2"   MaxLength="10" title="Repita la Contraseña" >
</p>
<p>
<Label for="DdlPregunta" >Pregunta de seguridad </Label><br>
<select name="DdlPregunta"  ID="DdlPregunta"  title="Seleccione una pregunta" >
<OPTION></OPTION>
<OPTION value="Lugar de Nacimiento">Lugar de Nacimiento</OPTION>
<OPTION value="Mejor amigo">Mejor amigo</OPTION>
<OPTION value="Ocuoación del abuelo">Ocuoación del abuelo</OPTION>
<OPTION value="Nombre de mascota">Nombre de mascota</OPTION>
</select>
</p>

<p>
<Label for="TxtPalabraclave"  >Ingrese Palabra Clave </Label>
<input type="text" name="TxtPalabraclave"  ID="TxtPalabraclave"  autocomplete="off"  title="Escriba la palabra clave" >
</p>
<!--
<p>
<label for="chkacep">
<input type="checkbox" id="chkacep" name="chkacep" />Aceptar las condiciones</label>
</p>-->
<br clear="all">
<p>
<input type="submit"  class="bce-button" name="BtnEnviar" ID="BtnEnviar" title="Revise Sus Datos Antes de Regisparse, su datos (usuario,Contraseña) se le enviara a su Correo Regispado" value="Enviar Datos">
<button  class="bce-button" onclick="cancelar()" > Cancelar</button>

</p>
</fieldset>

</form>
<%
}
}else{
HttpSession sesion = request.getSession();
sesion.setMaxInactiveInterval(15);
%>
<form  name="Vcod" id="Vcod" method="post" action="AnexoWeb?a=buscar" >
<br clear="all">
<fieldset>
<legend>Identifiquese </legend>

<div class="bce-postmetadataheader">
<h5>Para poder registrarse Ud. debe  ingresar su número administrativo.</h5>
</div>

<p>
<label for="TxtAdmin">Ingrese su Número Administrativo</label>
<input type="text" name="TxtAdmin"  id="TxtAdmin" autocomplete="off" title="Ingrese su Nro. Administrativo" MaxLength="9"   onkeypress="numero()" required>
</p>
<p>
<label for="TxtDoc">Ingrese su Número DNI</label>
<input type="text" name="TxtDoc"  id="TxtDoc" autocomplete="off" title="Ingrese su Nro. DNI" MaxLength="8"   onkeypress="numero()" required>
</p>
<br clear="all">
<p>
<input type="submit" value="Buscar" class="bce-button"  id="btnBuscar" />
&nbsp;  <input type="button" class="bce-button" value="Cancelar" onclick="cancelar()" >

</p>
<p>
</p>

</fieldset>

</form>
<%
if( session.getAttribute("sucess") !=null && session.getAttribute("sucess") !="0" && session.getAttribute("sucess") !="1")
{%>
<p class="bce_error">    ${sucess}   </p>
<%
}
}
//validacion
if( session.getAttribute("sucess") == "0" && session.getAttribute("mensaje") !=null)
{%>
<p class="bce_error">    ${mensaje}   </p>
<%
}
%>



</article>

</body>
</html>

