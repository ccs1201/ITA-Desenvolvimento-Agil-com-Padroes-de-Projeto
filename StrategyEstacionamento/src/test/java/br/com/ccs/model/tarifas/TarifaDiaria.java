package br.com.ccs.model.tarifas;

import java.math.BigDecimal;

public class TarifaDiaria implements CalculoTarifa {

    private final BigDecimal valorTarifaDiaria;

    public TarifaDiaria(BigDecimal valorTarifaDiaria) {
        this.valorTarifaDiaria = valorTarifaDiaria;
    }

    @Override
    public BigDecimal calcular(Integer qtdHoras) {

        int qtdDiarias;

        if (qtdHoras <= 24) {
            qtdDiarias = 1;
        } else {
            qtdDiarias = calcularDiarias(qtdHoras) + 1;
        }

        return valorTarifaDiaria.multiply(BigDecimal.valueOf(qtdDiarias));
    }

    private int calcularDiarias(int qtdHoras) {

        return (int) Math.ceil(qtdHoras / 24);

    }
}
