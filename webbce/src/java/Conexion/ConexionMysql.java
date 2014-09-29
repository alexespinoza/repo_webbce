package Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionMysql {
    String url="jdbc:mysql://192.168.2.16:3306/webbce";
    
    public Connection getconexion(){
        Connection cn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection(url,"webbce","C7A4I7A1M0.f4");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return cn;
    }
    
   
}
