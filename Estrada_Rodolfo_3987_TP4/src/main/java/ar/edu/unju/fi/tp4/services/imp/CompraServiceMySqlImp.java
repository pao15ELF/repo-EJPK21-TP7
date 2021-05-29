package ar.edu.unju.fi.tp4.services.imp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.models.Compra;
import ar.edu.unju.fi.tp4.repository.ICompraRepository;
import ar.edu.unju.fi.tp4.services.ICompraService;
@Service("compraServiceMysql")
public class CompraServiceMySqlImp implements ICompraService{

	@Autowired
	private ICompraRepository compraRepository;
	@Autowired
	private Compra compra;
	@Override
	public void addCompra(Compra compra) {
		compraRepository.save(compra);
	}

	@Override
	public List<Compra> getListCompras() {
		List<Compra> compras = (List<Compra>) compraRepository.findAll();
		return compras;
	}

	@Override
	public void generarListaCompra() {
		
	}

	@Override
	public Compra generarCompra() {
		
		return compra;
	}

	@Override
	public void eliminarCompra(Long id) {
		compraRepository.deleteById(id);
		
	}

	@Override
	public Optional<Compra> findById(Long id) {
		Optional<Compra> compra = compraRepository.findById(id);
		return compra;
	}

}
