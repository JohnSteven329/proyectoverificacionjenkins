package com.john.verificacion;

public class GestorDescuentos {

    public double calcularPrecioFinal(double subtotal, String tipoCliente) {
        if (subtotal < 0) {
            throw new IllegalArgumentException(
                    "El subtotal no puede ser negativo"
            );
        }

        double porcentajeDescuento;

        if ("VIP".equalsIgnoreCase(tipoCliente)) {
            porcentajeDescuento = 0.20;
        } else if ("FRECUENTE".equalsIgnoreCase(tipoCliente)) {
            porcentajeDescuento = 0.10;
        } else if (subtotal >= 100) {
            porcentajeDescuento = 0.05;
        } else {
            porcentajeDescuento = 0;
        }

        return subtotal - (subtotal * porcentajeDescuento);
    }

    public double calcularImpuesto(double subtotal) {
        if (subtotal < 0) {
            throw new IllegalArgumentException(
                    "El subtotal no puede ser negativo"
            );
        }

        return subtotal * 0.15;
    }

    public String clasificarCompra(double total) {
        if (total >= 500) {
            return "COMPRA_ALTA";
        }

        if (total >= 100) {
            return "COMPRA_MEDIA";
        }

        return "COMPRA_BAJA";
    }

    public boolean aplicaEnvioGratis(
            double total,
            boolean clientePremium
    ) {
        return clientePremium || total >= 50;
    }
}