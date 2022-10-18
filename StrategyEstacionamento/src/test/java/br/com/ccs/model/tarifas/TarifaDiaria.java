package br.com.ccs.model.tarifas;

import java.math.BigDecimal;

public class TarifaDiaria implements CalculoTarifa {

    private final BigDecimal valorTarifaDiaria;

    public TarifaDiaria(BigDecimal valorTarifaDiaria) {
        this.valorTarifaDiaria = valorTarifaDiaria;
    }

    @Override
    public BigDecimal calcular(Integer qtdHoras) {

        int qtdDiarias = Math.divideExact(qtdHoras, 24);

        if (qtdHoras % 24 > 0) {
            qtdDiarias++;
        }

        return valorTarifaDiaria.multiply(BigDecimal.valueOf(qtdDiarias));
    }
}
