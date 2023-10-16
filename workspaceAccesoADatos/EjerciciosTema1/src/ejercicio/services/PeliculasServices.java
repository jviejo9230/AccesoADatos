package ejercicio.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ejercicio.dao.PeliculasDao;
import ejercicio.modelo.Peliculas;

public class PeliculasServices {

	
	private OpenConnection openConnection;
	
	public PeliculasServices() {
		openConnection = new OpenConnection();
	}
	
	public List<Peliculas> consultarPeliculas() throws PeliculasServiceException{
		
		Connection conn = null;

		try {
			conn = openConnection.abrirConexion();
			PeliculasDao dao = new PeliculasDao();
			
			List<Peliculas> lista = dao.devuelveListaPeliculas(conn);
			
			Iterator<Peliculas> it = lista.iterator();
			while (it.hasNext()) {
				Peliculas p = (Peliculas) it.next();
				if(p.getLongitud() > 100) {
					it.remove();
				}
			}
			
			return lista;
		}
		catch(SQLException e) {
			System.err.println("Ha habido un error en la base de datos: " + e.getMessage());
			throw new PeliculasServiceException("Error al obtener actores de la bbdd", e);
			
		}
		finally {
			try {
				conn.close();
			}catch(Exception e) {}
		}
	
	
	}
}
