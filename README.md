# Proyecto de Verificación del Software con Jenkins

Proyecto Java creado con Maven y JUnit 5 para demostrar un proceso de Integración Continua en Jenkins.

## Funciones implementadas

La clase `Calculadora` incluye las siguientes funciones:

- `sumar(int numero1, int numero2)`
- `multiplicar(int numero1, int numero2)`
- `dividir(double dividendo, double divisor)`

La división controla el caso en que el divisor sea cero.

## Pruebas unitarias

La clase `CalculadoraTest` contiene cinco pruebas JUnit:

1. Suma de números positivos.
2. Suma de números negativos.
3. Multiplicación de dos números.
4. División de dos números.
5. Validación de división para cero.

## Requisitos

- Java 17 o superior.
- Maven 3.8 o superior, o Maven integrado en IntelliJ IDEA.
- Git.

## Abrir en IntelliJ IDEA Community Edition

1. Descomprimir el proyecto.
2. Abrir IntelliJ IDEA.
3. Seleccionar **Open**.
4. Elegir la carpeta `proyecto-verificacion-jenkins`.
5. Confirmar la importación como proyecto Maven.
6. Esperar a que IntelliJ descargue las dependencias.

## Ejecutar las pruebas

Desde una terminal que tenga Maven instalado:

```bash
mvn clean test
```

También se pueden ejecutar desde IntelliJ:

1. Abrir `src/test/java/com/john/verificacion/CalculadoraTest.java`.
2. Presionar el botón verde junto al nombre de la clase.
3. Seleccionar **Run 'CalculadoraTest'**.

El resultado esperado es:

```text
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

Los reportes XML que utilizará Jenkins se generan en:

```text
target/surefire-reports/*.xml
```

