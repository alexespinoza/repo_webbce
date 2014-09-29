<%@page import="otros.ruta"%>
<%@page import="Model.dao.ListarPromociones"%>
<%@page import="Dao.P_Promociones"%>
<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
<title>Auto Refresh Header Example</title>
</head>
<body>
<center>

<%
   /* Set refresh, autoload time as 5 seconds
   response.setIntHeader("Refresh", 100);
    Get current time
   Calendar calendar = new GregorianCalendar();
   String am_pm;
   int hour = calendar.get(Calendar.HOUR);
   int minute = calendar.get(Calendar.MINUTE);
   int second = calendar.get(Calendar.SECOND);
   if(calendar.get(Calendar.AM_PM) == 0)
      am_pm = "AM";
   else
      am_pm = "PM";
   String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
   out.println("Crrent Time: " + CT + "\n");
           */
File f = new File("mail.jsp"); // Creamos un objeto file
                 out.println(f.getAbsolutePath()); 
                 
                 String r = "mail.jsp";
                 char[]n = r.toCharArray();
    char[]a=null;
    String retorno="";
    int i=0;
    int k=0;
    for(i=(r.length()-1);i==0;i--){
        
        while(n[i]!='\\'){
                a[k]=n[i];
                k++;
                
        }
        }
    try{
    String temp= a.toString();
    StringBuffer sb = new StringBuffer(temp);
    sb = sb.reverse();
    retorno=sb.toString();
        
    }catch(NullPointerException e){//Hacer nada}

}
  out.println(retorno + "jkdfgkdfghjk");
%>





</center>
</body>
</html>