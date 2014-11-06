package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
public class ConexionSql {
    private static Logger logger = Logger.getLogger(ConexionSql.class.getName());
    private Connection con;
    private String url;
    private String usuario;
    private String contrasena;
    public ConexionSql(){
        logger.info("iniciando Conexion");
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(ClassNotFoundException e){
            logger.error("Error no se puede cargar el driver..." + 
                    e.getMessage());
        }
        try{
            url="jdbc:sqlserver://192.168.2.10;databaseName=BCEData";
            usuario="sa";
            contrasena="";
            con=DriverManager.getConnection(url,usuario,contrasena);
        }catch(SQLException e){
            logger.error("Error al establecer la conexion:" + e.getMessage());
        }
    }

    public Connection getConexion(){
        logger.info("getConexion");
        return con;
    }
    
    public void cerrarConexion(Connection con){
        logger.info("cerrarConexion");
        try{
            con.close();
        }catch(SQLException e){
            logger.error("Error al cerrar la conexion:" + e.getMessage());
        }
    }
}
