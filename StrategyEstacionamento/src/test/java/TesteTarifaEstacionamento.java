
import br.com.ccs.model.TarifaEstacionamento;
import br.com.ccs.model.tarifas.CalculoPorHora;
import br.com.ccs.model.tarifas.TarifaDiaria;
import br.com.ccs.model.tarifas.TarifaInicialComAdicionalPorHora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TesteTarifaEstacionamento {

    private final BigDecimal VALOR_TARIFA_FIXA_POR_HORA = BigDecimal.valueOf(4.00);
    private final BigDecimal VALOR_TARIFA_INICIAL = BigDecimal.valueOf(4.00);
    private final BigDecimal VALOR_TARIFA_ADICIONAL = BigDecimal.valueOf(2.50);

    private final BigDecimal VALOR_TARIFA_DIARIA = BigDecimal.valueOf(60);
    private final int QTD_HORAS = 36;
    private final int QTD_HORAS_ABAIXO_DO_PERIODO_INICIAL = 2;
    private final int PERIODO_INICIAL = 3;


    @Test
    @DisplayName("Testa a tarifa fixa por hora")
    public void tarifaFixaPorHora() {

        BigDecimal expected = VALOR_TARIFA_FIXA_POR_HORA.multiply(BigDecimal.valueOf(QTD_HORAS));
        expected = expected.setScale(2, RoundingMode.HALF_UP);

        TarifaEstacionamento tarifa = new TarifaEstacionamento(QTD_HORAS,
                new CalculoPorHora(VALOR_TARIFA_FIXA_POR_HORA));

        Assertions.assertEquals(expected, tarifa.getTotal());
    }

    @Test
    @DisplayName("Testa a Tarifa Inicial Fixa mais Adicional por hora com horas ACIMA do Periodo Inicial")
    public void tarifaInicialComAdicionalPorHoraAcimaDoLImite() {

        int horasAdicionais = QTD_HORAS - PERIODO_INICIAL;

        BigDecimal expected = VALOR_TARIFA_ADICIONAL.multiply(BigDecimal.valueOf(horasAdicionais));
        expected = expected.add(VALOR_TARIFA_INICIAL);

        expected = expected.setScale(2, RoundingMode.HALF_UP);

        TarifaInicialComAdicionalPorHora calculoTarifa = new TarifaInicialComAdicionalPorHora(VALOR_TARIFA_INICIAL,
                VALOR_TARIFA_ADICIONAL, PERIODO_INICIAL);

        TarifaEstacionamento tarifa = new TarifaEstacionamento(QTD_HORAS,
                calculoTarifa);

        Assertions.assertEquals(expected, tarifa.getTotal());

    }

    @Test
    @DisplayName("Testa a Tarifa Inicial Fixa mais Adicional por hora com horas ABAIXO do Periodo")
    public void tarifaInicialComAdicionalPorHoraAbaixoDoLimite() {

        TarifaInicialComAdicionalPorHora calculoTarifa = new TarifaInicialComAdicionalPorHora(VALOR_TARIFA_INICIAL,
                VALOR_TARIFA_ADICIONAL, PERIODO_INICIAL);

        TarifaEstacionamento tarifa = new TarifaEstacionamento(QTD_HORAS_ABAIXO_DO_PERIODO_INICIAL,
                calculoTarifa);

        Assertions.assertEquals(VALOR_TARIFA_INICIAL.setScale(
                        2, RoundingMode.HALF_UP),
                tarifa.getTotal());

    }

    @Test
    @DisplayName("Testa a Tarifa Inicial Fixa mais Adicional por hora com horas IGUAL Periodo Inicial")
    public void tarifaInicialComAdicionalPorHoraIgualLimite() {

        TarifaInicialComAdicionalPorHora calculoTarifa = new TarifaInicialComAdicionalPorHora(VALOR_TARIFA_INICIAL,
                VALOR_TARIFA_ADICIONAL, PERIODO_INICIAL);

        TarifaEstacionamento tarifa = new TarifaEstacionamento(PERIODO_INICIAL,
                calculoTarifa);

        Assertions.assertEquals(
                VALOR_TARIFA_INICIAL.setScale(2, RoundingMode.HALF_UP),
                tarifa.getTotal());

    }

    @Test
    @DisplayName("Testa a Tarifa Diaria Com 36 Horas e Valor Diaria = 60")
    public void tarifaDiariaMaiorQue24Horas() {

        BigDecimal expected = BigDecimal.valueOf(120);

        expected = expected.setScale(2, RoundingMode.HALF_UP);

        TarifaDiaria calculoTarifa = new TarifaDiaria(VALOR_TARIFA_DIARIA);

        TarifaEstacionamento tarifa = new TarifaEstacionamento(36,
                calculoTarifa);

        Assertions.assertEquals(expected, tarifa.getTotal());

    }

    @Test
    @DisplayName("Testa a Tarifa Diaria com 18 Horas e valor diaria = 60")
    public void tarifaDiariaMenorQue24Horas() {

        BigDecimal expected = BigDecimal.valueOf(60);

        expected = expected.setScale(2, RoundingMode.HALF_UP);

        TarifaDiaria calculoTarifa = new TarifaDiaria(VALOR_TARIFA_DIARIA);

        TarifaEstacionamento tarifa = new TarifaEstacionamento(18,
                calculoTarifa);

        Assertions.assertEquals(expected, tarifa.getTotal());

    }
}
