package br.com.ccs.nullobject;

public class Item {
    private double valor;
    private Desconto desconto = new DescontoNull();

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDesconto(Desconto desconto) {
        this.desconto = desconto;
    }

    public double getTotal() {
        return desconto.aplicarDesconto(valor);
    }
}
