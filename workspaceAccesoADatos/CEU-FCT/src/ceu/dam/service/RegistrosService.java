package ceu.dam.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ceu.dam.dao.registrosDao;
import ceu.dam.db.OpenConnection;
import ceu.dam.exception.FctException;
import ceu.dam.modelo.registro;

public class RegistrosService {
private OpenConnection connProvider;
	
	public List<registro> consultarRegistroUsuario(Long idUsuario) throws FctException{
		
		List<registro> lista = new ArrayList<>();
		registrosDao r = new registrosDao();
		Connection conn = null;

		try {
			conn = connProvider.abrirConexion();
			
			if(r.consultarRegistro(conn, idUsuario) == null) {
				throw new FctException();
			}
			else {
				return r.consultarRegistro(conn, idUsuario);
			}
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}catch(Exception e) {}
		}
		return lista;
	}
	
	public void crearRegistro(registro r) throws FctException {
		Connection conn = null;
		registrosDao rDao = new registrosDao();
		List<registro> lista = new ArrayList<>();
		
		try {
			conn = connProvider.abrirConexion();
			
			lista = rDao.consultarRegistroFecha(conn, r.getId_usuario(), r.getFecha());
			
			for (registro registro : lista) {
				if(registro.getId_usuario() == null && registro.getFecha()==null) {
					rDao.insertarRegistro(conn, r);
				}
				else {
					throw new FctException();
				}
			}
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}catch(Exception e) {}
		}
	}
}