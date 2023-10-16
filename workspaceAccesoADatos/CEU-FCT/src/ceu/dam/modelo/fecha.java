package ceu.dam.modelo;

import java.time.LocalDate;

public class fecha {

	private LocalDate fecha;
	private Integer año;
	private Integer evaluacion;
	private Boolean disponibilidad;
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Integer getAño() {
		return año;
	}
	public void setAño(Integer año) {
		this.año = año;
	}
	public Integer getEvaluacion() {
		return evaluacion;
	}
	public void setEvaluacion(Integer evaluacion) {
		this.evaluacion = evaluacion;
	}
	public Boolean getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(Boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	@Override
	public String toString() {
		return "fecha [fecha=" + fecha + ", año=" + año + ", evaluacion=" + evaluacion + ", disponibilidad="
				+ disponibilidad + "]";
	}
	
	
	
	
}
