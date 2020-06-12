package com.nexos.spring.soap.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.nexos.spring.soap.api.calculadora.CalculadoraRequest;
import com.nexos.spring.soap.api.calculadora.CalculadoraResponse;

@Service
public class SoapCliente {

	@Autowired
	private Jaxb2Marshaller marshaller;
	
	private WebServiceTemplate template;
	
	public CalculadoraResponse getResultado(CalculadoraRequest request) {
		template = new WebServiceTemplate(marshaller);
		CalculadoraResponse response = (CalculadoraResponse) template.marshalSendAndReceive("http://localhost:8080/ws", request);
		return response;
	}
}
