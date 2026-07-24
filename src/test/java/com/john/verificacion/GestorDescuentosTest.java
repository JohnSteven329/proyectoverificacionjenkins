package com.john.verificacion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GestorDescuentosTest {

    private GestorDescuentos gestorDescuentos;

    @BeforeEach
    void configurar() {
        gestorDescuentos = new GestorDescuentos();
    }

    @Test
    @DisplayName("Debe aplicar veinte por ciento de descuento al cliente VIP")
    void debeAplicarDescuentoVip() {
        double resultado = gestorDescuentos.calcularPrecioFinal(100, "VIP");

        assertEquals(80.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Debe aplicar diez por ciento al cliente frecuente")
    void debeAplicarDescuentoFrecuente() {
        double resultado =
                gestorDescuentos.calcularPrecioFinal(100, "FRECUENTE");

        assertEquals(90.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Debe aplicar cinco por ciento a una compra mayor a cien")
    void debeAplicarDescuentoPorMonto() {
        double resultado =
                gestorDescuentos.calcularPrecioFinal(200, "NORMAL");

        assertEquals(190.0, resultado, 0.001);
    }

    @Test
    @DisplayName("No debe aplicar descuento a una compra pequeña")
    void noDebeAplicarDescuento() {
        double resultado =
                gestorDescuentos.calcularPrecioFinal(40, "NORMAL");

        assertEquals(40.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Debe impedir un subtotal negativo")
    void debeImpedirSubtotalNegativo() {
        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> gestorDescuentos.calcularPrecioFinal(-10, "VIP")
        );

        assertEquals(
                "El subtotal no puede ser negativo",
                excepcion.getMessage()
        );
    }

    @Test
    @DisplayName("Debe calcular correctamente el impuesto")
    void debeCalcularImpuesto() {
        double resultado = gestorDescuentos.calcularImpuesto(100);

        assertEquals(15.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Debe impedir calcular impuesto de un subtotal negativo")
    void debeImpedirImpuestoNegativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> gestorDescuentos.calcularImpuesto(-20)
        );
    }

    @Test
    @DisplayName("Debe clasificar una compra alta")
    void debeClasificarCompraAlta() {
        assertEquals(
                "COMPRA_ALTA",
                gestorDescuentos.clasificarCompra(600)
        );
    }

    @Test
    @DisplayName("Debe clasificar una compra media")
    void debeClasificarCompraMedia() {
        assertEquals(
                "COMPRA_MEDIA",
                gestorDescuentos.clasificarCompra(200)
        );
    }

    @Test
    @DisplayName("Debe clasificar una compra baja")
    void debeClasificarCompraBaja() {
        assertEquals(
                "COMPRA_BAJA",
                gestorDescuentos.clasificarCompra(50)
        );
    }

    @Test
    @DisplayName("Debe aplicar envío gratis a un cliente premium")
    void debeAplicarEnvioGratisAClientePremium() {
        assertTrue(
                gestorDescuentos.aplicaEnvioGratis(20, true)
        );
    }

    @Test
    @DisplayName("Debe aplicar envío gratis cuando la compra alcanza cincuenta")
    void debeAplicarEnvioGratisPorMonto() {
        assertTrue(
                gestorDescuentos.aplicaEnvioGratis(50, false)
        );
    }

    @Test
    @DisplayName("No debe aplicar envío gratis a una compra pequeña")
    void noDebeAplicarEnvioGratis() {
        assertFalse(
                gestorDescuentos.aplicaEnvioGratis(30, false)
        );
    }
}