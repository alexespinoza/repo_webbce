package webReportesServelet;
import Conexion.ConexionSql;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

@WebServlet(name = "EstadoCuentaCliente", urlPatterns = {"/reportes_pag/EstadoCuentaCliente"})
public class EstadoCuentaCliente extends HttpServlet{
    ConexionSql con;
    Connection cn;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
String CodAnexo = request.getParameter("id");
response.setContentType("application/pdf");
   try
   {
     con = new ConexionSql();
            cn = con.getConexion();
  ServletOutputStream out = response.getOutputStream();
JasperReport reporte = (JasperReport) JRLoader.loadObject(getServletContext().getRealPath("reportes/ECC.jasper"));
Map parametros = new HashMap();
parametros.put("CodAnexo", CodAnexo);
JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, cn);
JRExporter exporter = new JRPdfExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
exporter.exportReport();
out.flush();
out.close();
   }
   catch (Exception e)
   {
     System.out.println(e.getMessage());
   }finally{
  con.cerrarConexion(cn);
  }
      }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

   
    
}
