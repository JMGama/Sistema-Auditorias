package model;

public class DetalleUsuarioRol {

	private int idDetalleUsuarioRol;
	private int fkUsuario;
	private int fkRol;
	
	public int getIdDetalleUsuarioRol() {
		return idDetalleUsuarioRol;
	}
	public void setIdDetalleUsuarioRol(int idDetalleUsuarioRol) {
		this.idDetalleUsuarioRol = idDetalleUsuarioRol;
	}
	public int getFkUsuario() {
		return fkUsuario;
	}
	public void setFkUsuario(int fkUsuario) {
		this.fkUsuario = fkUsuario;
	}
	public int getFkRol() {
		return fkRol;
	}
	public void setFkRol(int fkRol) {
		this.fkRol = fkRol;
	}
	
}
