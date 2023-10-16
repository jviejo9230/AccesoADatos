package ejercicio4.modelo;

import java.math.BigDecimal;

public class LineaPedido {

	private Long idPedido;
	private Integer numeroLinea;
	private String articulo;
	private BigDecimal precio;
	
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Integer getNumeroLinea() {
		return numeroLinea;
	}
	public void setNumeroLinea(Integer numeroLinea) {
		this.numeroLinea = numeroLinea;
	}
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "LineaPedido [idPedido=" + idPedido + ", numeroLinea=" + numeroLinea + ", articulo=" + articulo
				+ ", precio=" + precio + "]";
	}
	
	

}
