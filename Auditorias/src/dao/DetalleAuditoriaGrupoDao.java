package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Auditoria;
import model.DetalleAuditoriaGrupo;
import util.ConexionBD;

public class DetalleAuditoriaGrupoDao {
	
public Connection connection;
	
	public DetalleAuditoriaGrupoDao(){
		connection = ConexionBD.getConnection();
	}
	
	public boolean addDetalleAuditoriaGrupo(DetalleAuditoriaGrupo detalleAuditoriaGrupo){
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO DET_AUDITORIA_GRUPO(FK_AUDITORIA,FK_GRUPO) values(?,?)");
			// Parameters start with 1
			preparedStatement.setInt(1, detalleAuditoriaGrupo.getFkAuditoria());
			preparedStatement.setInt(2, detalleAuditoriaGrupo.getFkGrupo());
			preparedStatement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<DetalleAuditoriaGrupo> obtenerDetalleAuditoriaGrupo() {
		List<DetalleAuditoriaGrupo> detalleAuditoriaGrupos = new ArrayList<DetalleAuditoriaGrupo>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM DET_AUDITORIA_GRUPO");

			while (rs.next()) {
				DetalleAuditoriaGrupo detalleAuditoriaGrupo = new DetalleAuditoriaGrupo();
				detalleAuditoriaGrupo.setFkAuditoria(rs.getInt(1));
				detalleAuditoriaGrupo.setFkGrupo(rs.getInt(2));
				
				detalleAuditoriaGrupos.add(detalleAuditoriaGrupo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return detalleAuditoriaGrupos;
	}
}
