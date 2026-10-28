# Kata Tres en Raya – TDD

Resolución de la kata *Tres en Raya* aplicando Test-Driven Development (ciclo rojo → verde → refactor).

## Stack
- Java 17
- Maven
- JUnit 5 (Jupiter)
- GitHub Actions (ejecuta `mvn clean test` en cada push)

## Ejecutar las pruebas
```bash
mvn clean test
```

## Estructura
```
src/main/java/com/ucb/tdd/   → código del programa
src/test/java/com/ucb/tdd/   → pruebas unitarias escritas a mano
docs/ia/                     → prompt usado y pruebas generadas por IA (para la comparación)
```

## Requerimientos de la kata
1. Una pieza puede colocarse en un espacio de un tablero 3x3 (fuera de X / fuera de Y / lugar ocupado → excepción).
2. Debe existir una forma de determinar qué jugador juega después (X inicia; se alternan X y +).
3. Un jugador gana al completar una línea horizontal, vertical o diagonal.
