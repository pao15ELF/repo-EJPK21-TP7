package ar.edu.unju.fi.tp4.services.imp;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.models.Cliente;
import ar.edu.unju.fi.tp4.services.IClienteService;
import ar.edu.unju.fi.tp4.util.TablaCliente;
@Service("clienteRamImp")
public class ClienteServiceImp implements IClienteService {
	private static final Log LOGGER = LogFactory.getLog(ClienteServiceImp.class);
	private List<Cliente> clientes = TablaCliente.clientes;
	
	
	@Override
	public void addCliente(Cliente cliente) {
		LOGGER.info("Service: IClienteService -> ClienteServiceImp");
		LOGGER.info("Method: addCliente()");
		LOGGER.info("Result: object Cliente");
		if (clientes == null) {
			generarListaClientes();
		}
		clientes.add(cliente);
	}

	@Override
	public List<Cliente> getClientes() {
		LOGGER.info("Service: IClienteService -> ClienteServiceImp");
		LOGGER.info("Method: addCliente()");
		LOGGER.info("Result: devuelve la lista de clientes");
		LOGGER.info("Se ha agregado un cliente: "+ clientes ); 
		return clientes;
	}

	@Override
	public void generarListaClientes() {
		
		//Cliente cliente = new Cliente ("DNI",41408725,"Estrada Ezequiel","choqooz@gmail.com","poronga",LocalDate.of(1998, 12, 1),388,4913726,LocalDate.of(2012,10,5));
		//clientes.add(cliente);
	}
	
}
