package ejercicio.modelo;

public class Peliculas {

	public Peliculas() {
		
	}
	
	private Integer id;
	private String titulo;
	private Integer longitud;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getLongitud() {
		return longitud;
	}
	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}
	@Override
	public String toString() {
		return "Peliculas [id=" + id + ", titulo=" + titulo + ", longitud=" + longitud + "]";
	}
	
	

}
