package ar.edu.unju.fi.tp4.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.models.Cliente;
import ar.edu.unju.fi.tp4.repository.IClienteRepository;
import ar.edu.unju.fi.tp4.services.IClienteService;

@Service("clienteServiceMysql")
public class ClienteServiceMySqlImp implements IClienteService {

	
	@Autowired
	private IClienteRepository clienteRepository;
	@Autowired
	private Cliente cliente;
	@Override
	public void addCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

	@Override
	public List<Cliente> getClientes() {
		List<Cliente>clientes = (List<Cliente>) clienteRepository.findAll();
		return clientes;
	}

	@Override
	public void generarListaClientes() {
		//	
	}

	@Override
	public Cliente getCliente() {
		
		return cliente;
	}

	@Override
	public Optional<Cliente> getClientePorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente;
	}

	@Override
	public void eliminarCliente(Long id) {
		clienteRepository.deleteById(id);
		
	}

}
