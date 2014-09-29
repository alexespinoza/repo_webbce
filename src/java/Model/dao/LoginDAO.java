package Model.dao;

import Conexion.ConnectionSqlsvr;
import Dao.LoginBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO
{
static Connection currentCon = null;
static ResultSet rs = null;
public static LoginBean login(LoginBean bean)
{
Statement stmt = null;
String codanexo = bean.getCodAnexo();
String password = bean.getPassword();
String dni = bean.getDni();

String searchQuery = "SELECT AW.CodAnexo, AW.CodAnexo Usuario, AW.Apellidos +' ' + AW.Nombres as NomAnexo From AnexoWeb AW INNER JOIN Anexo A " +
" ON AW.CodAnexo = A.CodAnexo WHERE AW.CodAnexo='" + codanexo + "' AND PwdCompare('" +password +"',Contraseña)=1 AND A.Documento='"+dni+"'";
try
{
currentCon = ConnectionSqlsvr.getConnection();
stmt=currentCon.createStatement();
rs = stmt.executeQuery(searchQuery);
boolean userExists = rs.next();

if (!userExists)
{
bean.setValid(false);
bean.setMs("Datos Incorrectos...");
}
else if (userExists)
{
String CodAnexo = rs.getString("CodAnexo");
String NomAnexo = rs.getString("NomAnexo");


bean.setCodAnexo(CodAnexo);
bean.setNomAnexo(NomAnexo);
bean.setValid(true);
bean.setMs("Bievenido " +  NomAnexo);
}

}
catch (Exception ex)
{
bean.setMs("Nose puede Iniciar Session! " + ex);
}
return bean;
}
}