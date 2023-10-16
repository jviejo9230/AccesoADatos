package ceu.dam.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ceu.dam.modelo.registro;
import ceu.dam.modelo.usuario;


public class registrosDao {
	
public List<registro> consultarRegistro(Connection conn, Long idUsuario) throws SQLException {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<registro> listaRegistros = new ArrayList<>();
		usuario u = new usuario();
		try {
			
			stmt = conn.prepareStatement("select * from registros where id_usuario= ?");

			stmt.setLong(1, idUsuario);

			rs = stmt.executeQuery();
			
			if(rs.next()){
				registro r = new registro();
				r.setId_registro(rs.getLong("id_registro"));
				r.setId_usuario(rs.getLong("id_usuario"));
				r.setFecha(rs.getDate("fecha").toLocalDate());
				r.setNum_horas(rs.getBigDecimal("num_horas"));
				r.setDescripcion(rs.getString("descripcion"));
				
				listaRegistros.add(r);
				return listaRegistros;
			}
			else {
				return null;
			}	
		}
			
		finally {
			try {
				stmt.close();
			}catch(Exception e) {}
		}
	}

	public List<registro> consultarRegistroFecha(Connection conn, Long idUsuario, LocalDate fecha) throws SQLException {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<registro> listaRegistros = new ArrayList<>();
		usuario u = new usuario();
		try {
			
			stmt = conn.prepareStatement("select * from registros where id_usuario= ? and fecha = ?");

			stmt.setLong(1, idUsuario);
			stmt.setDate(2, Date.valueOf(fecha));

			rs = stmt.executeQuery();
			
			while(rs.next()){
				registro r = new registro();
				r.setId_registro(rs.getLong("id_registro"));
				r.setId_usuario(rs.getLong("id_usuario"));
				r.setFecha(rs.getDate("fecha").toLocalDate());
				r.setNum_horas(rs.getBigDecimal("num_horas"));
				r.setDescripcion(rs.getString("descripcion"));
				
				listaRegistros.add(r);
				
			}
			return listaRegistros;
		}
			
		finally {
			try {
				stmt.close();
			}catch(Exception e) {}
	}
	}

	public void insertarRegistro(Connection conn, registro r) throws SQLException {
		
		PreparedStatement stmt = null;
		
		try {
			String sql = "insert into registros (id_registro, id_usuario, fecha) values (?,?,?)";
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, r.getId_registro());
			stmt.setLong(2, r.getId_usuario());
			stmt.setDate(3, Date.valueOf(r.getFecha()));
			stmt.setBigDecimal(4, r.getNum_horas());
			stmt.setString(5, r.getDescripcion());
			
			stmt.execute();
		}
		finally {
			try {
				stmt.close();
			}catch(Exception ignore) {}
		}
	}







}
