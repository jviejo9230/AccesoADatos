package ceu.dam.service;

import java.sql.Connection;
import java.sql.SQLException;

import ceu.dam.dao.usuarioDao;
import ceu.dam.db.OpenConnection;
import ceu.dam.exception.AutenticationException;
import ceu.dam.exception.FctException;
import ceu.dam.modelo.usuario;

public class UsuarioService {

private OpenConnection connProvider;


	public UsuarioService() {
		connProvider = new OpenConnection();
	}
	
	public usuario login(String email, String password) throws AutenticationException, FctException {

		usuarioDao daoUsuario = new usuarioDao();
		Connection conn = null;

		try {
			conn = connProvider.abrirConexion();
			
			if(daoUsuario.consultarUsuario(conn, email) == null) {
				throw new AutenticationException("El email no existe");
			}
			
			else if(!daoUsuario.consultarUsuario(conn, email).getPassword().equals(password)) {
				throw new AutenticationException("La contraseña no es correcta");
			}
			else {
				return daoUsuario.consultarUsuario(conn, email);
			}
		}
		catch(SQLException e) {
			System.err.println("No existe ningun usuario");
			throw new FctException("Error al autentiticar el cliente", e);
		}
		finally {
			try {
				conn.close();
			}catch(Exception e) {}
		}
	}
	
	
	public void altaUsuario(usuario usuario) throws AutenticationException, FctException {
		
		usuarioDao daoUsuario = new usuarioDao();
		Connection conn = null;
		
		try {
			conn = connProvider.abrirConexion();
			
			if(daoUsuario.consultarUsuario(conn, usuario.getEmail()) != null) {
				throw new AutenticationException("El usuario ya existe");
			}
			else {
				daoUsuario.insertarUsuario(conn, usuario);
			}		
		}
		catch(SQLException e) {
			throw new FctException("Error al crear el cliente", e);
		}
		finally {
			try {
				conn.close();
			}catch(Exception e) {}
	}

}
	
	
}
