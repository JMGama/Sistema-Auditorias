package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmpleadoDao;
import dao.GrupoDao;
import dao.RolDao;
import dao.UsuarioDao;

/**
 * Servlet implementation class ServletCrearAuditoria
 */
public class ServletCrearAuditoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCrearAuditoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getParameter("action");

		String forward = "";

		HttpSession session = request.getSession(false);
		if (session == null) {
			forward = "/index.jsp";
		} else{
		
			if (action.equals("crearAuditoria")) {
				UsuarioDao usuario = new UsuarioDao();
				GrupoDao grupo = new GrupoDao();
				RolDao rol = new RolDao();
				request.setAttribute("usuarios", usuario.obtenerUsuariosLider());
				request.setAttribute("grupos", grupo.obtenerGrupos());
				forward = "/formularioAuditorias.jsp";
			}else if (action.equals("home")) {
				forward = "/menuPrincipal.jsp";
			}
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
