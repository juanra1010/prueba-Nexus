package com.nexos.spring.soap.api.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService{

	@Autowired
	OperacionesService operacionesService;
	
	public static Logger logger = LoggerFactory.getLogger(CalculadoraService.class);
	
	public String calcularAreaTriangulo(BigDecimal base, BigDecimal altura) {
		logger.info("calculando --> AREA TRIANGULO");
		BigDecimal areaTriangulo;
		areaTriangulo = operacionesService.operacion("*", base, altura);
		areaTriangulo = operacionesService.operacion("d", areaTriangulo, new BigDecimal(2)) ;
		String area = "Resultado --> A = (base * altura)/2 , con base="+base+" y altura="+altura+", el area de el triangulo es : "+areaTriangulo;
		logger.info(area);
		return area;
	}
	
	public String CalcularAreaCirculo(BigDecimal radio) {
		logger.info("calculando --> AREA CIRCULO");
		BigDecimal pi = new BigDecimal(Math.PI).setScale(2, RoundingMode.HALF_UP);
		BigDecimal areaCirculo, radioCirculo;
		radioCirculo = operacionesService.operacion("*", radio, radio);
		areaCirculo = operacionesService.operacion("*", pi, radioCirculo) ;
		String area = "Resultado --> A = π*(r*r) , con radio = "+radio+", el Area del circulo es : "+pi+"*"+radioCirculo+" = "+ areaCirculo;
		logger.info(area);
		return area;
	}
	
	public String calcularPromedio(BigDecimal n1, BigDecimal n2) {
		logger.info("calculando --> PROMEDIO");
		BigDecimal sumatoria, promedio;
		sumatoria = operacionesService.operacion("+", n1, n2);
		promedio = operacionesService.operacion("d", sumatoria,  new BigDecimal(2)) ;
		String promedioString = "Resultado --> Promedio de "+n1+" y "+n2+" es : "+ promedio;
		logger.info(promedioString);
		return promedioString;
	}
	
	
	public String calcularPendiente(BigDecimal x1, BigDecimal y1, BigDecimal x2, BigDecimal y2) {
		logger.info("calculando --> PENDIENTE");
		BigDecimal cambioY, cambioX, pendiente;
		cambioY = operacionesService.operacion("-", y2, y1);
		cambioX= operacionesService.operacion("-", x2, x1);
		pendiente = operacionesService.operacion("d", cambioY, cambioX) ;
		String pendienteString;
		if (pendiente == null) {
			pendienteString = "cuando y1 != y2  y ademas x1 = x2 la pendiente tiende a infinito";
		}else {		
			pendienteString = "Resultado --> En los puntos p1("+x1+","+y1+")"+" y p2("+x2+","+y2+") del plano, la pendiente es : "+pendiente;
		}
		logger.info(pendienteString);		
		return pendienteString;
	}
}
