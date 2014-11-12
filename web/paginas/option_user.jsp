<ul>
<li> <a href="javascript:;"  onclick="javascript:window.open('reportes_pag/EstadoCuenta.jsp', '_blank', 'toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=800, height=650')">Ver Estado Cuenta</a></li>
<li> <a href="AnexoWeb?a=listar&id=<%=session.getAttribute("CodAnexo")%>" >Modificar Mis Datos</a></li>
<li> <a href="reportes_pag/EstadoCuentaCliente?id=<%=session.getAttribute("CodAnexo")%>" target="_blank" >EstadoCuentaCliente</a></li>
</ul>