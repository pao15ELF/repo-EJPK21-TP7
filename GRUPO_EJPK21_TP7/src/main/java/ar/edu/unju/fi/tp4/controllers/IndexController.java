package ar.edu.unju.fi.tp4.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class IndexController {
	private static final Log LOGGER = LogFactory.getLog(IndexController.class);
	
	@GetMapping("/index")
	public String getIndexPage(){
		LOGGER.info("CONTROLLER: IndexController");
		LOGGER.info("METHOD: getIndexPage()");
		LOGGER.info("RESULT: visualiza la pagina principal index.html");
		return "index";
	}
}
