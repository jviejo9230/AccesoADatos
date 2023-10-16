package ceu.dam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ceu.dam.modelo.fecha;
import ceu.dam.modelo.usuario;

public class fechaDao {

	public fechaDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<fecha> consultarFechas(Connection conn, Integer anyo, Integer evaluacion) throws SQLException{
		
		List<fecha> lista= new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		fecha fecha = new fecha();
		
		usuario u = new usuario();
		try {
			
			stmt = conn.prepareStatement("select * from fechas where anyo = ? and evaluacion = ?");

			stmt.setInt(1, anyo);
			stmt.setInt(2, evaluacion);

			rs = stmt.executeQuery();
			while(rs.next()) {
				fecha.setFecha(rs.getDate("fecha").toLocalDate());
				fecha.setAño(rs.getInt("año"));
				fecha.setEvaluacion(rs.getInt("evaluacion"));
				fecha.setDisponibilidad(rs.getBoolean("disponibilidad"));
				
				lista.add(fecha);
			}
			
	
			return lista;
		}
			
		finally {
			try {
				stmt.close();
			}catch(Exception e) {}
		}
	}
	
	
	
	
}
