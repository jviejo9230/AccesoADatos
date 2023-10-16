package ceu.dam.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ceu.dam.dao.fechaDao;
import ceu.dam.db.OpenConnection;
import ceu.dam.modelo.fecha;

public class FechaService {


	private OpenConnection connProvider;
	
	public List<fecha> consultarFecha(){
		
		List<fecha> lista = new ArrayList<>();
		fechaDao fechaDao = new fechaDao();
		Connection conn = null;

		try {
			conn = connProvider.abrirConexion();
			Integer evaluacion = 0;
			if(LocalDate.now().getMonthValue()>= 9 && LocalDate.now().getMonthValue()<= 11) {
				evaluacion = 1;
			}
			else if(LocalDate.now().getMonthValue()>= 12 && LocalDate.now().getMonthValue()<= 2) {
				evaluacion = 2;
			}
			else if(LocalDate.now().getMonthValue()>= 3 && LocalDate.now().getMonthValue()<= 5) {
				evaluacion = 3;
			}
			
			lista = fechaDao.consultarFechas(conn, LocalDate.now().getYear(), evaluacion);
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
}
