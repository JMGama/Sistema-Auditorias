package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Ubicacion;
import util.ConexionBD;

public class UbicacionDao {

public Connection connection;
	
	public UbicacionDao(){
		connection = ConexionBD.getConnection();
	}
	
	public List<Ubicacion> obtenerUbicaciones() {
		List<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM UBICACION");

			while (rs.next()) {
				Ubicacion ubicacion = new Ubicacion();
				ubicacion.setIdUbicacion(rs.getInt(1));
				ubicacion.setNombre(rs.getString(2));
				ubicacion.setDescripcion(rs.getString(3));
				
				ubicaciones.add(ubicacion);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ubicaciones;
	}
}
