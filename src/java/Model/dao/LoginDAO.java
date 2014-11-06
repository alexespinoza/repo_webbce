package Model.dao;

import Conexion.ConexionSql;
import Dao.LoginBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;

public class LoginDAO {

    private static Logger logger = Logger.getLogger(LoginDAO.class.getName());
    static ResultSet rs = null;
    static ConexionSql con;
    static Connection cn;

    public static LoginBean logeo(LoginBean user) throws Exception {
        PreparedStatement stmt = null;
        String sql = "{CALL Sp_AnexoWebLogeo(?,?,?)}";
        try {
            con = new ConexionSql();
            cn = con.getConexion();
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, user.getCodAnexo());
            stmt.setString(2, user.getDni());
            stmt.setString(3, user.getPassword());
            rs = stmt.executeQuery();
            boolean userExists = rs.next();
            if (!userExists) {
                user.setValid(false);
                user.setMs("Datos Incorrectos...");
            } else if (userExists) {
                user.setCodAnexo(rs.getString("CodAnexo"));
                user.setNomAnexo(rs.getString("NomAnexo"));
                user.setValid(true);
                user.setMs("Bievenido " + rs.getString("NomAnexo"));
            }
        } catch (Exception e) {

        } finally {
            con.cerrarConexion(cn);
        }
        return user;
    }
}
