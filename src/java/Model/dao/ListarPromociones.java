package Model.dao;

import Conexion.ConexionMysql;
import Dao.P_Promociones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class ListarPromociones {
private static Connection cn;
      private static   PreparedStatement ps;
     private static    ResultSet rs;
    public static LinkedList<P_Promociones> getPromoOfer() throws Exception {
        
        ConexionMysql con = new ConexionMysql();
                LinkedList<P_Promociones> lista = new LinkedList<P_Promociones>();
        try {
            con.Conectar();
            cn = con.getCn();
            cn.setAutoCommit(false);
            ps = cn.prepareStatement("{call Sp_PromoOferta(0)}");
           rs = ps.executeQuery();
            while (rs.next()) {
                P_Promociones proOfer = new P_Promociones();
                proOfer.setIdpromo_oferta(rs.getInt("idpromo_oferta"));
                proOfer.setTitulo(rs.getString("titulo"));
                proOfer.setNombre(rs.getString("nombre"));
                proOfer.setValido(rs.getString("valido"));
                proOfer.setDescripcion(rs.getString("descripcion"));
                proOfer.setUrl(rs.getString("url"));
                lista.add(proOfer);
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

    public static LinkedList<P_Promociones> getPromoOferInicio() throws Exception {
        ConexionMysql con = new ConexionMysql();
        cn = con.getCn();
        LinkedList<P_Promociones> lista = new LinkedList<P_Promociones>();
        try {
con.Conectar();
cn=con.getCn();
            cn.setAutoCommit(false);

            ps = cn.prepareStatement("{call Sp_PromoOferta(1)}");
            rs = ps.executeQuery();
            while (rs.next()) {
                P_Promociones proOfer = new P_Promociones();

                proOfer.setIdpromo_oferta(rs.getInt("idpromo_oferta"));
                proOfer.setTitulo(rs.getString("titulo"));
                proOfer.setNombre(rs.getString("nombre"));
                proOfer.setValido(rs.getString("valido"));
                proOfer.setDescripcion(rs.getString("descripcion"));

                lista.add(proOfer);
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
