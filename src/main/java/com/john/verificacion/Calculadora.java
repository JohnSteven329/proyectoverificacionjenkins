package com.john.verificacion;

/**
 * Funciones sencillas utilizadas para demostrar pruebas unitarias con JUnit.
 */
public class Calculadora {

    /**
     * Suma dos números enteros.
     *
     * @param numero1 primer número
     * @param numero2 segundo número
     * @return resultado de la suma
     */
    public int sumar(int numero1, int numero2) {
        return numero1 + numero2;
    }

    /**
     * Multiplica dos números enteros.
     *
     * @param numero1 primer número
     * @param numero2 segundo número
     * @return resultado de la multiplicación
     */
    public int multiplicar(int numero1, int numero2) {
        return numero1 * numero2;
    }

    /**
     * Divide dos números y controla la división para cero.
     *
     * @param dividendo número que será dividido
     * @param divisor número por el cual se divide
     * @return resultado decimal de la división
     * @throws IllegalArgumentException cuando el divisor es cero
     */
    public double dividir(double dividendo, double divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero");
        }
        return dividendo / divisor;
    }
}
