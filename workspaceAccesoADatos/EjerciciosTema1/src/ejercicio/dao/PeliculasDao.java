package ejercicio.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicio.modelo.Peliculas;

public class PeliculasDao {

	public PeliculasDao() {
		
	}
	
	public List<Peliculas> devuelveListaPeliculas(Connection conn) throws SQLException {
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Peliculas> listaPeliculas = new ArrayList<Peliculas>();
			String sql = "select film_id, title, length from film";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Peliculas p = new Peliculas();
				p.setId(rs.getInt("film_id"));
				p.setTitulo(rs.getString("title"));
				p.setLongitud(rs.getInt("length"));
				listaPeliculas.add(p);
			}
			return listaPeliculas;
		}
		finally {
			try {
				stmt.close();
			}catch(Exception e) {}
		}
	}
}

