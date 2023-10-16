package ceu.dam.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class registro {

	private Long id_registro;
	private Long id_usuario;
	private LocalDate fecha;
	private BigDecimal num_horas;
	private String descripcion;
	
	public Long getId_registro() {
		return id_registro;
	}
	public void setId_registro(Long id_registro) {
		this.id_registro = id_registro;
	}
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getNum_horas() {
		return num_horas;
	}
	public void setNum_horas(BigDecimal num_horas) {
		this.num_horas = num_horas;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "registro [id_registro=" + id_registro + ", id_usuario=" + id_usuario + ", fecha=" + fecha
				+ ", num_horas=" + num_horas + ", descripcion=" + descripcion + "]";
	}
	
	

}
