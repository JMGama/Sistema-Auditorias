package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Empleado;
import model.Usuario;
import util.ConexionBD;

public class UsuarioDao {

	private Connection connection;

	public UsuarioDao() {
		connection = ConexionBD.getConnection();
	}

	public Usuario validarLogin(String usuario, String contrasenia) {
		Usuario user = new Usuario();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM USUARIO WHERE USUARIO = ? AND CONTRASENIA = ?");
			preparedStatement.setString(1, usuario);
			preparedStatement.setString(2, contrasenia);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				user.setIdUsuario(rs.getInt(1));
				user.setUsuario(rs.getString(2));
				user.setContrasenia(rs.getString(3));
				user.setFechaDeAlta(rs.getDate(4));
				user.setFkEmpleado(rs.getInt(5));
				user.setFkGrupo(rs.getInt(6));
				user.setLider(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public int getUltimoId(){
		int resultado = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT COUNT(ID_USUARIO) FROM USUARIO");

			rs.next();
			resultado = rs.getInt(1) + 1;
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public boolean addUsuario(Usuario usuario){
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO USUARIO(ID_USUARIO,USUARIO,CONTRASENIA,FECHA_DE_ALTA,FK_EMPLEADO,FK_GRUPO,LIDER) values(?,?,?,?,?,?,?)");
			// Parameters start with 1
			preparedStatement.setInt(1, usuario.getIdUsuario());
			preparedStatement.setString(2, usuario.getUsuario());
			preparedStatement.setString(3, usuario.getContrasenia());
			preparedStatement.setDate(4, new java.sql.Date(usuario.getFechaDeAlta().getTime()));
			preparedStatement.setInt(5, usuario.getFkEmpleado());
			preparedStatement.setInt(6, usuario.getFkGrupo());
			preparedStatement.setString(7, usuario.getLider());
			preparedStatement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Usuario> obtenerUsuariosLider() {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT U.ID_USUARIO, "
					+ "E.NOMBRE ||' '|| E.APELLIDO_PATERNO ||' '|| E.APELLIDO_MATERNO "
					+ "FROM USUARIO U "
					+ "JOIN EMPLEADO E "
					+ "ON U.ID_USUARIO = E.ID_EMPLEADO "
					+ "WHERE U.LIDER = 'SI'");

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt(1));
				usuario.setUsuario(rs.getString(2));
				
				usuarios.add(usuario);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}
}
