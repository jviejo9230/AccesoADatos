package ejercicio2.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejercicio2.dao.ClientesDao;
import ejercicio2.modelo.Cliente;

public class ClientesServices {

private OpenConnection openConnection;
	
	public ClientesServices() {
		openConnection = new OpenConnection();
	}
	
	public Map<String, Cliente> consultarClientes() throws ClientesServiceException{
		
		Connection conn = null;

		try {
			conn = openConnection.abrirConexion();
			ClientesDao dao = new ClientesDao();
			Map<String, Cliente> mapaClientes = new HashMap<>();
			List<Cliente> lista = dao.devuelveListaClientes(conn);
			
			for (Cliente l : lista) {
				mapaClientes.put(l.getEmail(), l);
			}
			
		return mapaClientes;
		
	}catch(SQLException e) {
		System.err.println("Ha habido un error en la base de datos: " + e.getMessage());
		throw new ClientesServiceException("Error al obtener actores de la bbdd", e);
		
	}
	finally {
		try {
			conn.close();
		}catch(Exception e) {}
	}
}
}