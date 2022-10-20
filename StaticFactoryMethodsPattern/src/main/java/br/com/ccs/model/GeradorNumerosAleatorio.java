package br.com.ccs.model;

public class GeradorNumerosAleatorio {

    private int min;
    private int max;

    private GeradorNumerosAleatorio(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int generateRandomInt() {
        double random = Math.random() * (max - min + 1) + min;
        return (int) Math.floor(random);
    }


    public static GeradorNumerosAleatorio getInstanceBetween(int min, int max) {
        return new GeradorNumerosAleatorio(min, max);
    }

    public static GeradorNumerosAleatorio getInstanceGreaterThen(int min) {
        return new GeradorNumerosAleatorio(min, Integer.MAX_VALUE);
    }

    public static GeradorNumerosAleatorio getInstanceLessThen(int max) {
        return new GeradorNumerosAleatorio(Integer.MIN_VALUE, max);
    }

    public static GeradorNumerosAleatorio getInstanceLessThenAndGreaterThenZeroInclude(int max) {
        return new GeradorNumerosAleatorio(0, max);
    }
}
