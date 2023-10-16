package ceu.dam.app;

import ceu.dam.exception.AutenticationException;
import ceu.dam.exception.FctException;
import ceu.dam.modelo.usuario;
import ceu.dam.service.FechaService;
import ceu.dam.service.UsuarioService;
import ceu.dam.service.RegistrosService;

public class app {

	public static void main(String[] args) throws AutenticationException, FctException {
		
		UsuarioService service = new UsuarioService();
		usuario u = new usuario();
		RegistrosService rS = new RegistrosService();
		try {
			
			FechaService fecha = new FechaService();
			System.out.println(fecha.consultarFecha());
			
			
			u.setEmail("jvb");
			u.setPassword("1234");
			u.setNombre("jesus");
			u.setApellidos("viejo");
			u.setCiclo("DAM");
			u.setActivo(true);
			
			service.altaUsuario(u);
			
			
		
		} catch (AutenticationException e) {
			e.printStackTrace();
		}
			
	}
}
