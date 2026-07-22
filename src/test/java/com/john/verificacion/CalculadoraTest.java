package com.john.verificacion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void configurar() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Debe sumar correctamente dos números enteros")
    void debeSumarDosNumeros() {
        // Fallo provocado intencionalmente:
        // 8 + 4 devuelve 12, pero esperamos 15.
        assertEquals(15, calculadora.sumar(8, 4));
    }

    @Test
    @DisplayName("Debe sumar correctamente números negativos")
    void debeSumarNumerosNegativos() {
        assertEquals(-7, calculadora.sumar(-3, -4));
    }

    @Test
    @DisplayName("Debe multiplicar correctamente dos números")
    void debeMultiplicarDosNumeros() {
        assertEquals(30, calculadora.multiplicar(6, 5));
    }

    @Test
    @DisplayName("Debe dividir correctamente dos números")
    void debeDividirDosNumeros() {
        assertEquals(5.0, calculadora.dividir(20, 4), 0.001);
    }

    @Test
    @DisplayName("Debe impedir la división para cero")
    void debeImpedirDivisionParaCero() {
        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.dividir(10, 0)
        );

        assertEquals(
                "El divisor no puede ser cero",
                excepcion.getMessage()
        );
    }
}