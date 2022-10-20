package br.com.ccs.model;

import br.com.ccs.model.tarifas.CalculoTarifa;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TarifaEstacionamento {

    private final Integer qtdHoras;
    private final CalculoTarifa calculoTarifa;

    public TarifaEstacionamento(Integer qtdHoras, CalculoTarifa calculoTarifa) {
        this.qtdHoras = qtdHoras;
        this.calculoTarifa = calculoTarifa;
    }

    public BigDecimal getTotal() {
        return calculoTarifa.calcular(qtdHoras).setScale(2, RoundingMode.HALF_UP);
    }
}
