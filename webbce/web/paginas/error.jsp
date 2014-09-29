<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    
    <body onload="limpiar()">
    <script type="text/javascript">
    function limpiar(){
      history.go(1);
          setTimeout("history.back()", 2000);
  } 
</script>
       <img src="http://i.imgur.com/RbCnfzp.jpg"> 
    </body>
</html>

