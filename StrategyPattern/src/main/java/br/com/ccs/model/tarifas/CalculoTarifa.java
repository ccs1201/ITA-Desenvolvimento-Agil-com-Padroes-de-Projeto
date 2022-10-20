package br.com.ccs.model.tarifas;

import java.math.BigDecimal;

public interface CalculoTarifa {

    BigDecimal calcular(Integer qtdHoras);
}
