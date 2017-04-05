package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Proceso;
import model.Usuario;
import util.ConexionBD;

public class ProcesoDao {

	public Connection connection;
	
	public ProcesoDao(){
		connection = ConexionBD.getConnection();
	}
	
	public int getUltimoId(){
		int resultado = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT COUNT(ID_PROCESO) FROM PROCESO");

			rs.next();
			resultado = rs.getInt(1) + 1;
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public boolean addProceso(Proceso proceso){
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO PROCESO(ID_PROCESO, NOMBRE, DESCRIPCION, ESTATUS) values(?,?,?,?)");
			// Parameters start with 1
			preparedStatement.setInt(1, proceso.getIdProceso());
			preparedStatement.setString(2, proceso.getNombre());
			preparedStatement.setString(3, proceso.getDescripcion());
			preparedStatement.setString(4, proceso.getEstatus());
			preparedStatement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Proceso> obtenerProcesos() {
		List<Proceso> procesos = new ArrayList<Proceso>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM PROCESO WHERE ESTATUS = 'ACTIVO'");

			while (rs.next()) {
				Proceso proceso = new Proceso();
				proceso.setIdProceso(rs.getInt(1));
				proceso.setNombre(rs.getString(2));
				proceso.setDescripcion(rs.getString(3));
				proceso.setEstatus(rs.getString(4));
				
				procesos.add(proceso);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return procesos;
	}
}
