package webServelet;

import Model.dao.LoginDAO;
import Dao.LoginBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();

    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			LoginBean user = new LoginBean();
			user.setCodAnexo(request.getParameter("codanexo"));
                        user.setDni(request.getParameter("documento"));
			user.setPassword(request.getParameter("password"));
                    			user = LoginDAO.login(user);
			if(user.isValid())
			{
			HttpSession session = request.getSession(true);
				session.setAttribute("NomAnexo",user.getNomAnexo());
                                 request.setAttribute("NomAnexo",user.getNomAnexo());
                                  session.setAttribute("CodAnexo",user.getCodAnexo());
                                 request.setAttribute("CodAnexo",user.getCodAnexo());
                              session.removeAttribute("ms");
				response.sendRedirect("/webbce");
			}else{
                        HttpSession session = request.getSession(true);
                        session.setAttribute("ms","Datos Incorrectos");
                        }
			  
                        
                            response.sendRedirect("/webbce");
         } catch (Throwable exc)
		{
			System.out.println(exc );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}