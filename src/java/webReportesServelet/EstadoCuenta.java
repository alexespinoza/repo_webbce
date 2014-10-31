package webReportesServelet;

import Conexion.ConexionSql;
import Model.dao.Impl.AnexoWebDaoImp;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class EstadoCuenta {
     private static Logger logger = Logger.getLogger(AnexoWebDaoImp.class.
            getName());
     ConexionSql cn;
     Statement instucion;
     
public  EstadoCuenta(){

    try {
            cn.getConexion();
            //instucion= cn.createStatement();
    } catch (Exception e) {
    }
}
    
}
