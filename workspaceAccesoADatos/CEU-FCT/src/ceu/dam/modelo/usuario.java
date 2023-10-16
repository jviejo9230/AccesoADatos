package ceu.dam.modelo;

import java.math.BigDecimal;

public class usuario {

	private Long id_usuario;
	private String email;
	private String password;
	private String nombre;
	private String apellidos;
	private String ciclo;
	private Boolean activo;
	
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	@Override
	public String toString() {
		return "usuario [id_usuario=" + id_usuario + ", email=" + email + ", password=" + password + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", ciclo=" + ciclo + ", activo=" + activo + "]";
	}

	
}
