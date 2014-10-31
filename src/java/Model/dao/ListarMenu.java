

package Model.dao;

import Conexion.ConexionMysql;
import Dao.P_Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class ListarMenu {
    public static LinkedList<P_Menu> getMenu()
    {

    
     Connection cn;
      PreparedStatement ps;
     ResultSet rs;
        ConexionMysql conexion=new ConexionMysql();
            cn =   conexion.getconexion();
               LinkedList<P_Menu> lista=new LinkedList<P_Menu>();
   try {
 
            cn.setAutoCommit(false);

            ps = cn.prepareStatement("{call Sp_Menu()}");
               rs = ps.executeQuery();
    while (rs.next()) {
              P_Menu menu = new P_Menu();
                               
                menu.setIdmenu(rs.getInt("idmenu"));
                menu.setTitulo(rs.getString("titulo"));
                menu.setUrl(rs.getString("url"));
                menu.setDescripcion(rs.getString("descripcion"));
                menu.setEsactivo(rs.getString("esactivo"));
                menu.setOrden(rs.getString("orden"));
              
                    lista.add(menu);
            }
          rs.close();
         ps.close();
         cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return lista;
    }
    
    
    public static LinkedList<P_Menu> getMenu_submenu( int idmenu )
    {
   
     Connection cn;
      PreparedStatement ps;
     ResultSet rs;
        ConexionMysql conexion=new ConexionMysql();
            cn =   conexion.getconexion();
               LinkedList<P_Menu> lista_sub=new LinkedList<P_Menu>();
   try {
 
            cn.setAutoCommit(false);

            ps = cn.prepareStatement("{call Sp_SubMenu(?)}");
              ps.setInt(1, idmenu);
                         rs = ps.executeQuery();
    while (rs.next()) {
              P_Menu menu = new P_Menu();
                               
                menu.setIdmenu(rs.getInt("idmenu"));
                menu.setTitulo(rs.getString("titulo"));
                menu.setUrl(rs.getString("url"));
                menu.setDescripcion(rs.getString("descripcion"));
                menu.setEsactivo(rs.getString("esactivo"));
                menu.setOrden(rs.getString("orden"));
                   lista_sub.add(menu);
            }
          rs.close();
         ps.close();
         cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return lista_sub;
    }
    
}
