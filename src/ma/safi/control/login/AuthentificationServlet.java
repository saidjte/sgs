package ma.safi.control.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.safi.entities.Users;
import ma.safi.service.UserService;
import ma.safi.service.UserServiceimpl;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/login")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String loguser = request.getParameter("loguser");
		String logpass = request.getParameter("logpass");
		Cookie cookie = null;
		HttpSession session = null;
		Users user = new Users();
		//verifierParametres()
				if(logpass.isEmpty() || loguser.isEmpty()) {
					request.setAttribute("msglogin", "Echec d'authentification!! Merci de réessayer à nouveau");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login/login.jsp");
					dispatcher.forward(request, response);

				} else {
					try {
					UserService userService = new UserServiceimpl();
					user = userService.getUserByloginService(loguser);
					Boolean usercheck = (user.getLogin().equals(loguser) && user.getPassword().equals(logpass));
					if(usercheck==true) {
						cookie = new Cookie("singin", loguser);
						response.addCookie(cookie);
						session = request.getSession();
						session.setMaxInactiveInterval(600);
						session.setAttribute("authentifie", true);
						session.setAttribute("login", loguser);
						session.setAttribute("user", user);
						response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/"));
					} else {
						request.setAttribute("msglogin", "Erreur login/password! Merci de réessayer à nouveau");
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login/login.jsp");
						dispatcher.forward(request, response);
					}
					}catch (NullPointerException e) {
						request.setAttribute("msglogin", "Erreur login/password! Merci de réessayer à nouveau");
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login/login.jsp");
						dispatcher.forward(request, response);
					}
				}

	}

}
