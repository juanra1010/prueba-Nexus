package com.nexos.spring.soap.api.service;

import java.math.BigDecimal;
import java.math.RoundingMode;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nexos.spring.soap.api.calculadora.CalculadoraRequest;
import com.nexos.spring.soap.api.calculadora.CalculadoraResponse;


@Service
public class CalculadoraService {

	public static Logger logger = LoggerFactory.getLogger(CalculadoraService.class);
	
	public CalculadoraResponse resultadoCalculadora(CalculadoraRequest request) {
		logger.info("numero1 = "+request.getN1()+" , numero2 = "+request.getN2());
		CalculadoraResponse response = new CalculadoraResponse();
		response.setEstado(true);
		BigDecimal resultado = new BigDecimal(0);
		
		
		switch (request.getOperacion()) {
			case "+":
					logger.info("Operacion Suma");
					resultado = request.getN1().add(request.getN2()).setScale(2);
				break;
				
		
			case "-":
					logger.info("Operacion Resta");
					resultado = request.getN1().subtract(request.getN2()).setScale(2);
				break;
			
			
			
			case "*":
					logger.info("Operacion Multiplicacion");
					resultado = request.getN1().multiply(request.getN2()).setScale(2);
				break;
				
				
			case "d":
					try {
						 if (request.getN2() != new BigDecimal(0)) {
							logger.info("Operacion Division");
							resultado = request.getN1().divide(request.getN2(), 2, RoundingMode.HALF_UP);
						}
					} catch (Exception e) {
						response.setEstado(false);
						resultado = null;
					    response.setMensaje("La Division po cero no esta permitida");
					    logger.info(response.getMensaje());
					}
				break;			

			default:
					response.setEstado(false);
					response.setMensaje("operador invalido : "+ request.getOperacion()+", los unicos operadore Validos son (+, -, *, d)");
					logger.info(response.getMensaje());
					
				break;
		}
		
		response.setResultado(resultado);
		logger.info("Resultado : "+ response.getResultado());
		return response;
		
	}
}
