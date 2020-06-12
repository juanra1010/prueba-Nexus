package com.nexos.spring.soap.api.services;

import com.nexos.spring.soap.api.calculadora.CalculadoraRequest;
import com.nexos.spring.soap.api.calculadora.CalculadoraResponse;
import com.nexos.spring.soap.api.service.CalculadoraService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

public class CalculadoraServiceTest {

    @Test
    public void resultadoCalculadoraParaSumaTest(){
        CalculadoraService calculadoraService = Mockito.spy(new CalculadoraService());
        CalculadoraRequest request = new CalculadoraRequest();
        BigDecimal resultadoEsperado = new BigDecimal(9.00).setScale(2);

        request.setN1(new BigDecimal(6));
        request.setN2(new BigDecimal(3));
        request.setOperacion("+");

        final CalculadoraResponse response = calculadoraService.resultadoCalculadora(request);

        assertTrue(response.getResultado().equals(resultadoEsperado));
    }

    @Test
    public void resultadoCalculadoraParaResta(){
        CalculadoraService calculadoraService = Mockito.spy(new CalculadoraService());
        CalculadoraRequest request = new CalculadoraRequest();
        BigDecimal resultadoEsperado = new BigDecimal(3.00).setScale(2);

        request.setN1(new BigDecimal(6));
        request.setN2(new BigDecimal(3));
        request.setOperacion("-");

        final CalculadoraResponse response = calculadoraService.resultadoCalculadora(request);

        assertTrue(response.getResultado().equals(resultadoEsperado));
    }

    @Test
    public void resultadoCalculadoraParaMultiplicacion(){
        CalculadoraService calculadoraService = Mockito.spy(new CalculadoraService());
        CalculadoraRequest request = new CalculadoraRequest();
        BigDecimal resultadoEsperado = new BigDecimal(18.00).setScale(2);

        request.setN1(new BigDecimal(6));
        request.setN2(new BigDecimal(3));
        request.setOperacion("*");

        final CalculadoraResponse response = calculadoraService.resultadoCalculadora(request);

        assertTrue(response.getResultado().equals(resultadoEsperado));
    }

    @Test
    public void resultadoCalculadoraParaDivision(){
        CalculadoraService calculadoraService = Mockito.spy(new CalculadoraService());
        CalculadoraRequest request = new CalculadoraRequest();
        BigDecimal resultadoEsperado = new BigDecimal(2.00).setScale(2);

        request.setN1(new BigDecimal(6));
        request.setN2(new BigDecimal(3));
        request.setOperacion("d");

        final CalculadoraResponse response = calculadoraService.resultadoCalculadora(request);

        assertTrue(response.getResultado().equals(resultadoEsperado));
    }
    
}
