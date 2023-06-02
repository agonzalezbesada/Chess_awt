package Modelo;

import javax.swing.*;

public class Partida {
    /**
     * Nombre de usuario
     */
    public String nickName;
    /**
     * Matriz con las posiciones del tablero
     */
    public Pieza[][] estadoPartida;
    /**
     * Turno de la partida
     */
    public Integer turno;

    /**
     * Método que ajusta los tipos de objeto dentro de la matriz, ya que la deserialización
     * castea todos los objetos que contine a la clase padre de la matriz
     */
    public void ajustarTipos() {

        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                if (estadoPartida[col][row] != null) {
                    if (estadoPartida[col][row].getNombre().equals("PB1")) {
                        estadoPartida[col][row] = new Peon(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("PB2")) {
                        estadoPartida[col][row] = new Peon(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("PB3")) {
                        estadoPartida[col][row] = new Peon(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("PB4")) {
                        estadoPartida[col][row] = new Peon(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("PB5")) {
                        estadoPartida[col][row] = new Peon(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("PB6")) {
                        estadoPartida[col][row] = new Peon(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("PB7")) {
                        estadoPartida[col][row] = new Peon(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("PB8")) {
                        estadoPartida[col][row] = new Peon(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("TB1")) {
                        estadoPartida[col][row] = new Torre(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("TB2")) {
                        estadoPartida[col][row] = new Torre(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("CB1")) {
                        estadoPartida[col][row] = new Caballo(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("CB2")) {
                        estadoPartida[col][row] = new Caballo(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("AB1")) {
                        estadoPartida[col][row] = new Alfil(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("AB2")) {
                        estadoPartida[col][row] = new Alfil(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("ReinaB")) {
                        estadoPartida[col][row] = new Reina(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("ReyB")) {
                        estadoPartida[col][row] = new Rey(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("PN1")) {
                        estadoPartida[col][row] = new Peon(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("PN2")) {
                        estadoPartida[col][row] = new Peon(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("PN3")) {
                        estadoPartida[col][row] = new Peon(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("PN4")) {
                        estadoPartida[col][row] = new Peon(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("PN5")) {
                        estadoPartida[col][row] = new Peon(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("PN6")) {
                        estadoPartida[col][row] = new Peon(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("PN7")) {
                        estadoPartida[col][row] = new Peon(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("PN8")) {
                        estadoPartida[col][row] = new Peon(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("TN1")) {
                        estadoPartida[col][row] = new Torre(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("TN2")) {
                        estadoPartida[col][row] = new Torre(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("CN1")) {
                        estadoPartida[col][row] = new Caballo(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("CN2")) {
                        estadoPartida[col][row] = new Caballo(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("AN1")) {
                        estadoPartida[col][row] = new Alfil(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("AN2")) {
                        estadoPartida[col][row] = new Alfil(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("ReinaN")) {
                        estadoPartida[col][row] = new Reina(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    } else if (estadoPartida[col][row].getNombre().equals("ReyN")) {
                        estadoPartida[col][row] = new Rey(estadoPartida[col][row].getColor(),estadoPartida[col][row].getNombre(),estadoPartida[col][row].getPosicion()[0],estadoPartida[col][row].getPosicion()[1]);
                    }
                }
            }
        }
    }
}
