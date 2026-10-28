package com.ucb.tdd;

public class TresEnRaya {

    public void jugar(int x, int y) {
        if (x < 1 || x > 3) {
            throw new IllegalArgumentException("La coordenada X está fuera del tablero (debe ser entre 1 y 3)");
        }
    }
}
