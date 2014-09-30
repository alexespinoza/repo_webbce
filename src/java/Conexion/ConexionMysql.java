package Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionMysql {
    String url="jdbc:mysql://192.168.2.18:3307/webbce";
    
    public Connection getconexion(){
        Connection cn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection(url,"webbce","dinfo4rd");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return cn;
    }
    
   
}
