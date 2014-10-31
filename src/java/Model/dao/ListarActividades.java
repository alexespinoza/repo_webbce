package Model.dao;
import Conexion.ConexionMysql;
import Dao.P_Actividades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class ListarActividades {
    public static LinkedList<P_Actividades> getActividades(String valor)
    {
Connection cn;
      PreparedStatement ps;
     ResultSet rs;
        ConexionMysql conexion=new ConexionMysql();
            cn =   conexion.getconexion();
               LinkedList<P_Actividades> lista=new LinkedList<P_Actividades>();
   try {
 String descripcion;
 if(valor=="0"){
     descripcion = "concat(left(descripcion,150), '...') descripcion";
 }else{
     descripcion= "descripcion";
 }
            cn.setAutoCommit(false);
ps = cn.prepareStatement("SELECT idactividades,titulo,nombre, "+descripcion+" FROM actividades");
               rs = ps.executeQuery();
    while (rs.next()) {
              P_Actividades activiades = new P_Actividades();
               activiades.setIdactividades(rs.getInt("idactividades"));
                activiades.setTitulo(rs.getString("titulo"));
                activiades.setNombre(rs.getString("nombre"));
                activiades.setDescripcion(rs.getString("descripcion"));
                lista.add(activiades);
}
          rs.close();
         ps.close();
         cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return lista;
    }
        
}
