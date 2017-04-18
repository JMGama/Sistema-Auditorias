package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DetalleAuditoriaGrupo;
import model.DetalleAuditoriaProceso;
import util.ConexionBD;

public class DetalleAuditoriaProcesoDao {
	
	public Connection connection;
	
	public DetalleAuditoriaProcesoDao(){
		connection = ConexionBD.getConnection();
	}
	
	public boolean addDetalleAuditoriaProceso(DetalleAuditoriaProceso detalleAuditoriaProceso){
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO DET_AUDITORIA_PROCESO(FK_AUDITORIA,FK_PROCESO) values(?,?)");
			// Parameters start with 1
			preparedStatement.setInt(1, detalleAuditoriaProceso.getFkAuditoria());
			preparedStatement.setInt(2, detalleAuditoriaProceso.getFkProceso());
			preparedStatement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<DetalleAuditoriaProceso> obtenerDetalleAuditoriaGrupo() {
		List<DetalleAuditoriaProceso> detalleAuditoriaProcesos = new ArrayList<DetalleAuditoriaProceso>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM DET_AUDITORIA_PROCESO");

			while (rs.next()) {
				DetalleAuditoriaProceso detalleAuditoriaProceso = new DetalleAuditoriaProceso();
				detalleAuditoriaProceso.setFkAuditoria(rs.getInt(1));
				detalleAuditoriaProceso.setFkProceso(rs.getInt(2));
				
				detalleAuditoriaProcesos.add(detalleAuditoriaProceso);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return detalleAuditoriaProcesos;
	}
}
