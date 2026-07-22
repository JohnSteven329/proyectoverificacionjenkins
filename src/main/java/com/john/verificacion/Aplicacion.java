package com.john.verificacion;

/**
 * Clase principal para comprobar manualmente el funcionamiento del proyecto.
 */
public class Aplicacion {

    private Aplicacion() {
        // Evita instanciar la clase principal.
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        System.out.println("=== Proyecto de Verificación con Jenkins ===");
        System.out.println("Suma de 8 + 4: " + calculadora.sumar(8, 4));
        System.out.println("Multiplicación de 6 x 5: " + calculadora.multiplicar(6, 5));
        System.out.println("División de 20 / 4: " + calculadora.dividir(20, 4));
    }
}
