package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Rol;
import util.ConexionBD;

public class RolDao {
	
private Connection connection;
	
	public RolDao(){
		connection = ConexionBD.getConnection();
	}
	
	public List<Rol> obtenerRoles() {
		List<Rol> roles = new ArrayList<Rol>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM ROL");

			while (rs.next()) {
				Rol rol = new Rol();

				rol.setIdRol(rs.getInt(1));
				rol.setNombre(rs.getString(2));
				rol.setDescripcion(rs.getString(3));

				roles.add(rol);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return roles;
	}

}
