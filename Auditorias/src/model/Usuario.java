package model;

import java.util.Date;

public class Usuario {
	
	private int idUsuario;
	private String usuario;
	private String contrasenia;
	private Date fechaDeAlta;
	private int fkEmpleado;
	private int fkGrupo;
	private String lider;
	private String estatus;
	
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}
	public void setFechaDeAlta(Date fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}
	public int getFkEmpleado() {
		return fkEmpleado;
	}
	public void setFkEmpleado(int fkEmpleado) {
		this.fkEmpleado = fkEmpleado;
	}
	public int getFkGrupo() {
		return fkGrupo;
	}
	public void setFkGrupo(int fkGrupo) {
		this.fkGrupo = fkGrupo;
	}
	public String getLider() {
		return lider;
	}
	public void setLider(String lider) {
		this.lider = lider;
	}
	
}
