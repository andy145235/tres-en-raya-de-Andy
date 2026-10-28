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
}
