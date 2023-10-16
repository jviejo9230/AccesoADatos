package ceu.dam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ceu.dam.db.OpenConnection;
import ceu.dam.modelo.usuario;

public class usuarioDao {
	
	public Long insertarUsuario(Connection conn, usuario usuario) throws SQLException{
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(("insert into usuarios (email, password, nombre, apellidos, ciclo, activo) values (?, ?, ?, ?, ?, ?)"),Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getPassword());
			stmt.setString(3, usuario.getNombre());
			stmt.setString(4, usuario.getApellidos());
			stmt.setString(5, usuario.getCiclo());
			stmt.setBoolean(6, usuario.getActivo());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			return rs.getLong(1);
		}
		finally {
			try {
				stmt.close();
			}
			catch(Exception e) {
			}
		}
	}
	
	public usuario consultarUsuario(Connection conn, String email) throws SQLException {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		usuario u = new usuario();
		try {
			
			stmt = conn.prepareStatement(("select (email, password, nombre, apellidos, ciclo, activo) from usuarios where email= ?"),Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, email);

			rs = stmt.executeQuery();
			
			if(rs.next()){
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setNombre(rs.getString("nombre"));
				u.setApellidos(rs.getString("apellidos"));
				u.setCiclo(rs.getString("ciclo"));
				u.setActivo(rs.getBoolean("activo"));
				return u;
			}
			else {
				return null;
			}	
		}
			
		finally {
			try {
				stmt.close();
			}catch(Exception e) {}
		}
	}
	

}