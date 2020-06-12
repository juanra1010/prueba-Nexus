package com.nexos.spring.soap.api.controller;

import java.math.BigDecimal;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.spring.soap.api.service.CalculadoraService;
import com.nexos.spring.soap.api.service.OperacionesService;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
  
	@Autowired
	CalculadoraService service;
	
	@Autowired
	OperacionesService operacionService;

	public static Logger logger = LoggerFactory.getLogger(CalculadoraController.class);
	
	@GetMapping("/operacion/{operacion}/{n1}/{n2}")
	public BigDecimal suma(  @PathVariable("operacion") String operacion,
							 @PathVariable("n1") BigDecimal n1,
							 @PathVariable("n2") BigDecimal n2) {
		
		logger.info("Iniciando Operacion");
		logger.info("Operador "+operacion+", con n1 = "+n1+" y con n2 = "+n2);
		return operacionService.operacion(operacion, n1, n2);
	}	
	
	//---formulas---//
	
	@GetMapping("formula/area-triangulo/{base}/{altura}")
	public String areaTriangulo(@PathVariable("base") BigDecimal base,
							 	@PathVariable("altura") BigDecimal altura) {
		logger.info("Solicitud --> AREA TRIANGULO");
		logger.info("la base es "+base+" y la altura es "+altura);
		return service.calcularAreaTriangulo(base, altura);
	}
	
	
	@GetMapping("/formula/area-circulo/{radio}")
	public String AreaCirculo(@PathVariable("radio") BigDecimal radio) {
		
		logger.info("Solicitud --> AREA CIRCULO");
		logger.info("el radio es "+radio);
		return service.CalcularAreaCirculo(radio);
	}
	
	@GetMapping("/formula/promedio/{n1}/{n2}")
	public String promedio(@PathVariable("n1") BigDecimal n1,
						   @PathVariable("n2") BigDecimal n2) {
		
		logger.info("Solicitud --> PROMEDIO");
		logger.info("el n1 es"+n1+" y n2 es "+n2);
		return service.calcularPromedio(n1, n2);
	}
	
	@GetMapping("/formula/pendiente-de-recta/{x1}/{y1}/{x2}/{y2}")
	public String pendiente(@PathVariable("x1") BigDecimal x1,
							   @PathVariable("y1") BigDecimal y1,
							   @PathVariable("x2") BigDecimal x2,
							   @PathVariable("y2") BigDecimal y2) {
		
		logger.info("Solicitud --> PENDIENTE");
		logger.info("puntos del plano: p1("+x1+","+y1+")"+" y p2("+x2+","+y2+")");
		return service.calcularPendiente(x1, y1, x2, y2);
	}	
}
