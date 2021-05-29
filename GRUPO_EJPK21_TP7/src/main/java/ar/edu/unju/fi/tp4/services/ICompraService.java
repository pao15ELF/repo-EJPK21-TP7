package ar.edu.unju.fi.tp4.services;

import java.util.List;

import ar.edu.unju.fi.tp4.models.Compra;

public interface ICompraService {
	
	/**
	 * Agrega un objeto del tipo Compra
	 * @param compra
	 */
	public void addCompra(Compra compra);

	/**
	 * Obtiene una lista de objetos de tipo Compra
	 * @return
	 */
	public List<Compra> getListCompras();
	
	/**
	 * Genera una lista de Compra
	 */
	public void generarListaCompra();
	
	/**
	 * Genera un objeto del tipo Compra
	 * @return
	 */
	public Compra generarCompra();

}
