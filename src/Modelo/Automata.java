package Modelo;

import java.util.ArrayList;
import java.util.List;

import static Modelo.Movimiento.MovimientosCompletos;

public class Automata {
    private static Pieza [][] EstadoTablero;
    private int profundidad = 3;
    private int puntuacion = 0;
    int alfa = Integer.MIN_VALUE;
    int beta = Integer.MAX_VALUE;

    /**
     * Este es uno de los métodos más importantes para la IA. Aquí se valora la situación de ta
     * blero actual, para poder pasarlo como parámetros como "valor neto" hacia la IA. Desde
     * aquí, tomará una decisión en base a cuánto puntúen los movimientos posibles, basándome
     * en diversas características para evitar sesgar demasiado a la máquina. Esta función recorre
     * rá la matriz tablero para leer la posición de las piezas, y otorgará una puntuación a cada
     * una en base a su importancia dentro del juego. Luego, restará esa misma puntuación depend
     * iendo de la cantidad de piezas que tenga el otro jugador.
     *
     * @param TableroActual Necesitamos el array de piezas que está siendo utilizado en el tablero
     * @return la puntuación, para luego pasarlo como parámetros a más funciones
     */
    public int EvaluarTablero(Pieza[][] TableroActual){
        int puntuacion = 0;
        //Creamos un bucle para recorrer la matrizs de piezas
        for (int i = 0; i < TableroActual.length; i++){
            for (int j = 0; j < TableroActual[i].length; j++){
                //En cada iteración, igualamos la pieza vacía, que nos servirá de buscador, a la
                // posición de la matriz en cada momento, para saber si hay o no pieza, y cuál es
                Pieza pieza = TableroActual[i][j];
                //
                if (pieza != null && pieza.getColor() == Pieza.NEGRO){
                    if(pieza.getNombre().equals("peon")){
                        puntuacion += 1;
                    }
                    if(pieza.getNombre().equals("caballo")){
                        puntuacion +=3;
                    }
                    if(pieza.getNombre().equals("alfil")){
                        puntuacion += 5;
                    }
                    if(pieza.getNombre().equals("torre")){
                        puntuacion += 7;
                    }
                    if(pieza.getNombre().equals("reina")){
                        puntuacion += 9;
                    }
                    if(pieza.getNombre().equals("rey")){
                        puntuacion += 100;
                    }
                }
                else if(pieza != null && pieza.getColor() == Pieza.BLANCO){
                    if(pieza.getNombre().equals("peon")){
                        puntuacion -= 1;
                    }
                    if(pieza.getNombre().equals("caballo")){
                        puntuacion -= 3;
                    }
                    if(pieza.getNombre().equals("alfil")){
                        puntuacion -= 5;
                    }
                    if(pieza.getNombre().equals("torre")){
                        puntuacion -= 7;
                    }
                    if(pieza.getNombre().equals("reina")){
                        puntuacion -= 9;
                    }
                    if(pieza.getNombre().equals("rey")) {
                        puntuacion -= 100;
                    }

                }
            }
        }
        this.puntuacion = puntuacion;
        return puntuacion;
    }

    public int Minimax(int profundidad, Pieza[][] TableroActual, int alfa, int beta, boolean esMaximizador) {
        Movimiento moverse = new Movimiento();
        int puntuacion = 0;
        if (profundidad == 0) {
            puntuacion = EvaluarTablero(TableroActual);
            return puntuacion;
        }
        if (esMaximizador) {
            int mejorPuntuacion = Integer.MIN_VALUE;
            List<Movimiento> MovimientosPosibles = moverse.MovimientosCompletos(TableroActual);
            for (Movimiento movimiento : MovimientosPosibles) {
                Pieza[][] nuevoTablero = realizarMovimiento(TableroActual, movimiento);
                puntuacion = Minimax(profundidad - 1, nuevoTablero, alfa, beta, false);

                mejorPuntuacion = Math.max(mejorPuntuacion, puntuacion);
                alfa = Math.max(alfa, mejorPuntuacion);

                if (beta <= alfa) {
                    alfa = Math.max(alfa,mejorPuntuacion);
                break;
                }else{

                }
             }
            return mejorPuntuacion;
        } else {
            int mejorPuntuacion = Integer.MAX_VALUE;
            List<Movimiento> MovimientosPosibles = moverse.MovimientosCompletos(TableroActual);
            for (Movimiento movimiento : MovimientosPosibles){
                Pieza [][] nuevoTablero = realizarMovimiento(TableroActual,movimiento);
                puntuacion = Minimax(profundidad - 1, nuevoTablero, alfa, beta, true);

                mejorPuntuacion = Math.min(mejorPuntuacion,puntuacion);
                if (beta <= alfa){
                    break;
                }
            }
            return mejorPuntuacion;
        }
    }

    public Pieza[][] copiarTablero (Pieza[][] TableroACopiar){
        int filas = TableroACopiar.length;
        int columnas = TableroACopiar[0].length;
        Pieza [][] nuevoTablero = new Pieza[filas][columnas];
    }
}

