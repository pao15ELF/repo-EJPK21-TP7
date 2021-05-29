package ar.edu.unju.fi.tp4.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.models.Producto;
import ar.edu.unju.fi.tp4.services.IProductoService;
import ar.edu.unju.fi.tp4.util.TablaProducto;

@Service
public class ProductoServiceImp implements IProductoService {
	
	private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);
	
	@Autowired
	Producto producto;
	
	List<Producto> productos;
	@Override
	public void addProducto(Producto producto) {
		LOGGER.info("Service: IProductoService -> ProductoServiceImp");
		LOGGER.info("Method: addProducto()");
		LOGGER.info("Result: agrega un producto a la lista de productos");
		this.productos.add(producto);
		
	}

	@Override
	public Producto getUltimoProducto() {
		LOGGER.info("Service: IProductoService -> ProductoServiceImp");
		LOGGER.info("Method: getUltimoProducto()");
		LOGGER.info("Result: devuelve el ultimo producto agregado de la lista de productos");
		if (productos==null)
			generarListProductos();
		int indUltProd = productos.size() -1;
		Producto producto = productos.get(indUltProd);
		return producto;
	}

	@Override
	public Producto getProducto() {
		LOGGER.info("Service: IProductoService -> ProductoServiceImp");
		LOGGER.info("Method: getProducto()");
		LOGGER.info("Result: object Producto");
		//LOGGER.info("Se ha guardado un producto: "+getUltimoProducto());
		Producto producto= new Producto();
		return producto;
	}

	@Override
	public Producto findByCodigo(Long codigo) {
		LOGGER.info("Service: IProductoService -> ProductoServiceImp");
		LOGGER.info("Method: findByCodigo()");
		LOGGER.info("Result: devuelve un producto de la lista de productos buscado por su Codigo");
		Producto producto = new Producto();
		for (int i=0;i<getListProductos().size();i++) {
			if (codigo==getListProductos().get(i).getId()) {
				producto.setId(getListProductos().get(i).getId());
				producto.setMarca(getListProductos().get(i).getMarca());
				producto.setNombre(getListProductos().get(i).getNombre());
				producto.setPrecio(getListProductos().get(i).getPrecio());
				producto.setStock(getListProductos().get(i).getStock());
			}
		}
		return producto;
	}

	@Override
	public void generarListProductos() {
		LOGGER.info("Service: IProductoService -> ProductoServiceImp");
		LOGGER.info("Method: generarListProductos()");
		LOGGER.info("Result: genera la lista de productos");
		productos=TablaProducto.listaProductos;
		Producto producto = new Producto(10L,"Pasta Dental",250d,"Colgate",100);
		productos.add(producto);
		
	}

	@Override
	public List<Producto> getListProductos() {
		LOGGER.info("Service: IProductoService -> ProductoServiceImp");
		LOGGER.info("Method: getListProducto()");
		LOGGER.info("Result: devuelve la lista de productos");
		if (productos==null)
			generarListProductos();
		return productos;
	}
	
	
}
