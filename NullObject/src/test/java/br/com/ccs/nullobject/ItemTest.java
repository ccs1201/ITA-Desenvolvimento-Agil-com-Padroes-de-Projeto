package br.com.ccs.nullobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemTest {

    @Test
    @DisplayName("Testa Desconto Absoluto")
    public void TestDescontoAbsoluto() {

        Desconto desconto = new DescontoAbsoluto(50);

        Item item = new Item();
        item.setDesconto(desconto);
        item.setValor(100);

        Assertions.assertEquals(50, item.getTotal());
    }

    @Test
    @DisplayName("Testa Desconto Percentual")
    public void testDescontoPercentual(){
        Desconto desconto = new DescontoPercentual(50);

        Item item = new Item();
        item.setDesconto(desconto);
        item.setValor(100);

        Assertions.assertEquals(50, item.getTotal());
    }
    @Test
    @DisplayName("Testa Desconto null (sem desconto)")
    public void testDescontoPNull(){

        Item item = new Item();
        item.setValor(100);

        Assertions.assertEquals(100, item.getTotal());
    }

}