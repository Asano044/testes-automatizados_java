package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void incializar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Asano", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    void salarioDeveriaTerReajusteDeTresPorCentoCasoDesempenhoSejaADesejar() {
        service.calcularReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void salarioDeveriaTerReajusteDeQuinzePorCentoCasoDesempenhoSejaBom() {
        service.calcularReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void salarioDeveriaTerReajusteDeVintePorCentoCasoDesempenhoSejaOtimo() {
        service.calcularReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
