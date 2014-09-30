package webServelet;

import Dao.AnexoWeb;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.dao.AnexoWebDao;
import javax.servlet.ServletContext;
import org.apache.log4j.Logger;
import service.Impl.AnexoWebServiceImp;

@WebServlet(name = "AnexoWebServlet", urlPatterns = {"/AnexoWeb"})
public class AnexoWebServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(AnexoWebServlet.class.getName());
    private AnexoWebDao anexoWebService;
    private AnexoWeb anexo;
    private int flgOperacion = 0;
    private String mensaje = null;
    private String sucess = null;
    private String Admin = null;
    private String host;
    private String port;
    private String user;
    private String pass;

    private HttpSession sesion;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("a");
        logger.info("processRequest: " + accion);
        if (accion != null) {
            if (accion.equals("insertar")) {
                insertar(request, response);
                return;
            }
            if (accion.equals("buscar")) {
                buscar(request, response);
                return;
            }
            if (accion.equals("pass")) {
                pass(request, response);
                return;
            }
            if (accion.equals("listar")) {
                listar(request, response);
                return;
            }
            if (accion.equals("actualizar")) {
                actualizar(request, response);
                return;
            }
            if (accion.equals("eliminar")) {
                eliminar(request, response);
            }
        }
    }

    protected void insertar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        logger.info("insertar");

        String CodAnexo = request.getParameter("TxtCodAnexo") == null ? ""
                : request.getParameter("TxtCodAnexo");
        String Apellidos = request.getParameter("TxtApelidos") == null ? ""
                : request.getParameter("TxtApelidos");
        String Nombres = request.getParameter("TxtNombres") == null ? ""
                : request.getParameter("TxtNombres");
        String Documento = request.getParameter("TxtDni") == null ? ""
                : request.getParameter("TxtDni");
        String Direccion = request.getParameter("TxtDireción") == null ? ""
                : request.getParameter("TxtDireción");
        String Telefono = request.getParameter("TxtTelefono") == null ? ""
                : request.getParameter("TxtTelefono");
        String Celular = request.getParameter("TxtCelular") == null ? ""
                : request.getParameter("TxtCelular");
        String rpm_rpc = request.getParameter("TxppmRpc") == null ? ""
                : request.getParameter("TxppmRpc");
        String email = request.getParameter("TxtEmail") == null ? ""
                : request.getParameter("TxtEmail");
        String PalabraClave = request.getParameter("TxtPalabraclave") == null ? ""
                : request.getParameter("TxtPalabraclave");
        String CodigoSeguridad = "123456";
        String IPCliente = "192.168.2.7";
        String PreguntaSeguridad = request.getParameter("DdlPregunta") == null ? ""
                : request.getParameter("DdlPregunta");
        String Contraseña = request.getParameter("TxtContraseña2") == null ? ""
                : request.getParameter("TxtContraseña2");
        try {
            anexo = new AnexoWeb();
            anexo.setCodAnexo(CodAnexo);
            anexo.setApellidos(Apellidos);
            anexo.setNombres(Nombres);
            anexo.setDocumento(Documento);
            anexo.setDireccion(Direccion);
            anexo.setEmail(email);
            anexo.setTelefono(Telefono);
            anexo.setRpm_rpc(rpm_rpc);
            anexo.setCelular(Celular);
            anexo.setPalabraClave(PalabraClave);
            anexo.setCodigoSeguridad(CodigoSeguridad);
            anexo.setIPCliente(IPCliente);
            anexo.setPreguntaSeguridad(PreguntaSeguridad);
            anexo.setContraseña(Contraseña);

            anexoWebService = new AnexoWebServiceImp();
            flgOperacion = anexoWebService.insertar(anexo);
            // reads SMTP server setting from web.xml file
            ServletContext context = getServletContext();
            host = context.getInitParameter("host");
            port = context.getInitParameter("port");
            user = context.getInitParameter("user");
            pass = context.getInitParameter("pass");
            String subject = "Registro En Bazar Central Del Ejército";
            String content = "Registró en Bazar Central Del Ejército\n"
                    +"------------------------------------------------------------------------------\n"
                    + "Nro. Administrativo: " + CodAnexo + "\n"
                    + "Nro DNI: " + Documento + "\n"
                    + "Pregunta de Seguridad: " + PreguntaSeguridad + "\n"
                    + "Palabra Clave: " + PalabraClave + "\n"
                    + "Apellidos y Nombres: " + Apellidos + ", " + Nombres + "\n"
                    + "Telefono: " + Telefono + "\n"
                    + "Celular: " + Celular + "\n"
                    + "RPM/RPC: " + rpm_rpc + "\n"
                    +"------------------------------------------------------------------------------\n"
                    + " Bazar Central del Ejercito  https://www.bcetubazar.com/ ";

            if (flgOperacion > 0) {
                EmailUtility.sendEmail(host, port, user, pass, email, subject, content);
                sucess = "1";
                mensaje = "El  usuario se registró correctamente, Sus datos han sido enviados a su correo registrado";
                Admin = CodAnexo;
                sesion.removeAttribute("lstaAnexo");
            } else {
                sucess = "0";
                mensaje = "Error al registrar usuario intente nuevamente";
            }
            sesion = request.getSession();
            sesion.removeAttribute("msgPostOperacion");
            sesion.removeAttribute("listaAnexo");
            sesion.removeAttribute("msgListado");
            sesion.removeAttribute("clienteActualizar");
            sesion.removeAttribute("sucess");
            sesion.setAttribute("mensaje", mensaje);
            sesion.setAttribute("sucess", sucess);
            sesion.setAttribute("Admin", Admin);
            //response.sendRedirect("/webbce/?content=registro-detalle");
//response.setHeader("Cache-Control", "no-cache");
//response.setDateHeader("Expires", 0);
            response.sendRedirect("AnexoWeb?a=listar&TxtAdmin=" + Admin);
            //listar(request, response);
        } catch (Exception e) {
            logger.error("insertar: " + e.getMessage());
        }
    }

    protected void buscar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        logger.info("buscar");
        String CodAnexo = request.getParameter("TxtAdmin");
        String Documento = request.getParameter("TxtDoc");
        try {
            sesion = request.getSession();
            sesion.removeAttribute("lstaAnexo");
            sesion.removeAttribute("msgListado");
            sesion.removeAttribute("clienteActualizar");
            sesion.removeAttribute("sucess");
            anexoWebService = new AnexoWebServiceImp();
            List<AnexoWeb> lstAnexo = anexoWebService.buscar(CodAnexo, Documento);
            if (lstAnexo.size() > 0) {
                sesion.setAttribute("lstaAnexo", lstAnexo);
                sesion.setAttribute("CodAnexo", CodAnexo);
            } else {
                sucess = "Datos incorrectos";
            }
            sesion.removeAttribute("sucess");
            sesion.setAttribute("sucess", sucess);
            response.sendRedirect("/webbce/?content=registro");
        } catch (Exception e) {
            logger.error("buscar: " + e.getMessage());
        }
    }

    protected void pass(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        logger.info("pass");
        String CodAnexo = request.getParameter("TxtCod") == null ? ""
                : request.getParameter("TxtCod");
        String Documento = request.getParameter("TxtDoc") == null ? ""
                : request.getParameter("TxtDoc");
        String PreguntaSeguridad = request.getParameter("DdlPregunta") == null ? ""
                : request.getParameter("DdlPregunta");
        String PalabraClave = request.getParameter("TxtPalabraclave") == null ? ""
                : request.getParameter("TxtPalabraclave");
        String Contraseña = request.getParameter("Txtpass2") == null ? ""
                : request.getParameter("Txtpass2");
        try {
            anexo = new AnexoWeb();
            anexo.setCodAnexo(CodAnexo);
            anexo.setDocumento(Documento);
            anexo.setPreguntaSeguridad(PreguntaSeguridad);
            anexo.setPalabraClave(PalabraClave);
            anexo.setContraseña(Contraseña);
            anexoWebService = new AnexoWebServiceImp();
            flgOperacion = anexoWebService.pass(anexo);
            if (flgOperacion == 1) {
                mensaje = "La contraseña restableció correctamente.";
                sucess = "1";
            } else if (flgOperacion == 0) {
                mensaje = "Datos incorrectos intente nuevamente por favor.";
                sucess = "0";
            } else {
                mensaje = "Datos incorrectos intente nuevamente por favor.";
                sucess = "0";
            }
            sesion = request.getSession();
            sesion.removeAttribute("msgPostOperacion");
            sesion.removeAttribute("listaClientes");
            sesion.removeAttribute("msgListado");
            sesion.removeAttribute("clienteActualizar");
            sesion.setAttribute("msgPostOperacion", mensaje);
            sesion.setAttribute("sucess", sucess);
            response.sendRedirect("/webbce/?content=recuperar-clave");
        } catch (Exception e) {
            logger.error("pass: " + e.getMessage());
        }

    }

    protected void listar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        logger.info("listar");
        String CodAnexo = request.getParameter("TxtAdmin");

        try {
            sesion = request.getSession();
            sesion.removeAttribute("lstaAnexo_deta");
            sesion.removeAttribute("msgListado");
            sesion.removeAttribute("clienteActualizar");

            anexoWebService = new AnexoWebServiceImp();

            List<AnexoWeb> lstaAnexo_deta = anexoWebService.listar(CodAnexo);
            if (lstaAnexo_deta.size() > 0) {
                sesion.setAttribute("lstaAnexo_deta", lstaAnexo_deta);
            } else {
                mensaje = "Datos incorrectos";
            }
            sesion.setAttribute("msgListado", mensaje);
            response.sendRedirect("/webbce/?content=registro-detalle");
        } catch (Exception e) {
            logger.error("listar: " + e.getMessage());
        }
    }

    protected void actualizar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        logger.info("actualizar");
        String CodAnexo = request.getParameter("CodAnexo") == null ? ""
                : request.getParameter("CodAnexo");

        String Apellidos = request.getParameter("Apellidos") == null ? ""
                : request.getParameter("Apellidos");

        String Nombres = request.getParameter("Nombres") == null ? ""
                : request.getParameter("Nombres");

        String Documento = request.getParameter("Documento") == null ? ""
                : request.getParameter("Documento");

        String Direccion = request.getParameter("Direccion") == null ? ""
                : request.getParameter("Direccion");

        String email = request.getParameter("email") == null ? ""
                : request.getParameter("email");

        String Telefono = request.getParameter("Telefono") == null ? ""
                : request.getParameter("Telefono");

        String rpm_rpc = request.getParameter("rpm_rpc") == null ? ""
                : request.getParameter("rpm_rpc");

        String Celular = request.getParameter("Celular") == null ? ""
                : request.getParameter("Celular");

        String Usuario = request.getParameter("Usuario") == null ? ""
                : request.getParameter("Usuario");

        String PalabraClave = request.getParameter("PalabraClave") == null ? ""
                : request.getParameter("PalabraClave");

        String CodigoSeguridad = request.getParameter("CodigoSeguridad") == null ? ""
                : request.getParameter("CodigoSeguridad");

        String IPCliente = request.getParameter("IPCliente") == null ? ""
                : request.getParameter("IPCliente");

        String PreguntaSeguridad = request.getParameter("PreguntaSeguridad") == null ? ""
                : request.getParameter("PreguntaSeguridad");

        String Contraseña = request.getParameter("Contraseña") == null ? ""
                : request.getParameter("Contraseña");
        /*
         try {
         cliente = new ClienteBean();
         anexo.setId(id);
         anexo.setRuc(ruc);
         anexo.setRazSocial(razSocial);
         anexo.setDireccion(direccion);
         anexo.setTelefono(telefono);
         clienteService = new ClienteServiceImpl();
         flgOperacion = clienteService.actualizar(cliente);
         if (flgOperacion == 1) {
         mensaje = "Cliente actualizado correctamente.";
         } else if (flgOperacion == 0) {
         mensaje = "Error al actualizaranexo.";
         } else {
         mensaje = "RUC o Razón Social de cliente duplicados.";
         }
         sesion = request.getSession();
         sesion.removeAttribute("msgPostOperacion");
         sesion.removeAttribute("listaClientes");
         sesion.removeAttribute("msgListado");
         sesion.removeAttribute("clienteActualizar");
         sesion.setAttribute("msgPostOperacion", mensaje);
         buscar(request, response);
         } catch (Exception e) {
         logger.error("actualizar: " + e.getMessage());
         }
         */
    }

    protected void eliminar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        logger.info("eliminar");
        int id = Integer.parseInt(request.getParameter("id") == null ? "0"
                : request.getParameter("id"));
        /*
         try {
         clienteService = new ClienteServiceImpl();
         flgOperacion = clienteService.eliminar(id);
         if (flgOperacion > 0) {
         mensaje = "Cliente eliminado correctamente.";
         } else {
         mensaje = "Error al eliminaranexo.";
         }
         sesion = request.getSession();
         sesion.removeAttribute("msgPostOperacion");
         sesion.removeAttribute("listaClientes");
         sesion.removeAttribute("msgListado");
         sesion.removeAttribute("clienteActualizar");
         sesion.setAttribute("msgPostOperacion", mensaje);
         buscar(request, response);
         } catch (Exception e) {
         logger.error("eliminar: " + e.getMessage());
         }
         */
    }
}
