package Modelo;

import java.util.ArrayList;
import java.util.List;


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
        puntuacion = EvaluarPiezas(TableroActual);

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
                Pieza[][] nuevoTablero = moverse.realizarMovimiento(TableroActual, movimiento);
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
                Pieza [][] nuevoTablero = moverse.realizarMovimiento(TableroActual,movimiento);
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
        for (int fila = 0; fila < filas; fila++){
            for (int columna = 0; columna < columnas; columna++){
                if (TableroACopiar[fila][columna] != null){
                    nuevoTablero[fila][columna] = new Pieza ();
                }
            }
        }
        return nuevoTablero;
    }

    public int EvaluarPiezas(Pieza [][] Tablero){
        int puntuacionTablero = 0;
        for (int i = 0; i < Tablero.length; i++){
            for (int j = 0; j < Tablero[i].length; j++){
                //En cada iteración, igualamos la pieza vacía, que nos servirá de buscador, a la
                // posición de la matriz en cada momento, para saber si hay o no pieza, y cuál es
                Pieza pieza = Tablero[i][j];
                //
                if (pieza != null && pieza.getColor() == Pieza.NEGRO){
                    if(pieza instanceof Peon){
                        puntuacionTablero += 1;
                    }
                    if(pieza instanceof Caballo){
                        puntuacionTablero +=3;
                    }
                    if(pieza instanceof Alfil){
                        puntuacionTablero += 5;
                    }
                    if(pieza instanceof Torre){
                        puntuacionTablero += 7;
                    }
                    if(pieza instanceof Reina){
                        puntuacionTablero += 9;
                    }
                    if(pieza instanceof Rey){
                        puntuacionTablero += 100;
                    }
                }
                else if(pieza != null && pieza.getColor() == Pieza.BLANCO){
                    if(pieza instanceof Peon){
                        puntuacionTablero -= 1;
                    }
                    if(pieza instanceof Caballo){
                        puntuacionTablero -= 3;
                    }
                    if(pieza instanceof Alfil){
                        puntuacionTablero -= 5;
                    }
                    if(pieza instanceof Torre){
                        puntuacionTablero -= 7;
                    }
                    if(pieza instanceof Reina){
                        puntuacionTablero -= 9;
                    }
                    if(pieza instanceof Rey) {
                        puntuacionTablero -= 100;
                    }

                }
            }
        }
        return puntuacionTablero;
    }

    public int EvaluarPosicionesCentrales(Pieza[][] Tablero){
        int puntuacionCentral = 0;

        //Vamos a otorgarle puntuaciones a aquellas posiciones que estén en el centro del tablero. Estas posiciones son sumamente importantes, puesto que
        //quien controla el centro del tablero, suele controlar la partida (al igual que ocurre en otros ámbitos como los deportes de contacto). Comprobamos
        //que la matriz tiene un tamaño de 8x8, por lo que podemos considerar las posiciones 4,4 - 4,5 - 5,4 - 5,5 como las más valiosas de controlar.
        int [][] PosicionesCentrales = {{4,4}, {4,5},{5,4},{5,5}};
        //De la misma manera que hicimos con, por ejemplo, los movimientos de la torre o del alfil, vamos a crear una matriz de posiciones para poder
        //indicarle a la IA que controlar dichas posiciones será más valioso que no hacerlo. Cuando, en el algoritmo minimax, la IA compruebe que sus
        //piezas en estas posiciones le otorgan una puntuación mayor, y que las del rival una menor, tomará decisiones para aproximarse a dichas posiciones.
        for (int[] posicion : PosicionesCentrales){
            int fila = posicion[0];
            int columna = posicion[1];

            if(Tablero[fila][columna] != null){
                if(Tablero[fila][columna].getColor() == IPieza.NEGRO){
                    puntuacionCentral += 5;
                } else {
                    puntuacionCentral -= 5;
                }
            }
        }

        return puntuacionCentral;
    }
    public int DefensaRey(Pieza[][]Tablero){
        int PuntuacionDefensaRey = 0;
        int reyFila = -1;
        int reyColumna = -1;
        //Vamos a comprobar cómo de defendido está el rey a su alrededor. Sería bueno añadir la lógica del enroque, puesto que le beneficiaría estar alejado
        //del peligro. Para ello, como siempre recorremos el array y buscamos encontrar al rey. Una vez encontrado, haremos la misma táctica que hicimos con
        //los movimientos de la torre, el alfil y la reina para designar las posiciones adyacentes a mismo. Normalmente, las piezas más valiosas (como la
        //torre o el alfil, pero excluyendo a la reina por su capaciadad ofensiva) van a puntuar más alto que en el caso del peón.

        for (int i = 0; i < Tablero.length;i++){
            for(int j = 0; j < Tablero[i].length;j++){
                Pieza pieza = Tablero[i][j];
                if (pieza instanceof Rey){
                    reyFila = i;
                    reyColumna = j;
                    break;
                }
            }
            if(reyFila != -1 && reyColumna != -1){
                int [][] posicionesContiguas = {
                        {reyFila - 1, reyColumna - 1}, {reyFila - 1, reyColumna}, {reyFila - 1, reyColumna + 1},
                        {reyFila, reyColumna - 1},                                 {reyFila, reyColumna + 1},
                        {reyFila + 1, reyColumna - 1}, {reyFila + 1, reyColumna}, {reyFila + 1, reyColumna + 1}
                };

                for (int[] posicion : posicionesContiguas){
                    int fila = posicion[0];
                    int columna = posicion[1];
                    Pieza piezaAdyacente = Tablero[fila][columna];
                    if(piezaAdyacente instanceof Peon){
                        PuntuacionDefensaRey += 1;
                    }
                    if (piezaAdyacente instanceof Alfil) {
                        PuntuacionDefensaRey += 2;
                    }
                    if (piezaAdyacente instanceof Torre){
                        PuntuacionDefensaRey += 3;
                    }
                }
            }

        }
        return PuntuacionDefensaRey;
    }
}

