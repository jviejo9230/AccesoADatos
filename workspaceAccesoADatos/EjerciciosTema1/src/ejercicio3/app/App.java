package ejercicio3.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import ejercicio3.modelo.Pago;
import ejercicio3.services.PagoServices;
import ejercicio3.services.PagosServiceException;

public class App {

	
public static void main(String[] args) throws SQLException {
		
		PagoServices service = new PagoServices();
		Map<String, List<Pago>> lista;
		
		try {
			lista = service.consultarListaPagos();
			
			List<Pago> listaPagos = lista.get("MARILYN.ROSS@sakilacustomer.org");
			
			for (Pago pago : listaPagos) {
				System.out.println(listaPagos);
			}
			
			

		} catch (PagosServiceException e) {
			e.printStackTrace();
		}
	}
}
