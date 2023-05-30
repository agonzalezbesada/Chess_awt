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

        puntuacion += EvaluarPosicionesCentrales(TableroActual);
        puntuacion += DefensaRey(TableroActual);
        puntuacion += EstructuraPeones(TableroActual);
        if (esJaqueMaquina(TableroActual) == true){
            puntuacion += 70;
        }
        if(esJaqueMateMaquina(TableroActual) == true){
            puntuacion += 10000;
        }


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

                if (puntuacion > mejorPuntuacion){
                    mejorPuntuacion = puntuacion;
                    Movimiento mejorMovimiento = movimiento;
                }

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

                    Pieza pieza = TableroACopiar[fila][columna];
                    if(pieza instanceof Peon){
                        pieza = new Peon();
                        nuevoTablero[fila][columna] = pieza;
                    }
                    if(pieza instanceof Caballo){
                        pieza = new Caballo();
                        nuevoTablero[fila][columna] = pieza;
                    }
                    if(pieza instanceof Alfil){
                        pieza = new Alfil();
                        nuevoTablero[fila][columna] = pieza;
                    }
                    if(pieza instanceof Torre){
                        pieza = new Torre();
                        nuevoTablero[fila][columna] = pieza;
                    }
                    if(pieza instanceof Reina){
                        pieza = new Reina();
                        nuevoTablero[fila][columna] = pieza;
                    }
                    if(pieza instanceof Rey){
                        pieza = new Rey();
                        nuevoTablero[fila][columna] = pieza;
                    }
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

    public int EstructuraPeones(Pieza[][] Tablero){
        int EstructuraPeones = 0;
        //Al valorar la estructura de peones, debemos tener en consideración dos cosas: una de ellas es la puntuación en otrno a las filas (que no co
        //lumnas) centrales. Necesitamos puntuar positivamente las filas centrales, pues son aquellas que darán un sostén mayor a la estructura de peones.
        // Por otro lado, debemos comprobar que esas filas están ocupadas por peones, y no por otra pieza, para darle una puntuación.

        //Para empezar, declaramos dos arrays de enteros que representen la puntuación de las filas y la de las columjas
        int [] filaEstructura = {1,2,3,4,4,3,2,1};
        int [] columnaEstructura = {0,0,0,0,0,0,0,0};
        for (int fila = 0; fila < 8; fila ++){
            for (int columna = 0; columna < 8; columna++){
                Pieza pieza = Tablero[fila][columna];
                if (pieza instanceof Peon){
                    EstructuraPeones += filaEstructura[fila] + columnaEstructura[columna];
                }
            }
        }

        return EstructuraPeones;
    }

    /**
     * Vamos a realizar la lógica del jaque. Es, en cierto modo, sencillo, puesto que solo necesitamos el tablero como parámetro y recoger los movimientos
     * posibles de las piezas, para saber si hay alguna pieza enemiga que pueda amenazar al rey.
     * @param Tablero
     * @return
     */
    public boolean esJaqueMaquina(Pieza[][] Tablero){
        Movimiento movimiento = new Movimiento();
        boolean Jaque = false;
        int FilaRey = 0;
        int ColumnaRey = 0;
        List<Movimiento> movimientos = movimiento.MovimientosCompletos(Tablero);
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if(Tablero[i][j] instanceof Rey && Tablero[i][j].getColor() == IPieza.BLANCO ){
                    Pieza pieza = Tablero[i][j];
                        FilaRey = i;
                        ColumnaRey = j;

                }
            }
        }
        for (Movimiento movimiento1 : movimientos){
            if(FilaRey == movimiento1.getFilaDestino() && ColumnaRey == movimiento1.getColumnaDestino()){
                Jaque = true;
            }
        }

        return Jaque;

    }

    /**
     * Para la lógica del jaque mate, debemos tener en cuenta la posibilidad de jaque (pero lo haremos desde fuera del método, para mayor comodidad.
     * Una vez sepamos que jaque es true, deberemos recorrer los movimientos del rey, para saber si es definitivo o no. El contador "NoEsJaqueMate"
     * recoge la cantidad de movimientos que puede hacer el rey donde jaque es false, de manera que si es mayor a 0, el jaque mate no sea posible (puesto
     * que el rey puede moverse a esa posición).
     * @param Tablero
     * @return
     */
    public boolean esJaqueMateMaquina(Pieza [][] Tablero){
        Automata automata = new Automata();
        Movimiento movimientoAuxiliar = new Movimiento();
        int NoEsJaqueMate = 0;
        boolean JaqueMate = false;
        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (Tablero[i][j] instanceof Rey && Tablero[i][j].getColor() == IPieza.BLANCO){
                    List <Movimiento> MovimientosRey = movimientoAuxiliar.MovimientoPieza(Tablero,i,j);
                    Pieza [][] TableroCopiado = automata.copiarTablero(Tablero);
                    for(Movimiento movimiento : MovimientosRey){
                        TableroCopiado = movimientoAuxiliar.realizarMovimiento(TableroCopiado,movimiento);
                        boolean jaque = esJaqueMaquina(TableroCopiado);
                        if(jaque == false){
                            NoEsJaqueMate++;
                        }


                    }

                }
            }
        }
        if(NoEsJaqueMate != 0){
            JaqueMate = false;
        } else{
            JaqueMate = true;
        }
        return JaqueMate;
    }

}