package Model.dao;

import Conexion.ConexionMysql;
import Dao.P_Imagenes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class ListarImg {
    private static Connection cn;
    private static     PreparedStatement ps;
    private static     ResultSet rs;
    public static LinkedList<P_Imagenes> getImg() throws Exception {
            ConexionMysql con = new ConexionMysql();
        
        LinkedList<P_Imagenes> lista = new LinkedList<P_Imagenes>();
        try {
            con.Conectar();
cn = con.getCn();
            cn.setAutoCommit(false);

            ps = cn.prepareStatement("{call Sp_Imagenes('TIENDA')}");
            rs = ps.executeQuery();
            while (rs.next()) {
                P_Imagenes img = new P_Imagenes();

                img.setIdimagenes(rs.getInt("idimagenes"));
                img.setTitulo(rs.getString("titulo"));
                img.setSubtitulo(rs.getString("subtitulo"));
                img.setImg1(rs.getString("img1"));
                img.setImg(rs.getString("img"));
                img.setUrl(rs.getString("url"));

                lista.add(img);
            }
            rs.close();
            ps.close();
                 } catch (Exception e) {
            e.printStackTrace();
        }finally{
            con.Cerrar();
        }
        return lista;
    }

    public static LinkedList<P_Imagenes> getImgActividades(int id) throws Exception {
      
        ConexionMysql con = new ConexionMysql();
                LinkedList<P_Imagenes> lista = new LinkedList<P_Imagenes>();
        try {
   con.Conectar();
cn = con.getCn();
            cn.setAutoCommit(false);
            ps = cn.prepareStatement("SELECT idimagenes,imagenes.img,actividades.nombre titulo FROM imagenes "
                    + "INNER JOIN actividades ON actividades.idactividades = imagenes.idactividades "
                    + "WHERE imagenes.idactividades = " + id);
            rs = ps.executeQuery();
            while (rs.next()) {
                P_Imagenes img = new P_Imagenes();
                img.setIdimagenes(rs.getInt("idimagenes"));
                img.setTitulo(rs.getString("titulo"));
                img.setImg(rs.getString("img"));
                lista.add(img);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            con.Cerrar();
        }
        return lista;
    }

    public static LinkedList<P_Imagenes> getImgNoticias(int id) throws Exception {
   
        ConexionMysql con = new ConexionMysql();
              LinkedList<P_Imagenes> lista = new LinkedList<P_Imagenes>();
        try {
   con.Conectar();
cn = con.getCn();
            cn.setAutoCommit(false);
            ps = cn.prepareStatement("SELECT idimagenes,imagenes.img,noticias.nombre titulo FROM imagenes "
                    + "INNER JOIN noticias ON noticias.idnoticias = imagenes.idnoticias "
                    + "WHERE imagenes.idnoticias = " + id);
            rs = ps.executeQuery();
            while (rs.next()) {
                P_Imagenes img = new P_Imagenes();
                img.setIdimagenes(rs.getInt("idimagenes"));
                img.setTitulo(rs.getString("titulo"));
                img.setImg(rs.getString("img"));
                lista.add(img);
            }
            rs.close();
            ps.close();
         } catch (Exception e) {
            e.printStackTrace();
        }finally{
            con.Cerrar();
        }
        return lista;
    }
}
