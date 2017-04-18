package model;

import java.util.Date;

public class Auditoria {
	
	private int idAuditoria;
	private String claveNegocio;
	private Date fecha;
	private String objetivo;
	private String alcance;
	private String estatus;
	private int fk_usuario;
	
	public int getIdAuditoria() {
		return idAuditoria;
	}
	public void setIdAuditoria(int idAuditoria) {
		this.idAuditoria = idAuditoria;
	}
	public String getClaveNegocio() {
		return claveNegocio;
	}
	public void setClaveNegocio(String claveNegocio) {
		this.claveNegocio = claveNegocio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getAlcance() {
		return alcance;
	}
	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public int getFk_usuario() {
		return fk_usuario;
	}
	public void setFk_usuario(int fk_usuario) {
		this.fk_usuario = fk_usuario;
	}
	
}
