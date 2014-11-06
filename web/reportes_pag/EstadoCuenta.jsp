<%@page import="java.sql.Connection"%>
<%@page import="Conexion.ConexionSql"%>
<title> Bazar Central del Ejercito del Perú</title>
<link rel="shortcut icon" href="images/BCEIco.ico"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="net.sf.jasperreports.engine.*" %> 
<%@ page import="java.util.*" %> 
<%@ page import="java.io.*" %> 
<% 
 if( session.getAttribute("CodAnexo") != null){
     Connection cn;
ConexionSql con=new ConexionSql();
cn=con.getConexion();
File reportFile = new File(application.getRealPath("reportes/EstadoCuentaCliente.jasper")); 
 
Map parameters = new HashMap(); 
parameters.put("CodAnexo", session.getAttribute("CodAnexo")); 
byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath (), parameters, cn); 
/*Indicamos que la respuesta va a ser en formato PDF*/ 
response.setContentType("application/pdf");
response.setContentLength(bytes.length); 
ServletOutputStream ouputStream = response.getOutputStream(); 
ouputStream.write(bytes, 0, bytes.length); 
/*Limpiamos y cerramos flujos de salida*/ 
ouputStream.flush(); 
ouputStream.close();
con.cerrarConexion(cn);
}else{
     	response.sendRedirect("?content=inicio");
 }
%>
