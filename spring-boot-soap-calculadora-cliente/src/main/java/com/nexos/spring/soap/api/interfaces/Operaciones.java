package com.nexos.spring.soap.api.interfaces;

import java.math.BigDecimal;

public interface Operaciones {
	
	BigDecimal operacion(String operacion, BigDecimal n1, BigDecimal n2);

}
