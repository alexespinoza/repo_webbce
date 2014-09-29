

package Model.dao;

import Conexion.ConexionMysql;
import Dao.P_Promociones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class ListarPromociones {
  public static LinkedList<P_Promociones> getPromoOfer(Integer IdOpt, Integer IdPro)
    {
    Connection cn;
      PreparedStatement ps;
     ResultSet rs;
        ConexionMysql conexion=new ConexionMysql();
            cn =   conexion.getconexion();
               LinkedList<P_Promociones> lista=new LinkedList<P_Promociones>();
   try {
 
            cn.setAutoCommit(false);

            ps = cn.prepareStatement("{call Sp_PromoOferta(?,?)}");
             ps.setInt(1, IdOpt);
               ps.setInt(2, IdPro);
               rs = ps.executeQuery();
    while (rs.next()) {
              P_Promociones proOfer = new P_Promociones();
                           
                proOfer.setIdpromo_oferta(rs.getInt("idpromo_oferta"));
                proOfer.setTitulo(rs.getString("titulo"));
                proOfer.setNombre(rs.getString("nombre"));
                proOfer.setSubtitulo(rs.getString("subtitulo"));
                proOfer.setImg(rs.getString("img"));
                proOfer.setUrl(rs.getString("url"));
                proOfer.setDescripcion(rs.getString("descripcion"));
                               
                    lista.add(proOfer);
            }
          rs.close();
         ps.close();
         cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return lista;
    } 
  
    public static LinkedList<P_Promociones> getPromoOferInicio()
    {
    Connection cn;
      PreparedStatement ps;
     ResultSet rs;
        ConexionMysql conexion=new ConexionMysql();
            cn =   conexion.getconexion();
               LinkedList<P_Promociones> lista=new LinkedList<P_Promociones>();
   try {
 
            cn.setAutoCommit(false);

            ps = cn.prepareStatement("{call Sp_OpcionesInicio()}");
               rs = ps.executeQuery();
    while (rs.next()) {
              P_Promociones proOfer = new P_Promociones();
                           
                proOfer.setIdpromo_oferta(rs.getInt("idpromo_oferta"));
                proOfer.setTitulo(rs.getString("titulo"));
                proOfer.setNombre(rs.getString("nombre"));
                proOfer.setSubtitulo(rs.getString("subtitulo"));
                proOfer.setImg(rs.getString("img"));
                proOfer.setUrl(rs.getString("url"));
                proOfer.setDescripcion(rs.getString("descripcion"));
                               
                    lista.add(proOfer);
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
