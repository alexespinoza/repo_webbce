package Model.dao;
import Conexion.ConexionMysql;
import Dao.P_Noticia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class ListarNoticias {
    private static Connection cn;
     private static      PreparedStatement ps;
     private static     ResultSet rs;
    public static LinkedList<P_Noticia> getNoticia(String valor) throws Exception
    {

        ConexionMysql con=new ConexionMysql();
                          LinkedList<P_Noticia> lista=new LinkedList<P_Noticia>();
   try {
       con.Conectar();
        cn =   con.getCn();
 String descripcion;
 if(valor=="1"){
     descripcion = "concat(left(descripcion,150), '...') descripcion";
 }else{
     descripcion= "descripcion";
 }
            cn.setAutoCommit(false);
ps = cn.prepareStatement("SELECT idnoticias,titulo,nombre, "+descripcion+" FROM noticias ORDER BY idnoticias DESC");
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
       con.Cerrar();
   }
        return lista;
    }
        
}
