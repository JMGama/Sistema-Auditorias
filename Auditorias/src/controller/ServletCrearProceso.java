package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GrupoDao;
import dao.ProcesoDao;
import dao.RolDao;
import dao.UsuarioDao;
import model.Proceso;

/**
 * Servlet implementation class ServlerCrearProceso
 */
public class ServletCrearProceso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCrearProceso() {
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
		
			if (action.equals("crearProceso")) {
				UsuarioDao usuario = new UsuarioDao();
				GrupoDao grupo = new GrupoDao();
				RolDao rol = new RolDao();
				forward = "/formularioProcesos.jsp";
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
		
			if (action.equals("finalizarProceso")) {
				String nombre = request.getParameter("nombre");
				String descripcion = request.getParameter("descripcion");
				
				Proceso proceso = new Proceso();
				ProcesoDao procesoDao = new ProcesoDao();
				
				proceso.setIdProceso(procesoDao.getUltimoId());
				proceso.setNombre(nombre);
				proceso.setDescripcion(descripcion);
				proceso.setEstatus("ACTIVO");
				
				boolean resultado = procesoDao.addProceso(proceso);
				
				if(resultado){
					forward = "/mensajeExitoso.jsp";
				}else{
					forward = "/mensajeError.jsp";
				}
				
			}else if (action.equals("home")) {
				forward = "/menuPrincipal.jsp";
			}
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);	
	}

}
