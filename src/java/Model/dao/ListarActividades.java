package Model.dao;
import Conexion.ConexionMysql;
import Dao.P_Actividad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class ListarActividades {
         private static Connection cn;
          private  static PreparedStatement ps;
          private  static ResultSet rs;
          
     public static LinkedList<P_Actividad> getActividades(String valor) throws Exception
    {

        ConexionMysql con=new ConexionMysql();
               LinkedList<P_Actividad> lista=new LinkedList<P_Actividad>();
   try {
       con.Conectar();
       cn=con.getCn();
 String descripcion;
 if(valor=="1"){
     descripcion = "concat(left(descripcion,150), '...') descripcion";
 }else{
     descripcion= "descripcion";
 }
            cn.setAutoCommit(false);
ps = cn.prepareStatement("SELECT idactividades,titulo,nombre, "+descripcion+", url FROM actividades ORDER BY idactividades DESC");
               rs = ps.executeQuery();
    while (rs.next()) {
              P_Actividad activiades = new P_Actividad();
               activiades.setIdactividades(rs.getInt("idactividades"));
                activiades.setTitulo(rs.getString("titulo"));
                activiades.setNombre(rs.getString("nombre"));
                activiades.setDescripcion(rs.getString("descripcion"));
                 activiades.setUrl(rs.getString("url"));
                lista.add(activiades);
}
          rs.close();
         ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
       con.Cerrar();
   }
        return lista;
    }
        
}
