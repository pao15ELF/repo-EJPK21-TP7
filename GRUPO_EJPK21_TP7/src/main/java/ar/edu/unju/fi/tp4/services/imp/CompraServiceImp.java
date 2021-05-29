package ar.edu.unju.fi.tp4.services.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.models.Producto;
import ar.edu.unju.fi.tp4.models.Compra;
import ar.edu.unju.fi.tp4.services.ICompraService;
import ar.edu.unju.fi.tp4.services.IProductoService;
import ar.edu.unju.fi.tp4.util.TablaCompra;
@Service
public class CompraServiceImp implements ICompraService {

	private static final Log LOGGER = LogFactory.getLog(CompraServiceImp.class);
	@Autowired
	private IProductoService productoService;
	@Autowired
	private Compra compra;
	
	private List<Compra> compras;
	
	@Override
	public void addCompra(Compra compra) 
	{
		LOGGER.info("Service: ICompraService -> CompraServiceImp");
		LOGGER.info("Method: addCompra(Compra compra)");
		LOGGER.info("Result: agrega un objecto del tipo Compra a la lista de compras");
		if (compras==null)
		{
			generarListaCompra();
		}
		compras.add(compra);
		
	}

	@Override
	public List<Compra> getListCompras() 
	{
		LOGGER.info("Service: ICompraService -> CompraServiceImp");
		LOGGER.info("Method: getListCompras()");
		LOGGER.info("Result: devuelve la lista de compras");
		if (compras==null)
		{
			generarListaCompra();
		}
		
		return compras;
	}

	@Override
	public void generarListaCompra() 
	{
		LOGGER.info("Service: ICompraService -> CompraServiceImp");
		LOGGER.info("Method: generarListaCompra()");
		LOGGER.info("Result: genera la lista de compras");
		compras= TablaCompra.compras;
		//Producto producto = productoService.getUltimoProducto();
		int cantidad=6;
		Long id=1L;
		Compra compra =new Compra();
		compra.setCantidad(cantidad);
		//compra.setProducto(producto);
		compra.setId(id);
		//compra.setProductoCod(id);
		compras.add(compra);
	}

	@Override
	public Compra generarCompra() {
		LOGGER.info("Service: ICompraService -> CompraServiceImp");
		LOGGER.info("Method: generaCompra()");
		LOGGER.info("Result: genera un objeto Compra");
		Compra compra = new Compra();
		return compra;
	}

	
}
