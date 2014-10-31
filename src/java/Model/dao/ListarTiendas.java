
package Model.dao;

import Conexion.ConexionMysql;
import Dao.P_tiendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;


public class ListarTiendas {
    public static LinkedList<P_tiendas> getTiendas()
    {

    
     Connection cn;
      PreparedStatement ps;
     ResultSet rs;
        ConexionMysql conexion=new ConexionMysql();
            cn =   conexion.getconexion();
               LinkedList<P_tiendas> lista=new LinkedList<P_tiendas>();
   try {
 
            cn.setAutoCommit(false);

            ps = cn.prepareStatement("{call Sp_Tiendas()}");
               rs = ps.executeQuery();
    while (rs.next()) {
              P_tiendas tiendas = new P_tiendas();
                               
                tiendas.setIdtiendas(rs.getInt("idtiendas"));
                tiendas.setNombre(rs.getString("nombre"));
                tiendas.setDireccion(rs.getString("direccion"));
                tiendas.setCorreo(rs.getString("correo"));
                tiendas.setUrl(rs.getString("url"));
                tiendas.setDescripcion(rs.getString("descripcion"));
                tiendas.setMapa(rs.getString("mapa"));
                tiendas.setImg1(rs.getString("img1"));
                tiendas.setImg2(rs.getString("img2"));
                tiendas.setTelefono(rs.getString("telefono"));
                tiendas.setRpm(rs.getString("rpm"));
                    lista.add(tiendas);
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
    
