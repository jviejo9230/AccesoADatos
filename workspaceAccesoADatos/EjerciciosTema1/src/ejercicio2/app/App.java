package ejercicio2.app;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import ejercicio2.modelo.Cliente;
import ejercicio2.services.ClientesServiceException;
import ejercicio2.services.ClientesServices;

public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}
	
public static void main(String[] args) {
		
		ClientesServices service = new ClientesServices();
		Map<String, Cliente> cliente;
		
		try {
			cliente = service.consultarClientes();
			
			Set<Entry<String, Cliente>> pares = cliente.entrySet();
			
			for (Entry<String, Cliente> p : pares) {
				if(p.getKey().equals("MARILYN.ROSS@sakilacustomer.org")) {
					System.out.println(p);
				}
			}
		} catch (ClientesServiceException e) {
			e.printStackTrace();
		}
	}
}
