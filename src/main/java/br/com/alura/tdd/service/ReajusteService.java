package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReajusteService {
    public void calcularReajuste(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal percentual = desempenho.percentualReajuste();
        BigDecimal valor = funcionario.getSalario().multiply(percentual);
        funcionario.reajustarSalario(funcionario.getSalario().add(valor.setScale(2, RoundingMode.HALF_UP)));
    }
}
