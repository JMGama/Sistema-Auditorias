package model;

import java.util.Date;

public class Actividad {

	private int idActividad;
	private Date fecha;
	private String hora;
	private int fkUbicacion;
	private String descripcion;
	private int fkAuditoria;
	private String nombreUbicacion;
	
	public String getNombreUbicacion() {
		return nombreUbicacion;
	}
	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}
	public int getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getFkUbicacion() {
		return fkUbicacion;
	}
	public void setFkUbicacion(int fkUbicacion) {
		this.fkUbicacion = fkUbicacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getFkAuditoria() {
		return fkAuditoria;
	}
	public void setFkAuditoria(int fkAuditoria) {
		this.fkAuditoria = fkAuditoria;
	}
	
}
