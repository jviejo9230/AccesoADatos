package ejercicio4.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import ejercicio4.modelo.LineaPedido;

public class LineasDao {

	public LineasDao() {
	}
	
public void insertarLineaPedidos(Connection conn, LineaPedido lp) throws SQLException {
		
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement("insert into pedidos_lineas values (?, ?, ?, ?)");
			stmt.setLong(1, lp.getIdPedido());

			stmt.setInt(2, lp.getNumeroLinea());
			stmt.setString(3, lp.getArticulo());
			stmt.setBigDecimal(4, lp.getPrecio());
			
			stmt.execute();
		}
		finally {
			try {
				stmt.close();
			}
			catch(Exception e) {
			}
		}
	
	}
}
