package com.ucb.tdd;

public class TresEnRaya {

    private final char[][] tablero = new char[3][3];
    private char turnoActual = 'X';

    public String jugar(int x, int y) {
        if (x < 1 || x > 3) {
            throw new IllegalArgumentException("La coordenada X está fuera del tablero (debe ser entre 1 y 3)");
        }
        if (y < 1 || y > 3) {
            throw new IllegalArgumentException("La coordenada Y está fuera del tablero (debe ser entre 1 y 3)");
        }
        if (tablero[x - 1][y - 1] != '\0') {
            throw new IllegalStateException("La casilla (" + x + ", " + y + ") ya está ocupada");
        }
        
        char jugador = turnoActual;
        tablero[x - 1][y - 1] = jugador;
        turnoActual = (turnoActual == 'X') ? '+' : 'X';

        for (int fila = 0; fila < 3; fila++) {
            if (tablero[fila][0] == jugador && tablero[fila][1] == jugador && tablero[fila][2] == jugador) {
                return "gana " + jugador;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (tablero[0][col] == jugador && tablero[1][col] == jugador && tablero[2][col] == jugador) {
                return "gana " + jugador;
            }
        }

        return "sin ganador";
    }

    public char siguienteTurno() {
        return turnoActual;
    }
}
