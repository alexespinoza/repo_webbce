package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSqlsvr {

    static Connection conn;

    public static Connection getConnection() {
        try {

            String url = "jdbc:sqlserver://192.168.2.16;databaseName=BCEdata";
            String uname = "sa";
            String pwd = "";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try {
                conn = DriverManager.getConnection(url, uname, pwd);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return conn;
    }

}
