package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Grupo;
import util.ConexionBD;

public class GrupoDao {

	private Connection connection;
	
	public GrupoDao(){
		connection = ConexionBD.getConnection();
	}
	
	public List<Grupo> obtenerGrupos() {
		List<Grupo> grupos = new ArrayList<Grupo>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM GRUPO");

			while (rs.next()) {
				Grupo grupo = new Grupo();

				grupo.setIdGrupo(rs.getInt(1));
				grupo.setNombre(rs.getString(2));
				grupo.setDescripcion(rs.getString(3));

				grupos.add(grupo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return grupos;
	}
	
}
