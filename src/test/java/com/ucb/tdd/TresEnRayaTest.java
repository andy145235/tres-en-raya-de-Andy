package com.ucb.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TresEnRayaTest {

    private TresEnRaya juego;

    @BeforeEach
    void preparar() {
        juego = new TresEnRaya();
    }

    @Test
    void cuandoLaFilaEstaFueraDelTableroLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> juego.jugar(4, 1));
    }

    @Test
    void cuandoLaColumnaEstaFueraDelTableroLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> juego.jugar(1, 4));
    }

    @Test
    void cuandoLaCasillaYaEstaOcupadaLanzaExcepcion() {
        juego.jugar(2, 2);
        assertThrows(IllegalStateException.class, () -> juego.jugar(2, 2));
    }

    @Test
    void primerTurnoEsX() {
        assertEquals('X', juego.siguienteTurno());
    }

    @Test
    void despuesDeUnaJugadaTurnoEsMas() {
        juego.jugar(1, 1);
        assertEquals('+', juego.siguienteTurno());
    }

    @Test
    void despuesDeDosJugadasTurnoEsXOtraVez() {
        juego.jugar(1, 1);
        juego.jugar(1, 2);
        assertEquals('X', juego.siguienteTurno());
    }

    @Test
    void unaJugadaSolaSinGanador() {
        String resultado = juego.jugar(1, 1);
        assertEquals("sin ganador", resultado);
    }

    @Test
    void ganaXConFilaHorizontal() {
        juego.jugar(1, 1); // X
        juego.jugar(2, 1); // +
        juego.jugar(1, 2); // X
        juego.jugar(2, 2); // +
        String resultado = juego.jugar(1, 3); // X
        assertEquals("gana X", resultado);
    }
}
