package ar.edu.unju.fi.tp4.controllers;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.models.Compra;
import ar.edu.unju.fi.tp4.models.Producto;
import ar.edu.unju.fi.tp4.services.ICompraService;
import ar.edu.unju.fi.tp4.services.IProductoService;

@Controller
public class CompraController {
	private static final Log LOGGER = LogFactory.getLog(CompraController.class);
	
	@Autowired
	@Qualifier("compraServiceMysql")
	private ICompraService compraService;
	@Autowired
	@Qualifier("productoServiceMysql")
	private IProductoService productoService;
	
	@Autowired
	private Compra compra;
	@GetMapping("/compra/nuevo")
	public String getPageNuevaCompra(Model model) {
		LOGGER.info("CONTROLLER: CompraController");
		LOGGER.info("METHOD: getPageNuevaCompra()");
		LOGGER.info("RESULT: visualiza la pagina nuevocompra.html");
		model.addAttribute("nuevaCompra", compraService.generarCompra());
		model.addAttribute("productos", productoService.getListProductos());
		return "nuevacompra";
	}
	
	@PostMapping("/compra/guardar")
	public ModelAndView postGuardarNuevaCompra(@ModelAttribute("nuevaCompra") Compra nuevaCompra) {
		LOGGER.info("CONTROLLER: CompraController");
		LOGGER.info("METHOD: postGuardarNuevaCompra()");
		LOGGER.info("RESULT: carga los datos del formulario en la pagina nuevacompra.html y muestra la pagina compras.html");
		//Producto prod= productoService.findByCodigo(nuevaCompra.getProducto().getId());
		//nuevaCompra.setProducto(prod);
		compraService.addCompra(nuevaCompra);
		ModelAndView modelView= new ModelAndView("compras");
		modelView.addObject("compras",compraService.getListCompras());
		return modelView;
		
	}
	
	@GetMapping("/compra/listado")
	public ModelAndView getListaCompras() {
		LOGGER.info("CONTROLLER: CompraController");
		LOGGER.info("METHOD: getListCompras()");
		LOGGER.info("RESULT: visualiza la lista de compras en la pagina compras.html");
		ModelAndView modelView = new ModelAndView("compras");
		modelView.addObject("compras", compraService.getListCompras());
		return modelView;
		
	}
	
	/*@GetMapping("/compra/eliminar/{id}")
	public ModelAndView getEliminarCompraPage(@PathVariable(value = "id") Long id) {
		compraService.eliminarCompra(id);
		ModelAndView mav = new ModelAndView("redirect:/compra/listado");
		return mav ;
	}*/
	
	/*@GetMapping("/compra/editar/{id}")
	public ModelAndView getEditarCompraPage(@PathVariable(value = "id") Long id) {
		List<Producto> productos = productoService.getListProdByCompra(id);
		ModelAndView mav = new ModelAndView("nuevacompra");
		mav.addObject("nuevaCompra", compraService.findById(id) );
		mav.addObject("productos", productos);
		return mav;
	}*/
}
