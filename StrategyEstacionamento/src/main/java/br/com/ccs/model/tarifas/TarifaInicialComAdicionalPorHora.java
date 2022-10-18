package br.com.ccs.model.tarifas;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class TarifaInicialComAdicionalPorHora implements CalculoTarifa {

    private final BigDecimal valorTarifaFixa;
    private final BigDecimal valorAdicional;
    private final int periodoInicial;

    public TarifaInicialComAdicionalPorHora(BigDecimal valorTarifaFixa, BigDecimal valorAdicional, int periodoInicial) {
        this.valorTarifaFixa = valorTarifaFixa;
        this.valorAdicional = valorAdicional;
        this.periodoInicial = periodoInicial;
    }

    @Override
    public BigDecimal calcular(Integer qtdHoras) {

        MathContext mc = new MathContext(3, RoundingMode.HALF_UP);

        if (qtdHoras <= periodoInicial) {
            return valorTarifaFixa;

        } else {
            qtdHoras -= periodoInicial;

            BigDecimal adicional = valorAdicional.multiply(BigDecimal.valueOf(qtdHoras));

            return adicional.add(valorTarifaFixa, mc);
        }
    }
}
