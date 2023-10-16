package ejercicio4.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import ejercicio4.dao.LineasDao;
import ejercicio4.dao.PedidosDao;
import ejercicio4.modelo.LineaPedido;
import ejercicio4.modelo.Pedido;

public class PedidosService {

	private OpenConnection connProvider;
	
	public PedidosService() {
		connProvider = new OpenConnection();
	}
	
	public void crearPedido(Pedido pedido) throws PedidosServiceException {
		PedidosDao daoPedido = new PedidosDao();
		LineasDao daoLinea = new LineasDao();
		Connection conn = null;
		try {
			conn = connProvider.abrirConexion();
			conn.setAutoCommit(false);
			// 1. Insertar los datos de la tabla pedido (los datos principales)
			
			Long idPedidoGenerado = daoPedido.insertarPedidos(conn, pedido);
			// 2. Recorrer todas las líneas del pedido (pedido.getLineas()) ...for..
			
			List<LineaPedido> lineas = pedido.getListaPedidos();
			int numLinea = 1;
			for (LineaPedido linea : lineas) {
				// 3. Para cada línea --> Insertar la línea en tabla pedidos_lineas
				
				linea.setIdPedido(idPedidoGenerado);
				linea.setNumeroLinea(numLinea);
				daoLinea.insertarLineaPedidos(conn, linea);
				numLinea++;
			}
			conn.commit();
		}
		catch(SQLException e) {
			System.err.println("Error al registrar pedido");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.err.println("No se ha podido hacer rollback");
			}
			throw new PedidosServiceException("Error al registrar pedido", e);
		}
		finally {
			try {
				conn.close();
			}catch(Exception ignore) {}
		}
	}
	
}
