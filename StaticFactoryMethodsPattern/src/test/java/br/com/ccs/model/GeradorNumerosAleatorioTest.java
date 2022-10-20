package br.com.ccs.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GeradorNumerosAleatorioTest {

    private int min = 1;
    private int max = 1;

    @Test
    @DisplayName("Testa se o numero inteiro aleatório está entre MIN e MAX")
    void getInstanceBetween() {

        GeradorNumerosAleatorio gerador = GeradorNumerosAleatorio.getInstanceBetween(min, max);

        boolean result = false;
        int randomNumber = gerador.generateRandomInt();
        System.out.println(randomNumber);

        if (randomNumber <= max && randomNumber >= min) {
            result = true;
        }

        Assertions.assertTrue(result);

    }

    @Test
    @DisplayName("Testa se o numero inteiro aleatório é MAIOR que MIN")
    void getInstanceGreaterThen() {

        GeradorNumerosAleatorio gerador = GeradorNumerosAleatorio.getInstanceGreaterThen(min);

        boolean result = false;

        int randomNunber = gerador.generateRandomInt();
        System.out.println(randomNunber);

        if (randomNunber > min) {
            result = true;
        }

        Assertions.assertTrue(result);

    }

    @Test
    @DisplayName("Testa se o numero inteiro aleatório é MENOR que MAX")
    void getInstanceLessThen() {

        GeradorNumerosAleatorio gerador = GeradorNumerosAleatorio.getInstanceLessThen(max);

        boolean result = false;

        int randomNunber = gerador.generateRandomInt();
        System.out.println(randomNunber);

        if (randomNunber < max) {
            result = true;
        }

        Assertions.assertTrue(result);

    }

    @Test
    @DisplayName("Testa se o numero inteiro aleatório é MENOR que MAX e MAIOR ou IGUAL a ZERO")
    void getInstanceLessThenAndGreaterThenZeroInclude() {

        GeradorNumerosAleatorio gerador = GeradorNumerosAleatorio.getInstanceLessThenAndGreaterThenZeroInclude(max);

        boolean result = false;

        int randomNunber = gerador.generateRandomInt();
        System.out.println(randomNunber);

        if (randomNunber <= max && randomNunber >= 0) {
            result = true;
        }

        Assertions.assertTrue(result);

    }
}