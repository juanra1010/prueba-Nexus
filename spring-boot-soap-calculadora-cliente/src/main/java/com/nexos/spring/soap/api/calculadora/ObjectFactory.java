//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.06.12 a las 04:11:36 AM COT 
//


package com.nexos.spring.soap.api.calculadora;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.nexos.spring.soap.api.calculadora package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.nexos.spring.soap.api.calculadora
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CalculadoraRequest }
     * 
     */
    public CalculadoraRequest createCalculadoraRequest() {
        return new CalculadoraRequest();
    }

    /**
     * Create an instance of {@link CalculadoraResponse }
     * 
     */
    public CalculadoraResponse createCalculadoraResponse() {
        return new CalculadoraResponse();
    }

}