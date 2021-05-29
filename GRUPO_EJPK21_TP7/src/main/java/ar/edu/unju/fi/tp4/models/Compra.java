package ar.edu.unju.fi.tp4.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "COMPRAS")
public class Compra {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy= "compra")
	private List<Producto> productos;
	
	@Column(name = "com_cantidad" , nullable = false)
	private int cantidad;
	@Column(name = "com_total" , nullable = false)
	private double total;
	
	
	public Compra() {
		//
	}
	
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the producto
	 */
	public List<Producto> getProductos() {
		return productos;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getTotal() {
		//total=producto.getPrecio()*this.cantidad;
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}



	@Override
	public String toString() {
		return "Compra [id=" + id + ", productos=" + productos + ", cantidad=" + cantidad + ", total=" + total + "]";
	}
	
	
	
}
