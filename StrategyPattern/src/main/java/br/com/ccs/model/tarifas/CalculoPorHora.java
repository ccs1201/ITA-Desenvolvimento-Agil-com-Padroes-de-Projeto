package br.com.ccs.model.tarifas;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CalculoPorHora implements CalculoTarifa {

    private BigDecimal valorHora;

    public CalculoPorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public BigDecimal calcular(Integer qtdHoras) {

        MathContext mc = new MathContext(3, RoundingMode.HALF_UP);

        return valorHora.multiply(BigDecimal.valueOf(qtdHoras), mc);
    }
}
