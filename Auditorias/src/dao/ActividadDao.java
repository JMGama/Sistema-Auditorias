package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Actividad;
import util.ConexionBD;

public class ActividadDao {

public Connection connection;
	
	public ActividadDao(){
		connection = ConexionBD.getConnection();
	}
	
	public int getUltimoId(){
		int resultado = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT COUNT(ID_ACTIVIDAD) FROM ACTIVIDAD");

			rs.next();
			resultado = rs.getInt(1) + 1;
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public boolean addActividad(Actividad actividad){
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO ACTIVIDAD(ID_ACTIVIDAD, FECHA, HORA, FK_UBICACION, DESCRIPCION, FK_AUDITORIA) values(?,?,?,?,?,?)");
			// Parameters start with 1
			preparedStatement.setInt(1, actividad.getIdActividad());
			preparedStatement.setDate(2,  new java.sql.Date(actividad.getFecha().getTime()));
			preparedStatement.setString(3, actividad.getHora());
			preparedStatement.setInt(4, actividad.getFkUbicacion());
			preparedStatement.setString(5, actividad.getDescripcion());
			preparedStatement.setInt(6, actividad.getFkAuditoria());
			preparedStatement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Actividad> obtenerActividad(int idAuditoria) {
		List<Actividad> actividades = new ArrayList<Actividad>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT A.ID_ACTIVIDAD, A.FECHA, A.HORA, U.NOMBRE , A.DESCRIPCION "
					+ "FROM ACTIVIDAD A "
					+ "JOIN UBICACION U "
					+ "ON A.FK_UBICACION = U.ID_UBICACION "
					+ "WHERE FK_AUDITORIA = " + idAuditoria);

			while (rs.next()) {
				Actividad actividad = new Actividad();
				actividad.setIdActividad(rs.getInt(1));
				actividad.setFecha(rs.getDate(2));
				actividad.setHora(rs.getString(3));
				actividad.setNombreUbicacion(rs.getString(4));
				actividad.setDescripcion(rs.getString(5));
				
				actividades.add(actividad);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actividades;
	}
	
}
