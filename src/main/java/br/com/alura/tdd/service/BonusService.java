package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {
	private BigDecimal valor;

	public BigDecimal calcularBonus(Funcionario funcionario) {
		this.valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1001")) > 0) {
			throw new IllegalArgumentException("Funcionários com salário superior a R$10.000 não podem receber bônus");
		}

		arredondar();
		return valor;
	}

	private void arredondar() {
		this.valor = valor.setScale(2, RoundingMode.HALF_UP);
	}
}
