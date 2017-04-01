package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Empleado;
import util.ConexionBD;

public class EmpleadoDao {
	
	private Connection connection;
	
	public EmpleadoDao() {
		connection = ConexionBD.getConnection();
	}
	
	public List<Empleado> obtenerEmpleados() {
		List<Empleado> empleados = new ArrayList<Empleado>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM EMPLEADO WHERE ID_EMPLEADO NOT IN (SELECT FK_EMPLEADO FROM USUARIO)");

			while (rs.next()) {
				Empleado empleado = new Empleado();

				empleado.setIdEmpleado(rs.getInt(1));
				empleado.setNombre(rs.getString(2));
				empleado.setApellidoPaterno(rs.getString(3));
				empleado.setApellidoMaterno(rs.getString(4));
				empleado.setFechaNacimiento(rs.getDate(5));
				empleado.setRfc(rs.getString(6));
				empleado.setCurp(rs.getString(7));
				empleado.setClaveEmpleado(rs.getString(8));

				empleados.add(empleado);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empleados;
	}
}
