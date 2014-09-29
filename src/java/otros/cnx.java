package otros;

import Conexion.ConexionMysql;
import Dao.AnexoWeb;
import Dao.P_tiendas;
import Model.dao.ListarTiendas;
import java.util.List;
import service.Impl.AnexoWebServiceImp;

public class cnx {

    public static void main(String[] args) {
        /*
         if (new ConexionSql().getConexion()!=null) {
         System.out.println(":)------->");
         }
         else{
         System.out.println(":(");
             
         }


         if (new ConnectionSqlsvr().getConnection()!=null) {
         System.out.println(":)------->");
         }
         else{
         System.out.println(":(");
             
         }
*/

    
         if (new ConexionMysql().getconexion()!=null) {
         System.out.println(":)------->");
         }
         else{
         System.out.println(":(");
             
         }
         ListarTiendas daoalumnos =  new ListarTiendas();
         List<P_tiendas> list = daoalumnos.getTiendas();

         for (P_tiendas p : list) {
         System.out.println(p.getCelular()
         + "\t" + p.getCorreo()
         + "\t" + p.getNombre()
         + "\t" + p.getDescripcion()
         + "\t" + p.getDireccion());
         }
             

       /*
         
         
//Sp_AnexoWebRecuperarContraseña '730413700','47519658','Lugar de Nacimiento','LIMA','123456'
        String CodAnexo = "730413700";
        String Documento = "47519658";
        String PreguntaSeguridad = "Lugar de Nacimiento";
        String PalabraClave = "LIMA";
        String Contraseña = "alexespinoza";

        AnexoWebServiceImp AnexoWeb = new AnexoWebServiceImp();
       // List<AnexoWeb> list = AnexoWeb.listar(CodAnexo, Documento, PreguntaSeguridad, PalabraClave, Contraseña);
List<AnexoWeb> list = AnexoWeb.listar(CodAnexo);
        for (AnexoWeb p : list) {
            System.out.println(p.getCodAnexo()
              + "\t" + p.getApellidos()
        + "\t" + p.getRpm_rpc()
+ "\t" + p.getTelefono()
+ "\t" + p.getPreguntaSeguridad()
+ "\t" + p.getFechaHora()
 + "\t" + p.getCelular()
+ "\t" + p.getDireccion()
+ "\t" + p.getEmail()
         + "\t" + p.getNombres());

        }
*/
    }
               

}
