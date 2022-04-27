package com.autoescola.cliente.model;

import java.util.Calendar;

public class GeradorDeMatricula {
	public String gerador(long cpf) {
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String matricula = year + "200" + (cpf%100);
		
		
		return matricula;
	}
}
