package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmpleadoDao;
import dao.GrupoDao;
import dao.ProcesoDao;
import dao.RolDao;
import dao.UsuarioDao;
import model.Auditoria;

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
				ProcesoDao proceso = new ProcesoDao();
				request.setAttribute("usuarios", usuario.obtenerUsuariosLider());
				request.setAttribute("grupos", grupo.obtenerGrupos());
				request.setAttribute("procesos", proceso.obtenerProcesos());
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
		String action = request.getParameter("action");

		String forward = "";

		HttpSession session = request.getSession(false);
		if (session == null) {
			forward = "/index.jsp";
		} else{
		
			if (action.equals("finalizarAuditoria")) {
				String claveNegocio = request.getParameter("claveNegocio");
				String[] procesos = request.getParameterValues("procesos");
				int fk_usuario = Integer.parseInt(request.getParameter("auditorLider"));
				String[] grupos = request.getParameterValues("grupos");
				String objetivo = request.getParameter("objetivo");
				String alcance = request.getParameter("alcance");
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				String stringFecha = dateFormat.format(date);
				Date fecha = null;
				
				try {
					fecha = dateFormat.parse(stringFecha);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				Auditoria auditoria = new Auditoria();
				auditoria.setClaveNegocio(claveNegocio);
				auditoria.setFecha(fecha);
				auditoria.setEstatus("ACTIVO");
				auditoria.setObjetivo(objetivo);
				auditoria.setAlcance(alcance);
				auditoria.setFk_usuario(fk_usuario);
				
				forward = "/formularioAuditorias.jsp";
			}else if (action.equals("home")) {
				forward = "/menuPrincipal.jsp";
			}
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		
	}

}
