package Modelo;

/**
 * Modelo
 */
public class Modelo {

    public Pieza peonB1;
    public Pieza peonB2;
    public Pieza peonB3;
    public Pieza peonB4;
    public Pieza peonB5;
    public Pieza peonB6;
    public Pieza peonB7;
    public Pieza peonB8;
    public Pieza torreB1;
    public Pieza torreB2;
    public Pieza caballoB1;
    public Pieza caballoB2;
    public Pieza alfilB1;
    public Pieza alfilB2;
    public Pieza reinaB;
    public Pieza reyB;


    public Pieza peonN1;
    public Pieza peonN2;
    public Pieza peonN3;
    public Pieza peonN4;
    public Pieza peonN5;
    public Pieza peonN6;
    public Pieza peonN7;
    public Pieza peonN8;
    public Pieza torreN1;
    public Pieza torreN2;
    public Pieza caballoN1;
    public Pieza caballoN2;
    public Pieza alfilN1;
    public Pieza alfilN2;
    public Pieza reinaN;
    public Pieza reyN;

    /**
     *
     * @return Matriz con las piezas
     */
    public Pieza[][] iniciarPartida() {
        Pieza[][] matrizPiezas = crearPiezas();
        return matrizPiezas;
    }

    /**
     * Termina la partida
     * @return
     */
    public boolean terminarPartida() {
        destruirPiezas();
        return true;
    }

    /**
     * Crea las piezas
     * @return Matriz con las piezas
     */
    public Pieza[][] crearPiezas() {

        Pieza[][] matrizPiezas = new Pieza[8][8];

        // Instanciamos peones blancos
        this.peonB1 = new Peon(0,"PB1",6,0);
        this.peonB2 = new Peon(0, "PB2", 6,1);
        this.peonB3 = new Peon(0, "PB3", 6,2);
        this.peonB4 = new Peon(0, "PB4", 6,3);
        this.peonB5 = new Peon(0, "PB5", 6,4);
        this.peonB6 = new Peon(0, "PB6", 6,5);
        this.peonB7 = new Peon(0, "PB7", 6,6);
        this.peonB8 = new Peon(0, "PB8", 6,7);
        // Instanciamos torres blancas
        this.torreB1 = new Torre(0,"TB1",7,0);
        this.torreB2 = new Torre(0,"TB2",7,7);
        // Instanciamos caballos blancos
        this.caballoB1 = new Caballo(0,"CB1",7,1);
        this.caballoB2 = new Caballo(0,"CB2",7,6);
        // Instanciamos alfiles blancos
        this.alfilB1 = new Alfil(0,"AB1",7,2);
        this.alfilB2 = new Alfil(0,"AB2",7,5);
        // Instanciamos reina blanca
        this.reinaB = new Reina(0,"ReinaB",7,4);
        // Instanciamos rey blanco
        this.reyB = new Rey(0,"ReyB",7,3);

        // Instanciamos peones negros
        this.peonN1 = new Peon(1,"PN1",1,0);
        this.peonN2 = new Peon(1, "PN2",1,1);
        this.peonN3 = new Peon(1, "PN3",1,2);
        this.peonN4 = new Peon(1, "PN4",1,3);
        this.peonN5 = new Peon(1, "PN5",1,4);
        this.peonN6 = new Peon(1, "PN6",1,5);
        this.peonN7 = new Peon(1, "PN7",1,6);
        this.peonN8 = new Peon(1, "PN8",1,7);
        // Instanciamos torres negras
        this.torreN1 = new Torre(1,"TN1",0,0);
        this.torreN2 = new Torre(1,"TN2",0,7);
        // Instanciamos caballos negros
        this.caballoN1 = new Caballo(1,"CN1",0,1);
        this.caballoN2 = new Caballo(1,"CN2",0,6);
        // Instanciamos alfiles negros
        this.alfilN1 = new Alfil(1,"AN1",0,2);
        this.alfilN2 = new Alfil(1,"AN2",0,5);
        // Instanciamos reina negra
        this.reinaN = new Reina(1,"ReinaN",0,4);
        // Instanciamos rey negro
        this.reyN = new Rey(1,"ReyN",0,3);

        matrizPiezas[6][0] = peonB1;
        matrizPiezas[6][1] = peonB2;
        matrizPiezas[6][2] = peonB3;
        matrizPiezas[6][3] = peonB4;
        matrizPiezas[6][4] = peonB5;
        matrizPiezas[6][5] = peonB6;
        matrizPiezas[6][6] = peonB7;
        matrizPiezas[6][7] = peonB8;
        matrizPiezas[7][0] = torreB1;
        matrizPiezas[7][7] = torreB2;
        matrizPiezas[7][1] = caballoB1;
        matrizPiezas[7][6] = caballoB2;
        matrizPiezas[7][2] = alfilB1;
        matrizPiezas[7][5] = alfilB2;
        matrizPiezas[7][4] = reinaB;
        matrizPiezas[7][3] = reyB;

        matrizPiezas[1][0] = peonN1;
        matrizPiezas[1][1] = peonN2;
        matrizPiezas[1][2] = peonN3;
        matrizPiezas[1][3] = peonN4;
        matrizPiezas[1][4] = peonN5;
        matrizPiezas[1][5] = peonN6;
        matrizPiezas[1][6] = peonN7;
        matrizPiezas[1][7] = peonN8;
        matrizPiezas[0][0] = torreN1;
        matrizPiezas[0][7] = torreN2;
        matrizPiezas[0][1] = caballoN1;
        matrizPiezas[0][6] = caballoN2;
        matrizPiezas[0][2] = alfilN1;
        matrizPiezas[0][5] = alfilN2;
        matrizPiezas[0][4] = reinaN;
        matrizPiezas[0][3] = reyN;

        return matrizPiezas;
    }

    /**
     * Destruye las piezas
     * @return
     */
    public boolean destruirPiezas() {


        // Eliminamos peones blancos
        this.peonB1 = null;
        this.peonB2 = null;
        this.peonB3 = null;
        this.peonB4 = null;
        this.peonB5 = null;
        this.peonB6 = null;
        this.peonB7 = null;
        this.peonB8 = null;
        // Eliminamos torres blancas
        this.torreB1 = null;
        this.torreB2 = null;
        // Eliminamos caballos blancos
        this.caballoB1 = null;
        this.caballoB2 = null;
        // Eliminamos alfiles blancos
        this.alfilB1 = null;
        this.alfilB2 = null;
        // Eliminamos reina blanca
        this.reinaB = null;
        // Eliminamos rey blanco
        this.reyB = null;

        // Eliminamos peones negros
        this.peonN1 = null;
        this.peonN2 = null;
        this.peonN3 = null;
        this.peonN4 = null;
        this.peonN5 = null;
        this.peonN6 = null;
        this.peonN7 = null;
        this.peonN8 = null;
        // Eliminamos torres negras
        this.torreN1 = null;
        this.torreN2 = null;
        // Eliminamos caballos negros
        this.caballoN1 = null;
        this.caballoN2 = null;
        // Eliminamos alfiles negros
        this.alfilN1 = null;
        this.alfilN2 = null;
        // Eliminamos reina negra
        this.reinaN = null;
        // Eliminamos rey negro
        this.reyN = null;

        return true;
    }

    /**
     * Destruye una pieza concreta
     * @param pieza
     * @return
     */
    public boolean destruirPieza(IPieza pieza) {

        // Eliminamos la pieza
        pieza = null;

        return true;
    }

    /**
     * Mueve una pieza
     * @param pieza Pieza a mover
     * @param posicionActual Posición actual de la pieza
     * @return Devuelve la pieza
     */
    public Pieza moverPieza(Pieza pieza, int[] posicionActual) {

        pieza.cambiarPosicion();

        return pieza;
    }
}