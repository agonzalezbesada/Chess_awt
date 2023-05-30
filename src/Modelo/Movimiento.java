package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Movimiento {
    int filaDestino;
    int columnaDestino;
    int filaOrigen;
    int columnaOrigen;
    boolean PuedeComer;


    Movimiento(int fila, int columna, int filaOrigen, int columnaOrigen, boolean PuedeComer) {
        this.filaDestino = fila;
        this.columnaDestino = columna;
        this.filaOrigen = filaOrigen;
        this.columnaOrigen = columnaOrigen;
        this.PuedeComer = PuedeComer;
    }
    Movimiento(){}

    /**
     * El método GenerarMovimiento es clave para el buen desarrollo del algoritmo. Trabajará conjuntamente con el de evaluarTablero para poder llevar
     * a cabo las funcionalidades correctamente.
     * El algoritmo es bastante complejo, por lo que se añadirán más comentarios a medida que avanzamos en el algoritmo, para poder detenernos en cada
     * caso en particular
     * @param Tablero parámetro fundamental, para conocer cuál es el estado del tablero
     * @param fila Lo necesitamos para poder mover la pieza.
     * @param columna Lo mismo que las filas.
     * @return
     */
    public List<Movimiento> MovimientoPieza(Pieza[][] Tablero, int fila, int columna) {
        //Generamos un array de movimientos posibles que devolveremos más adelante, cuando sepamos qué tipo de pieza es
        List<Movimiento> movimientosPosibles = new ArrayList<>();
        //Generamos también una pieza, en la posición que se va a analizar, para saber cuáles son los movimientos posibles para esa pieza
        Pieza pieza = Tablero[fila][columna];
        //El peón puede moverse hacia delante, solo una vez, por lo que implementamos la lógica para
        //que pueda moverse y, además, que no se salga de los límites de la matriz.
        if (pieza instanceof Peon) {
            if (fila + 1 < 8 && Tablero[fila + 1][columna] == null) {
                Movimiento MovimientoPeon = new Movimiento(fila + 1, columna, fila, columna, false);
                movimientosPosibles.add(MovimientoPeon);
            }
            //De ahora en adelante, los movimientos llamados "PuedeComer" van a ser aquellos cuyo boolean "PuedeComer" sea true, para indicarle a la IA,

            // concretamente en evaluar tablero, si puede comer o no a la pieza rival (con el correspondiente ajuste de puntos).


            if (Tablero[fila + 1][columna + 1] != null && pieza.getColor() == IPieza.BLANCO) {
                Movimiento PuedeComer = new Movimiento(fila + 1, columna + 1, fila, columna, true);
                movimientosPosibles.add(PuedeComer);
            }
            if (Tablero[fila + 1][columna - 1] != null && pieza.getColor() == IPieza.BLANCO) {
                Movimiento PuedeComer = new Movimiento(fila + 1, columna - 1,fila, columna, true);
                movimientosPosibles.add(PuedeComer);
            }
            if (fila == 6) {
                Movimiento MoverDoble = new Movimiento(fila + 2, columna,fila, columna, false);
                movimientosPosibles.add(MoverDoble);
            }
        }
        //Para el caballo, seguimos la misma lógica, pero esta vez empleamos una matriz con los movimientos necesarios. Como sabemos por las reglas
        //del ajedrez, al caballo se le permite moverse tres casillas en L, esto es, dos casillas seguidas y una en perpendicular. Esta combinación
        //se puede realizar tanto si se comienza recorriendo las dos casillas seguidas (y se le añade un movimiento perpendicular) como si se recorre
        //primero el movimiento perpendicular y luego se le añaden las dos casillas seguidas, lo que abre un abanico de posibilidades a los movimientos,
        // y de ahí las combinaciones en forma de matriz (que emulan el comportamiento del tablero con filas y columnas).
            if (pieza instanceof Caballo) {
                //En concreto, las posibilidades de movimiento son ocho, haciendo de la pieza una de las más versátiles a la hora de moverse
                int[][] Posibilidades = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
                // el bucle recorre todas las posibilidades en las que, o bien la casilla de destino es null, o bien hay una pieza enemiga (en cuyo caso,
                //el movimiento activa el boolean "PuedeComer",
                for (int[] Desplazamiento : Posibilidades) {
                    int nuevaFila = fila + Desplazamiento[0];
                    int nuevaColumna = columna + Desplazamiento[1];
                    if (Tablero[nuevaFila][nuevaColumna] == null) {
                        Movimiento MovimientoCaballo = new Movimiento(nuevaFila, nuevaColumna,fila, columna, false);
                        movimientosPosibles.add(MovimientoCaballo);
                    }
                    if (Tablero[nuevaFila][nuevaColumna] != null && Tablero[nuevaFila][nuevaColumna].getColor() == IPieza.BLANCO) {
                        Movimiento PuedeComer = new Movimiento(nuevaFila, nuevaColumna,fila, columna, true);
                        movimientosPosibles.add(PuedeComer);
                    }
                }
            }
            // Con el alfil seguimos la lógica del caballo, de manera que creamos una matriz con todas sus posibilidades. La particularidad del alfil
            // (su movimiento en diagonal) obliga, no obstante, a sumar o restar siempre la misma cantidad de filas que de columnas, de ahí las diversas
            // combinaciones que pueden surgir. Otro aspecto que debemos mencionar, es la imposibilidad de la IA de tomar decisiones propiamente dichas,
            // por lo que cada casilla es realmente un movimiento por sí mismo. Un jugador humano escogería la casilla deseada, sabiendo simplemente que
            // la restricción es moverse en diagonal, pero la IA debe tener el conocimiento de cada casilla disponible.
            if (pieza instanceof Alfil) {
                int[][] DesplazamientosAlfil = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
                // El bucle for recorre los posibles desplazamientos, para saber exactamente hasta dónde puede moverse (y, dicho sea de paso, cuál es el
                // movimiento que más puntúa).
                for (int[] Desplazamiento : DesplazamientosAlfil) {
                    int NuevaFila = fila + Desplazamiento[0];
                    int NuevaColumna = columna + Desplazamiento[1];
                    while(NuevaFila >= 0 && NuevaFila < 8 && NuevaColumna >= 0 && NuevaColumna < 8 && Tablero[NuevaFila][NuevaColumna] == null){
                            Movimiento MovimientoAlfil = new Movimiento(NuevaFila, NuevaColumna,fila, columna, false);
                            movimientosPosibles.add(MovimientoAlfil);
                            //Nuevamente, además de si la casilla está vacía, se creará un nuevo movimiento si se puede comer una pieza rival.
                        if (Tablero[NuevaFila][NuevaColumna] != null && Tablero[NuevaFila][NuevaColumna].getColor() == IPieza.BLANCO) {
                            Movimiento PuedeComer = new Movimiento(NuevaFila, NuevaColumna, fila, columna,true);
                            movimientosPosibles.add(PuedeComer);
                        }
                        NuevaFila += Desplazamiento[0];
                        NuevaColumna += Desplazamiento[1];
                    }

                }
            }
            // Una vez comentado el alfil, la torre sigue exactamente la misma lógica, pero moviéndose en vertical u horizontal. Esto significa que,
            //o bien se mueve por las filas (y las columnas no se recorren), o viceversa, pero nunca ambas a la vez.
            if (pieza instanceof Torre) {
                int[][] DesplazamientosTorre = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] Desplazamiento : DesplazamientosTorre) {
                    int NuevaFila = Desplazamiento[0];
                    int NuevaColumna = Desplazamiento[1];
                    while(NuevaFila >= 0 && NuevaFila < 8 && NuevaColumna >= 0 && NuevaColumna < 8 && Tablero[NuevaFila][NuevaColumna] == null) {
                        Movimiento MovimientoTorre = new Movimiento(NuevaFila, NuevaColumna, fila, columna, false);
                        movimientosPosibles.add(MovimientoTorre);

                        if (Tablero[NuevaFila][NuevaColumna] == null && Tablero[NuevaFila][NuevaColumna].getColor() == IPieza.BLANCO) {
                            Movimiento PuedeComer = new Movimiento(NuevaFila, NuevaColumna,fila, columna, true);
                            movimientosPosibles.add(PuedeComer);
                        }
                        NuevaFila += Desplazamiento[0];
                        NuevaColumna += Desplazamiento[1];
                    }
                }
            }
            //La reina aúna las lógicas de la torre y el alfil. Podría decirse que es la unión entre estas dos piezas, porque incluye absolutamente todas
            // las posibilidades de desplazamiento que ya incluían aquellas. Su funcionamiento, además de este añadido, es muy similar al del resto de piezas.
            if(pieza instanceof Reina){
                int [][] DesplazamientosReina = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
                for (int [] Desplazamiento : DesplazamientosReina){
                    int NuevaFila = Desplazamiento[0];
                    int NuevaColumna = Desplazamiento[1];
                    while (NuevaFila >= 0 && NuevaFila < 8 && NuevaColumna >= 0 && NuevaColumna < 8 && Tablero[NuevaFila][NuevaColumna] == null){
                        Movimiento DesplazamientoReina = new Movimiento(NuevaFila,NuevaColumna, fila, columna,false);
                        movimientosPosibles.add(DesplazamientoReina);
                        if (Tablero[NuevaFila][NuevaColumna].getColor() == IPieza.BLANCO){
                            Movimiento PuedeComer = new Movimiento(NuevaFila,NuevaColumna, fila, columna, true);
                            NuevaFila += Desplazamiento[0];
                            NuevaColumna += Desplazamiento[1];
                            movimientosPosibles.add(PuedeComer);
                        }
                        NuevaFila += Desplazamiento[0];
                        NuevaColumna += Desplazamiento[1];
                    }
                }

            }

            if (pieza instanceof Rey){
                int [][] DesplazamientosRey ={{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
                for (int [] Desplazamiento : DesplazamientosRey){
                    int NuevaFila = Desplazamiento[0];
                    int NuevaColumna = Desplazamiento[1];
                    if(Tablero[NuevaFila][NuevaColumna] == null){
                        Movimiento DesplazamientoRey = new Movimiento(NuevaFila, NuevaColumna, fila, columna, false);
                    }

                }
            }

        return movimientosPosibles;
    }

    /**
     * Dado que el método MovimientoPieza solo devuelve todos los movimientos posibles para una pieza, es necesario crear otro método capaz de recoger
     * todas las posibilidades de todas las piezas. De alguna manera, esto es simplemente una lista de listas. Para cada lista de movimientos de una sola
     * pieza, se crean listas de todas las piezas.
     * @param Tablero, para saber qué pieza está en dónde y recoger sus posibles movimientos.
     * @return MovimientosCompletos, un ArrayList de ArrayLists.
     */
    public List<Movimiento> MovimientosCompletos(Pieza [][] Tablero){
        List<Movimiento> MovimientosCompletos = new ArrayList<>();

        for (int fila = 0; fila < 8; fila ++){
            for (int columna = 0; columna < 8; columna ++){
                Pieza piezaAux = Tablero[fila][columna];
                List<Movimiento> MovimientosPieza = MovimientoPieza(Tablero,fila,columna);
                MovimientosCompletos.addAll(MovimientosPieza);
            }
        }
        return MovimientosCompletos;
    }

    public Pieza [][] realizarMovimiento (Pieza[][] Tablero, Movimiento movimiento){
        Automata Copia = new Automata();
        Pieza [][] nuevoTablero = Copia.copiarTablero(Tablero);
        int filaOrigen = movimiento.getFilaOrigen();
        int filaDestino = movimiento.getFilaDestino();
        int columnaOrigen = movimiento.getColumnaOrigen();
        int columnaDestino = movimiento.getColumnaDestino();
        Pieza piezaAMover = nuevoTablero[filaDestino][columnaDestino];
        nuevoTablero[filaDestino][columnaDestino] = piezaAMover;
        nuevoTablero[filaOrigen][columnaOrigen] = null;

        return nuevoTablero;
    }

    public Pieza[][] MovimientoFinal(Pieza[][] Tablero, Movimiento movimiento){
        Tablero[movimiento.getFilaOrigen()][movimiento.columnaOrigen] = Tablero[movimiento.getFilaDestino()][movimiento.getColumnaDestino()];

        return Tablero;
    }
  
    public int getColumnaDestino() {
        return columnaDestino;
    }

    public int getColumnaOrigen() {
        return columnaOrigen;
    }

    public int getFilaDestino() {
        return filaDestino;
    }

    public int getFilaOrigen() {
        return filaOrigen;
    }

    public void setColumnaDestino(int columnaDestino) {
        this.columnaDestino = columnaDestino;
    }

    public void setColumnaOrigen(int columnaOrigen) {
        this.columnaOrigen = columnaOrigen;
    }

    public void setFilaDestino(int filaDestino) {
        this.filaDestino = filaDestino;
    }

    public void setFilaOrigen(int filaOrigen) {
        this.filaOrigen = filaOrigen;
    }

    public boolean esJaqueJugador(Pieza[][] Tablero){
        Movimiento movimiento = new Movimiento();
        boolean Jaque = false;
        int FilaRey = 0;
        int ColumnaRey = 0;
        List<Movimiento> movimientos = movimiento.MovimientosCompletos(Tablero);
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if(Tablero[i][j] instanceof Rey){
                    Pieza pieza = Tablero[i][j];
                    if(pieza.getColor() == IPieza.NEGRO){
                        FilaRey = i;
                        ColumnaRey = j;
                    }
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

    public boolean JaqueMateJugador(Pieza [][] Tablero, boolean jaque){
        Automata automata = new Automata();
        int contador = 0;
        int NoEsJaqueMate = 0;
        boolean JaqueMate = false;
        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (Tablero[i][j] instanceof Rey && Tablero[i][j].getColor() == IPieza.NEGRO){
                        List <Movimiento> MovimientosRey = MovimientoPieza(Tablero,i,j);
                        Pieza [][] TableroCopiado = automata.copiarTablero(Tablero);
                        for(Movimiento movimiento : MovimientosRey){
                            TableroCopiado = realizarMovimiento(TableroCopiado,movimiento);
                            jaque = esJaqueJugador(TableroCopiado);
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




