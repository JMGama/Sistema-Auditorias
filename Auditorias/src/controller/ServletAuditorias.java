package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AuditoriaDao;
import dao.DetalleAuditoriaProcesoDao;
import dao.EmpleadoDao;
import dao.ProcesoDao;
import dao.UsuarioDao;

/**
 * Servlet implementation class ServletAuditorias
 */
public class ServletAuditorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAuditorias() {
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
		} else {
			if (action.equals("auditorias")) {
				AuditoriaDao auditoriaDao = new AuditoriaDao();
				UsuarioDao usuarioDao = new UsuarioDao();
				DetalleAuditoriaProcesoDao detalleAuditoriaProcesoDao = new DetalleAuditoriaProcesoDao();
				ProcesoDao procesoDao = new ProcesoDao();
				
				request.setAttribute("usuarios", usuarioDao.obtenerUsuariosLider());
				request.setAttribute("auditorias", auditoriaDao.obtenerAuditoria());
				request.setAttribute("procesos", procesoDao.obtenerProcesos());
				request.setAttribute("detalleAuditoriasProcesos", detalleAuditoriaProcesoDao.obtenerDetalleAuditoriaGrupo());
				
				forward = "/auditorias.jsp";
			} else if(action.equals("borrarAuditoria")) {
				AuditoriaDao auditoriaDao = new AuditoriaDao();
				UsuarioDao usuarioDao = new UsuarioDao();
				DetalleAuditoriaProcesoDao detalleAuditoriaProcesoDao = new DetalleAuditoriaProcesoDao();
				ProcesoDao procesoDao = new ProcesoDao();
				
				int idAuditoria = Integer.parseInt(request.getParameter("idAuditoria"));
				
				auditoriaDao.borrarAuditoria(idAuditoria);
				
				request.setAttribute("usuarios", usuarioDao.obtenerUsuariosLider());
				request.setAttribute("auditorias", auditoriaDao.obtenerAuditoria());
				request.setAttribute("procesos", procesoDao.obtenerProcesos());
				request.setAttribute("detalleAuditoriasProcesos", detalleAuditoriaProcesoDao.obtenerDetalleAuditoriaGrupo());
				
				forward = "/auditorias.jsp";
			}else if(action.equals("modificarItinerario")) {
				AuditoriaDao auditoriaDao = new AuditoriaDao();
				
				int idAuditoria = Integer.parseInt(request.getParameter("idAuditoria"));
				
				forward = "/ServletActividades?idAuditoria=" + idAuditoria;
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
		
	}

}
