package br.com.ccs.nullobject;

public class DescontoAbsoluto implements Desconto {

    private final double valorDesconto;

    public DescontoAbsoluto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @Override
    public double aplicarDesconto(double valorOriginal) {
        return valorOriginal - valorDesconto;
    }
}
