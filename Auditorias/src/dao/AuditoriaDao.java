package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Auditoria;
import model.Usuario;
import util.ConexionBD;

public class AuditoriaDao {

	public Connection connection;
	
	public AuditoriaDao(){
		connection = ConexionBD.getConnection();
	}
	
	public int getUltimoId(){
		int resultado = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT COUNT(ID_AUDITORIA) FROM AUDITORIA");

			rs.next();
			resultado = rs.getInt(1) + 1;
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public boolean addAuditoria(Auditoria auditoria){
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO AUDITORIA(ID_AUDITORIA, CLAVE_DE_NEGOCIO, FECHA, OBJETIVO, ALCANCE, ESTATUS, FK_USUARIO) values(?,?,?,?,?,?,?)");
			// Parameters start with 1
			preparedStatement.setInt(1, auditoria.getIdAuditoria());
			preparedStatement.setString(2, auditoria.getClaveNegocio());
			preparedStatement.setDate(3,  new java.sql.Date(auditoria.getFecha().getTime()));
			preparedStatement.setString(4, auditoria.getObjetivo());
			preparedStatement.setString(5, auditoria.getAlcance());
			preparedStatement.setString(6, auditoria.getEstatus());
			preparedStatement.setInt(7, auditoria.getFk_usuario());
			preparedStatement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Auditoria> obtenerAuditoria() {
		List<Auditoria> auditorias = new ArrayList<Auditoria>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM AUDITORIA WHERE ESTATUS = 'ACTIVO'");

			while (rs.next()) {
				Auditoria auditoria = new Auditoria();
				auditoria.setIdAuditoria(rs.getInt(1));
				auditoria.setClaveNegocio(rs.getString(2));
				auditoria.setFecha(rs.getDate(3));
				auditoria.setObjetivo(rs.getString(4));
				auditoria.setAlcance(rs.getString(5));
				auditoria.setEstatus(rs.getString(6));
				auditoria.setFk_usuario(rs.getInt(7));
				
				auditorias.add(auditoria);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return auditorias;
	}

	public boolean borrarAuditoria(int idAuditoria) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE AUDITORIA SET ESTATUS = 'NO ACTIVO' "
					+ "WHERE ID_AUDITORIA = "+ idAuditoria);
			
			preparedStatement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
