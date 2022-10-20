package br.com.ccs.nullobject;

public class DescontoNull implements Desconto {
    @Override
    public double aplicarDesconto(double valorOriginal) {
        return valorOriginal;
    }
}
