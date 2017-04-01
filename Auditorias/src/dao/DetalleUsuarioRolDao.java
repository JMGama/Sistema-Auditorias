package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Rol;
import model.Usuario;
import util.ConexionBD;

public class DetalleUsuarioRolDao {

private Connection connection;
	
	public DetalleUsuarioRolDao(){
		connection = ConexionBD.getConnection();
	}
	
	public int getUltimoId(){
		int resultado = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT COUNT(ID_DETALLE_USUARIO_ROL) FROM DET_USUARIO_ROL");

			rs.next();
			resultado = rs.getInt(1) + 1;
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public boolean addDetalleUsuarioRol(Rol rol, Usuario usuario){
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO DET_USUARIO_ROL(ID_DETALLE_USUARIO_ROL,FK_USUARIO,FK_ROL) values (?,?,?)");
			// Parameters start with 1
			preparedStatement.setInt(1, getUltimoId());
			preparedStatement.setInt(2, usuario.getIdUsuario());
			preparedStatement.setInt(3, rol.getIdRol());
			preparedStatement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
