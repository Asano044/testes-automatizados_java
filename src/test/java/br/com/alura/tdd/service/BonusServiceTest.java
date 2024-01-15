package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    private BonusService service;

    @BeforeEach
    public void incializar() {
        this.service = new BonusService();
    }

    @Test
    void bonusDeveriaRetornarZeroCasoSalarioSejaMaiorQue10000() {
        assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario(
                "Alvaro", LocalDate.now(), new BigDecimal("25000")
                )));
    }

    @Test
    void bonusDeveriaRetornarDezPorCentoDoSalarioQueForInferiorA10000() {
        BigDecimal bonus = service.calcularBonus(new Funcionario(
                "Alvaro",
                LocalDate.now(),
                new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaRetornarDezPorCentoDoSalarioQueForIgualA10000() {
        BigDecimal bonus = service.calcularBonus(new Funcionario(
                "Alvaro",
                LocalDate.now(),
                new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
