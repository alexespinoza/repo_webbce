package Model.dao;
import Conexion.ConexionMysql;
import Dao.P_Noticia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class ListarNoticias {
    public static LinkedList<P_Noticia> getNoticia(String valor)
    {
Connection cn;
      PreparedStatement ps;
     ResultSet rs;
        ConexionMysql conexion=new ConexionMysql();
            cn =   conexion.getconexion();
               LinkedList<P_Noticia> lista=new LinkedList<P_Noticia>();
   try {
 String descripcion;
 if(valor=="1"){
     descripcion = "concat(left(descripcion,150), '...') descripcion";
 }else{
     descripcion= "descripcion";
 }
            cn.setAutoCommit(false);
ps = cn.prepareStatement("SELECT idnoticias,titulo,nombre, "+descripcion+" FROM noticias");
               rs = ps.executeQuery();
    while (rs.next()) {
              P_Noticia noticia = new P_Noticia();
               noticia.setIdnoticias(rs.getInt("idnoticias"));
                noticia.setTitulo(rs.getString("titulo"));
                noticia.setNombre(rs.getString("nombre"));
                noticia.setDescripcion(rs.getString("descripcion"));
                lista.add(noticia);
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
