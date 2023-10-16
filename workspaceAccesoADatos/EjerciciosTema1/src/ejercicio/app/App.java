package ejercicio.app;

import java.util.List;

import ejercicio.modelo.Peliculas;
import ejercicio.services.PeliculasServiceException;
import ejercicio.services.PeliculasServices;

public class App {

	public App() {
		
	}

	public static void main(String[] args) {
		
		PeliculasServices service = new PeliculasServices();
		List<Peliculas> peliculas;
		
		try {
			peliculas = service.consultarPeliculas();
			for (Peliculas p : peliculas) {
				System.out.println(p);
			}
		} catch (PeliculasServiceException e) {
			e.printStackTrace();
		}
	}
}
