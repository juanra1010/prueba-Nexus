package com.nexos.spring.soap.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.nexos.spring.soap.api.calculadora.CalculadoraRequest;
import com.nexos.spring.soap.api.calculadora.CalculadoraResponse;
import com.nexos.spring.soap.api.service.CalculadoraService;

@Endpoint
public class CalculadoraResultadoEndpoint {

private static final String NAMESPACE = "http://www.nexos.com/spring/soap/api/calculadora";
	
	@Autowired
	private CalculadoraService service;
	
	@PayloadRoot(namespace =  NAMESPACE, localPart = "CalculadoraRequest")
	@ResponsePayload
	public CalculadoraResponse getLoanStatus(@RequestPayload CalculadoraRequest request) {
		return service.resultadoCalculadora(request);
	}
}
