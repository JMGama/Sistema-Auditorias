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

import dao.ActividadDao;
import dao.UbicacionDao;
import model.Actividad;

/**
 * Servlet implementation class ServlerActividades
 */
public class ServletActividades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActividades() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String forward = "";
		
		int idAuditoria = Integer.parseInt(request.getParameter("idAuditoria"));
		
		HttpSession session = request.getSession(false);
		if (session == null) {
			forward = "/index.jsp";
		} else {
			ActividadDao actividadDao = new ActividadDao();
			UbicacionDao ubicacionDao = new UbicacionDao();
			
			request.setAttribute("actividades", actividadDao.obtenerActividad(idAuditoria));
			request.setAttribute("ubicaciones", ubicacionDao.obtenerUbicaciones());
			request.setAttribute("idAuditoria", idAuditoria);
			
			forward = "/formularioActividad.jsp";
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String forward = "";
		String action = request.getParameter("action");
		HttpSession session = request.getSession(false);
		if (session == null) {
			forward = "/index.jsp";
		} else {
			if (action.equals("actualizarItinerario")){
				int idAuditoria = Integer.parseInt(request.getParameter("idAuditoria"));
				
				ActividadDao actividadDao = new ActividadDao();
				UbicacionDao ubicacionDao = new UbicacionDao();
				
				Actividad actividad = new Actividad();
				
				int idActividad = actividadDao.getUltimoId();
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date(request.getParameter("fecha"));
				String stringFecha = dateFormat.format(date);
				Date fecha = null;
				
				try {
					fecha = dateFormat.parse(stringFecha);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				String horas = request.getParameter("horas");
				String minutos = request.getParameter("minutos");
				String hora = horas + ":" + minutos;
				
				int fkUbicacion = Integer.parseInt(request.getParameter("ubicacion"));
				String descripcion = request.getParameter("descripcion");
				int fkAuditoria = idAuditoria;
				
				actividad.setIdActividad(idActividad);
				actividad.setFecha(fecha);
				actividad.setHora(hora);
				actividad.setFkUbicacion(fkUbicacion);
				actividad.setDescripcion(descripcion);
				actividad.setFkAuditoria(fkAuditoria);
				
				boolean resualtado = actividadDao.addActividad(actividad);
				
				if (!resualtado) {
					action = "";
					forward = "/mensajeError.jsp";
				}
				
				request.setAttribute("actividades", actividadDao.obtenerActividad(idAuditoria));
				request.setAttribute("ubicaciones", ubicacionDao.obtenerUbicaciones());
				request.setAttribute("idAuditoria", idAuditoria);
				
				forward = "/formularioActividad.jsp";
			}else if (action.equals("finalizarItinerario")){
				forward = "/auditorias.jsp";
			}else{
				forward = "/formularioActividad.jsp";
			}
			
			
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
