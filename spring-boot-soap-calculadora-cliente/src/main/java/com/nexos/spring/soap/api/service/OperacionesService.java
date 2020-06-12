package com.nexos.spring.soap.api.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.spring.soap.api.calculadora.CalculadoraRequest;
import com.nexos.spring.soap.api.calculadora.CalculadoraResponse;
import com.nexos.spring.soap.api.client.SoapCliente;
import com.nexos.spring.soap.api.interfaces.Operaciones;


@Service
public class OperacionesService implements Operaciones{

	@Autowired
	private SoapCliente cliente;	

	
	public static Logger logger = LoggerFactory.getLogger(OperacionesService.class);

	@Override
	public BigDecimal operacion(String operacion, BigDecimal n1, BigDecimal n2) {
		CalculadoraResponse response = new CalculadoraResponse();		
		CalculadoraRequest request = new CalculadoraRequest();

		
		request.setOperacion(operacion); 
		request.setN1(n1); 
		request.setN2(n2);
		response = cliente.getResultado(request);		
		BigDecimal resultado = response.getResultado();
		
		switch (operacion) {
		case "+":
				logger.info("Realizando una (Suma)");
				logger.info("numero1 = "+request.getN1()+" , numero2 = "+request.getN2());
				logger.info("el resultado de la Suma es: "+resultado);
			break;
			
		case "-":
				logger.info("Realizando una (Resta)");
				logger.info("numero1 = "+request.getN1()+" , numero2 = "+request.getN2());
				logger.info("el resultado de la Resta es: "+resultado);
			break;
			
		case "*":
				logger.info("Realizando una (Multiplicacion)");
				logger.info("numero1 = "+request.getN1()+" , numero2 = "+request.getN2());
				logger.info("el resultado de la Multiplicacion es: "+resultado);	
			break;
					
		case "d":
				logger.info("Realizando una (Division)");
				logger.info("numero1 = "+request.getN1()+" , numero2 = "+request.getN2());
				logger.info("el resultado de la Division es: "+resultado);
				if (!response.isEstado()) {
					logger.info(response.getMensaje());
				}
			break;

		default:
				logger.info(response.getMensaje());
			break;
		}	
		
		return resultado;
	}
		
}
