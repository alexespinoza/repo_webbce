package Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionMysql {
    /*
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
    }*/
     private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

      
 public void Conectar() throws Exception{
       String url = "jdbc:mysql://192.168.2.18:3307/webbce";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, "webbce", "dinfo4rd");
        } catch (Exception ex) {
            throw ex;
        }
       
    }
    
    public  void  Cerrar() throws Exception{
        try{
             if(cn != null){
            if(cn.isClosed()==false){
                cn.close();
            }
        }
        }catch(Exception e){
            throw e;
        }
       
    }
    
   
}
