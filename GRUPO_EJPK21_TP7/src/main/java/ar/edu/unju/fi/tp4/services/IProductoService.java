package ar.edu.unju.fi.tp4.services;

import java.util.List;

import ar.edu.unju.fi.tp4.models.Producto;

public interface IProductoService {
	
	/**
	 * Agrega un objeto de tipo Producto
	 * @param producto
	 */
	public void addProducto(Producto producto);
	
	/**
	 * Devuelve un objeto de tipo Producto
	 * @return
	 */
	public Producto getUltimoProducto();
	
	/**
	 * Devuelve el ultimo objeto del tipo producto de una lista
	 * @return
	 */
	public Producto getProducto();
	
	/**
	 *  Devuelve un objeto del tipo producto de una lista buscado por la variable codigo
	 * @param codigo
	 * @return
	 */
	public Producto findByCodigo(Long codigo);
	
	/**
	 * Genera una lista
	 */
	public void generarListProductos();
	/**
	 * Devuelve una lista con objetos del tipo Producto
	 * @return
	 */
	public List<Producto> getListProductos();
	
}
