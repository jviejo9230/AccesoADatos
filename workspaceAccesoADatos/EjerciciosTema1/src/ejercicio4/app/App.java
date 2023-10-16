package ejercicio4.app;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import ejercicio4.modelo.LineaPedido;
import ejercicio4.modelo.Pedido;
import ejercicio4.services.PedidosService;
import ejercicio4.services.PedidosServiceException;

public class App {

	
	public static void main(String[] args) {
		Pedido pedido = new Pedido();
		pedido.setFechaPedido(LocalDate.now());
		pedido.setFechaEntrega(LocalDate.of(2023, 12, 1));
		pedido.setCliente("Laura Salmerón");
		
		for (int j = 1; j <= 3; j++) {
			LineaPedido linea = new LineaPedido();
			linea.setArticulo("Artículo " + j);
			linea.setPrecio(new BigDecimal(938));
			pedido.getListaPedidos().add(linea);
		}
		
		PedidosService service = new PedidosService();
		try {
			service.crearPedido(pedido);
		} catch (PedidosServiceException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
