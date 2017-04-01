package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import dao.DetalleUsuarioRolDao;
import dao.EmpleadoDao;
import dao.GrupoDao;
import dao.RolDao;
import dao.UsuarioDao;
import model.Rol;
import model.Usuario;

/**
 * Servlet implementation class ServletCrearUsuario
 */
public class ServletCrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCrearUsuario() {
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
		
			if (action.equals("crearUsuario")) {
				EmpleadoDao empleado = new EmpleadoDao();
				GrupoDao grupo = new GrupoDao();
				RolDao rol = new RolDao();
				request.setAttribute("empleados", empleado.obtenerEmpleados());
				request.setAttribute("grupos", grupo.obtenerGrupos());
				request.setAttribute("roles", rol.obtenerRoles());
				forward = "/formularioUsuarios.jsp";
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
		String forward = "";
		String action = request.getParameter("action");
		
		HttpSession session = request.getSession(false);
		if (session == null) {
			forward = "/index.jsp";
		} else {
		
			if (action.equals("finalizarUsuario")){
				UsuarioDao usuarioDao = new UsuarioDao();
				int idUsuario = usuarioDao.getUltimoId();
				
				int idEmpleado = Integer.parseInt(request.getParameter("empleado"));
				String usuario = request.getParameter("usuario");
				String contrasenia = request.getParameter("contrasenia");
				int idGrupo = Integer.parseInt(request.getParameter("grupo"));
				String nombreRoles = request.getParameter("roles");
				String lider = request.getParameter("lider");
				
				if (lider == null || lider.equals(null)) {
					lider = "NO";
				}else {
					lider = "SI";
				}
				
				String[] roles = nombreRoles.split(",");
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				String stringFecha = dateFormat.format(date);
				Date fecha = null;
				
				try {
					fecha = dateFormat.parse(stringFecha);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				Usuario nuevoUsuario = new Usuario();
				nuevoUsuario.setIdUsuario(idUsuario);
				nuevoUsuario.setUsuario(usuario);
				nuevoUsuario.setContrasenia(contrasenia);
				nuevoUsuario.setFechaDeAlta(fecha);
				nuevoUsuario.setFkEmpleado(idEmpleado);
				nuevoUsuario.setFkGrupo(idGrupo);
				nuevoUsuario.setLider(lider);
				
				RolDao rolDao = new RolDao();
				List<Rol> listaRoles = rolDao.obtenerRoles();
				List<Rol> listaFinalRoles = new ArrayList<Rol>();
				
				for (String nombre : roles) {
					for (Rol rol : listaRoles) {
						if (nombre.equals(rol.getNombre())) {
							listaFinalRoles.add(rol);
						}
					}
				}
				
				boolean resCrearUsuario = usuarioDao.addUsuario(nuevoUsuario);
				
				boolean resCrearDetalleUsuarioRol = false;
				for (Rol rol : listaFinalRoles) {
					DetalleUsuarioRolDao detalleUsuarioRol = new DetalleUsuarioRolDao();
					resCrearDetalleUsuarioRol = detalleUsuarioRol.addDetalleUsuarioRol(rol, nuevoUsuario);
				}
				 
				
				if (resCrearUsuario && resCrearDetalleUsuarioRol) {
					forward = "/mensajeExitoso.jsp";
				}else{
					forward = "/mensajeError.jsp";
				}
				
			}
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		
	}

}
