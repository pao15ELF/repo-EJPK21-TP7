package ar.edu.unju.fi.tp4.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.models.Producto;
import ar.edu.unju.fi.tp4.repository.IProductoRepository;
import ar.edu.unju.fi.tp4.services.IProductoService;

@Service("productoServiceMysql")
public class ProductoServiceMySqlImp implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private List<Producto> productos;
	
	@Autowired
	private Producto producto;
	
	@Override
	public void addProducto(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public Producto getUltimoProducto() {
		List<Producto> productos = (List<Producto>) productoRepository.findAll();
		int tam = productos.size();
		producto = productos.get(tam-1);
		return producto;
	}

	@Override
	public Producto getProducto() {
		Producto producto = new Producto();
		return producto;
	}

	@Override
	public Optional<Producto> findById(Long id) {
		Optional<Producto> producto  = productoRepository.findById(id);
		return producto;
	}

	@Override
	public void generarListProductos() {
			
	}

	@Override
	public List<Producto> getListProductos() {
		List<Producto> productos = (List<Producto>) productoRepository.findAll();
		return productos;
	}

	@Override
	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);
	}

	@Override
	public List<Producto> getListProdByCompra(Long id) {
		List<Producto> productos = productoRepository.findByCompra(id);
		return productos;
	}

}
