package br.com.ccs.nullobject;

public class DescontoPercentual implements Desconto{

    private final double percentual;

    public DescontoPercentual(double percentual) {
        this.percentual = percentual / 100;
    }

    @Override
    public double aplicarDesconto(double valorOriginal) {

        return valorOriginal * percentual;
    }
}
