package ar.edu.unju.fi.tp4.services;

import java.util.List;

import ar.edu.unju.fi.tp4.models.Cliente;

public interface IClienteService {
	/**
	 * Agrega un objeto del tipo Cliente
	 * @param cliente
	 */
	public void addCliente(Cliente cliente);
	/**
	 * Devuelve una lista con objetos de tipo  Cliente
	 * @return
	 */
	public List<Cliente> getClientes();
	/**
	 * Genera la lista de clientes
	 */
	public void generarListaClientes();
}
