package ceu.dam.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OpenConnection {

	public Connection abrirConexion() throws SQLException {
		String url = "jdbc:mariadb://localhost:3306/CEU-FCT";
		String driver = "org.mariadb.jdbc.Driver";
		String user = "CEU-FCT";
		String pass = "CEU-FCT";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.err.println("No se encuentra la clase del driver. Revisa tu configuración");
			throw new RuntimeException("No se encuentra clase del driver", e);
		}
		return DriverManager.getConnection(url, user, pass);
	}

}
