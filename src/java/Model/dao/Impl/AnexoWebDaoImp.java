package Model.dao.Impl;

import Conexion.ConexionSql;
import Dao.AnexoWeb;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.dao.AnexoWebDao;
import org.apache.log4j.Logger;

public class AnexoWebDaoImp implements AnexoWebDao {

    private static Logger logger = Logger.getLogger(AnexoWebDaoImp.class.
            getName());
    private ConexionSql con;
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private CallableStatement cs;
    private String sql;
    private int flgOperacion = 0;

    @Override
    public int insertar(AnexoWeb anexo) {
        logger.info("insertar");
        sql = "{CALL Sp_AnexoWebRegistrar(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
               try {
            con = new ConexionSql();
            cn = con.getConexion();
            cn.setAutoCommit(false);
            ps = cn.prepareStatement(sql);
            ps.setString(1, anexo.getCodAnexo());
            ps.setString(2, anexo.getApellidos());
            ps.setString(3, anexo.getNombres());
            ps.setString(4, anexo.getDocumento());
            ps.setString(5, anexo.getDireccion());
            ps.setString(6, anexo.getEmail());
            ps.setString(7, anexo.getTelefono());
            ps.setString(8, anexo.getRpm_rpc());
            ps.setString(9, anexo.getCelular());
            ps.setString(10, anexo.getPalabraClave());
            ps.setString(11, anexo.getCodigoSeguridad());
            ps.setString(12, anexo.getIPCliente());
            ps.setString(13, anexo.getPreguntaSeguridad());
            ps.setString(14, anexo.getContraseña());
            flgOperacion = ps.executeUpdate();
            if (flgOperacion > 0) {
                cn.commit();
            } else {
                cn.rollback();
            }

        } catch (Exception e) {
            logger.error("insertar: " + e.getMessage());
        } finally {
            con.cerrarConexion(cn);
        }
        return flgOperacion;
    }
    @Override
    public List<AnexoWeb> buscar(String CodAnexo,String Documento) {

        logger.info("buscar");
        sql = "{call Sp_AnexoWebBuscar(?,?)} ";
        List<AnexoWeb> lstAnexo = null;
        AnexoWeb anexo = null;
        try {
            con = new ConexionSql();
            cn = con.getConexion();
            cn.setAutoCommit(false);
            ps = cn.prepareStatement(sql);
            ps.setString(1, CodAnexo);
            ps.setString(2, Documento);
            rs = ps.executeQuery();
            lstAnexo = new ArrayList<AnexoWeb>();
            while (rs.next()) {
                anexo = new AnexoWeb();
                anexo.setCodAnexo(rs.getString("CodAnexo")) ;
                anexo.setApellidos(rs.getString("Apellidos"));
                anexo.setNombres(rs.getString("Nombres"));
                anexo.setDocumento(rs.getString("Documento"));
                anexo.setDireccion(rs.getString("Direccion"));
                    anexo.setCelular(rs.getString("Telefono1"));
                anexo.setTelefono(rs.getString("Telefono2"));
                anexo.setEmail(rs.getString("Email"));
                lstAnexo.add(anexo);
            }
        } catch (Exception e) {
            logger.error("buscar: " + e.getMessage());
           } finally {
            con.cerrarConexion(cn);
        }
        return lstAnexo;
    }

    @Override
    public int actualizar(AnexoWeb anexo) {
        logger.info("actualizar");
        sql = "{CALL Sp_AnexoWebActualizar(?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            con = new ConexionSql();
            cn = con.getConexion();
            cn.setAutoCommit(false);
            ps = cn.prepareStatement(sql);

            ps.setString(1, anexo.getCodAnexo());
            ps.setString(2, anexo.getApellidos());
            ps.setString(3, anexo.getNombres());
            ps.setString(4, anexo.getDocumento());
            ps.setString(5, anexo.getDireccion());
            ps.setString(6, anexo.getEmail());
            ps.setString(7, anexo.getTelefono());
            ps.setString(8, anexo.getRpm_rpc());
            ps.setString(9, anexo.getCelular());
            ps.setString(10, anexo.getPalabraClave());
            ps.setString(11, anexo.getPreguntaSeguridad());
           flgOperacion = ps.executeUpdate();
            if (flgOperacion > 0) {
                cn.commit();
            } else {
                cn.rollback();
            }
        } catch (Exception e) {
            logger.error("actualizar: " + e.getMessage());
        } finally {
            con.cerrarConexion(cn);
        }
        return flgOperacion;
    }

    @Override
    public List<AnexoWeb> listar(String CodAnexo) {
  logger.info("listar");
        sql = "{call Sp_AnexowebListarRegistros(?)} ";
        List<AnexoWeb> lstAnexo = null;
        AnexoWeb anexo = null;
        try {
            con = new ConexionSql();
            cn = con.getConexion();
            cn.setAutoCommit(false);
            ps = cn.prepareStatement(sql);
            ps.setString(1, CodAnexo);
             rs = ps.executeQuery();
            lstAnexo = new ArrayList<AnexoWeb>();
            while (rs.next()) {
                anexo = new AnexoWeb();
anexo.setCodAnexo(rs.getString("CodAnexo")) ;
anexo.setApellidos(rs.getString("Apellidos"));
anexo.setNombres(rs.getString("Nombres"));
anexo.setDocumento(rs.getString("Documento"));
anexo.setDireccion(rs.getString("Direccion"));
anexo.setEmail(rs.getString("email"));
anexo.setTelefono(rs.getString("Telefono"));
anexo.setRpm_rpc(rs.getString("rpm_rpc"));
anexo.setCelular(rs.getString("Celular"));
anexo.setPalabraClave(rs.getString("PalabraClave"));
anexo.setCodigoSeguridad(rs.getString("CodigoSeguridad"));
anexo.setFechaHora(rs.getString("FechaHora"));
anexo.setPreguntaSeguridad(rs.getString("PreguntaSeguridad"));
                
                
                lstAnexo.add(anexo);
            }
        } catch (Exception e) {
            logger.error("listar: " + e.getMessage());
           } finally {
            con.cerrarConexion(cn);
        }
        return lstAnexo;
    }


 @Override
    public int pass(AnexoWeb anexo) {

        logger.info("pass");
        sql = "{call Sp_AnexoWebRecuperarContraseña(?,?,?,?,?)} ";
             try {
con = new ConexionSql();
       cn = con.getConexion();
       cn.setAutoCommit(false);
       ps = cn.prepareStatement(sql);
       
        ps.setString(1, anexo.getCodAnexo());
            ps.setString(2, anexo.getDocumento());
            ps.setString(3, anexo.getPreguntaSeguridad());
            ps.setString(4, anexo.getPalabraClave());
            ps.setString(5, anexo.getContraseña());
            flgOperacion = ps.executeUpdate();
            
          if (flgOperacion > 0) {
                cn.commit();
            } else {
                cn.rollback();
            }
        } catch (Exception e) {
            logger.error("actualizar: " + e.getMessage());
        } finally {
            con.cerrarConexion(cn);
        }
        return flgOperacion;
    }
}

