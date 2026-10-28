package com.ucb.tdd;

public class TresEnRaya {

    private final char[][] tablero = new char[3][3];
    private char turnoActual = 'X';

    public void jugar(int x, int y) {
        if (x < 1 || x > 3) {
            throw new IllegalArgumentException("La coordenada X está fuera del tablero (debe ser entre 1 y 3)");
        }
        if (y < 1 || y > 3) {
            throw new IllegalArgumentException("La coordenada Y está fuera del tablero (debe ser entre 1 y 3)");
        }
        if (tablero[x - 1][y - 1] != '\0') {
            throw new IllegalStateException("La casilla (" + x + ", " + y + ") ya está ocupada");
        }
        tablero[x - 1][y - 1] = turnoActual;
        turnoActual = (turnoActual == 'X') ? '+' : 'X';
    }

    public char siguienteTurno() {
        return turnoActual;
    }
}
