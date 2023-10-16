package ejercicio3.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejercicio2.dao.ClientesDao;
import ejercicio2.modelo.Cliente;
import ejercicio3.dao.PagosDao;
import ejercicio3.modelo.Pago;

public class PagoServices {

	
	
	public Map<String, List<Pago>> consultarListaPagos() throws PagosServiceException, SQLException{
		Connection conn = null;
		
		try {
		
			conn= new OpenConnection().abrirConexion();
			
			Map<String, List<Pago>> mapa = new HashMap<>();
			
			List<Cliente> listaClientes = new ArrayList<>();
			
			ClientesDao clientesDao = new ClientesDao();
			listaClientes = clientesDao.devuelveListaClientes(conn);
			
			PagosDao pagosDaoVar = new PagosDao();
		
		
		for (Cliente c : listaClientes) {
			List<Pago> listaPago = pagosDaoVar.devuelveListaPagos(conn, c.getId());
			mapa.put(c.getEmail(), listaPago);
		}
		
		return mapa;
		}
		finally {
			try {
				conn.close();
			}catch(SQLException e) {
				System.err.println("Ha habido un error en la base de datos: " + e.getMessage());
				throw new PagosServiceException("Error al obtener actores de la bbdd", e);
			}
		}
		
		
		

	}
}