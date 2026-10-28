package com.ucb.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Kata Tres en Raya - Pruebas Unitarias TDD")
class TresEnRayaTest {

    private TresEnRaya juego;

    @BeforeEach
    void inicializar() {
        juego = new TresEnRaya();
    }

    @Nested
    @DisplayName("Requerimiento 1: Colocación de piezas en tablero 3x3")
    class Requerimiento1ColocacionPiezas {

        @Test
        @DisplayName("Cuando una pieza está fuera del eje X, se debe lanzar una excepción")
        void cuandoPiezaEstaFueraDelEjeXLanzaExcepcion() {
            // Eje X fuera de rango (menor a 1 o mayor a 3)
            assertThrows(Exception.class, () -> juego.jugar(0, 2),
                    "Debe lanzar excepción cuando X es menor a 1");
            assertThrows(Exception.class, () -> juego.jugar(4, 2),
                    "Debe lanzar excepción cuando X es mayor a 3");
        }

        @Test
        @DisplayName("Cuando una pieza está fuera del eje Y, se debe lanzar una excepción")
        void cuandoPiezaEstaFueraDelEjeYLanzaExcepcion() {
            // Eje Y fuera de rango (menor a 1 o mayor a 3)
            assertThrows(Exception.class, () -> juego.jugar(2, 0),
                    "Debe lanzar excepción cuando Y es menor a 1");
            assertThrows(Exception.class, () -> juego.jugar(2, 4),
                    "Debe lanzar excepción cuando Y es mayor a 3");
        }

        @Test
        @DisplayName("Cuando una pieza está en un lugar ya ocupado, se debe lanzar una excepción")
        void cuandoPiezaEstaEnLugarYaOcupadoLanzaExcepcion() throws Exception {
            // Se realiza una jugada válida en (1, 1)
            juego.jugar(1, 1);

            // Intentar colocar otra pieza en la misma posición ocupada
            assertThrows(Exception.class, () -> juego.jugar(1, 1),
                    "Debe lanzar excepción cuando la casilla ya está ocupada");
        }
    }

    @Nested
    @DisplayName("Requerimiento 2: Determinación del turno siguiente")
    class Requerimiento2Turnos {

        @Test
        @DisplayName("El primer turno siempre debe ser jugado por 'X'")
        void primerTurnoSiempreEsJugadoPorX() {
            assertEquals('X', juego.siguienteTurno(),
                    "El primer jugador debe ser 'X'");
        }

        @Test
        @DisplayName("Si el último turno fue jugado por 'X', el siguiente turno es para '+'")
        void siUltimoTurnoFueJugadoPorXElSiguienteEsParaCruz() throws Exception {
            // 'X' realiza su jugada
            juego.jugar(1, 1);

            assertEquals('+', juego.siguienteTurno(),
                    "Después de 'X', el siguiente turno debe corresponder a '+'");
        }

        @Test
        @DisplayName("Si el último turno fue jugado por '+', el siguiente turno es para 'X'")
        void siUltimoTurnoFueJugadoPorCruzElSiguienteEsParaX() throws Exception {
            // 'X' juega en (1, 1)
            juego.jugar(1, 1);
            // '+' juega en (1, 2)
            juego.jugar(1, 2);

            assertEquals('X', juego.siguienteTurno(),
                    "Después de '+', el siguiente turno debe corresponder a 'X'");
        }
    }

    @Nested
    @DisplayName("Requerimiento 3: Condiciones de victoria")
    class Requerimiento3CondicionesVictoria {

        @Test
        @DisplayName("Si no se cumple la condición de victoria, no hay ganador")
        void siNoSeCumpleCondicionDeVictoriaNoHayGanador() throws Exception {
            // Una jugada normal inicial que no completa ninguna línea
            String resultado = juego.jugar(1, 1);

            assertEquals("No hay ganador", resultado,
                    "El resultado debe indicar que aún no hay ganador");
        }

        @Test
        @DisplayName("Un jugador gana cuando toda una línea horizontal es ocupada por sus piezas")
        void unJugadorGanaCuandoTodaUnaLineaHorizontalEsOcupadaPorSusPiezas() throws Exception {
            // Simulación de jugadas alternadas:
            // X juega en fila 1: (1, 1)
            juego.jugar(1, 1); // X
            juego.jugar(2, 1); // +
            juego.jugar(1, 2); // X
            juego.jugar(2, 2); // +
            // X completa la línea horizontal superior (fila 1): (1, 3)
            String resultado = juego.jugar(1, 3); // X

            assertEquals("X es el ganador", resultado,
                    "El jugador 'X' debe ganar al completar una línea horizontal");
        }

        @Test
        @DisplayName("Un jugador gana cuando toda una línea vertical es ocupada por sus piezas")
        void unJugadorGanaCuandoTodaUnaLineaVerticalEsOcupadaPorSusPiezas() throws Exception {
            // Simulación de jugadas alternadas:
            // X juega en columna 1: (1, 1)
            juego.jugar(1, 1); // X
            juego.jugar(1, 2); // +
            juego.jugar(2, 1); // X
            juego.jugar(2, 2); // +
            // X completa la línea vertical izquierda (columna 1): (3, 1)
            String resultado = juego.jugar(3, 1); // X

            assertEquals("X es el ganador", resultado,
                    "El jugador 'X' debe ganar al completar una línea vertical");
        }

        @Test
        @DisplayName("Un jugador gana cuando toda una línea diagonal es ocupada por sus piezas")
        void unJugadorGanaCuandoTodaUnaLineaDiagonalEsOcupadaPorSusPiezas() throws Exception {
            // Simulación de jugadas alternadas:
            // Diagonal principal: (1, 1), (2, 2), (3, 3)
            juego.jugar(1, 1); // X
            juego.jugar(1, 2); // +
            juego.jugar(2, 2); // X
            juego.jugar(1, 3); // +
            // X completa la línea diagonal: (3, 3)
            String resultado = juego.jugar(3, 3); // X

            assertEquals("X es el ganador", resultado,
                    "El jugador 'X' debe ganar al completar una línea diagonal");
        }
    }
}