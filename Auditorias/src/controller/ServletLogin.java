package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDao;
import model.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String forward = "/index.jsp";
		
		HttpSession session = request.getSession(false);
		if (session == null) {
			forward = "/index.jsp";
		} else{
			forward = "/menuPrincipal.jsp";
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String action = request.getParameter("action");

		String forward = "/index.jsp";

		if (action.equals("login")) {

			String usuario = request.getParameter("usuario");
			String contrasenia = request.getParameter("contrasenia");
			UsuarioDao usuarioDao = new UsuarioDao();
			
			Usuario user = usuarioDao.validarLogin(usuario, contrasenia);
			if (usuario.equals(user.getUsuario()) && contrasenia.equals(user.getContrasenia())) {

				HttpSession session = request.getSession();
				forward = "/menuPrincipal.jsp";
			} else {
				forward = "/index.jsp";
			}
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
