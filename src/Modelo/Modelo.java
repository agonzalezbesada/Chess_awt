package Modelo;

public class Modelo {

    public IPieza peonB1;
    public IPieza peonB2;
    public IPieza peonB3;
    public IPieza peonB4;
    public IPieza peonB5;
    public IPieza peonB6;
    public IPieza peonB7;
    public IPieza peonB8;
    public IPieza torreB1;
    public IPieza torreB2;
    public IPieza caballoB1;
    public IPieza caballoB2;
    public IPieza alfilB1;
    public IPieza alfilB2;
    public IPieza reinaB1;
    public IPieza reyB;


    public IPieza peonN1;
    public IPieza peonN2;
    public IPieza peonN3;
    public IPieza peonN4;
    public IPieza peonN5;
    public IPieza peonN6;
    public IPieza peonN7;
    public IPieza peonN8;
    public IPieza torreN1;
    public IPieza torreN2;
    public IPieza caballoN1;
    public IPieza caballoN2;
    public IPieza alfilN1;
    public IPieza alfilN2;
    public IPieza reinaN1;
    public IPieza reyN;

    public boolean iniciarPartida() {
        crearPiezas();
        return true;
    }

    public boolean terminarPartida() {
        destruirPiezas();
        return true;
    }

    public boolean crearPiezas() {

        // Instanciamos peones blancos
        this.peonB1 = new Peon();
        this.peonB2 = new Peon();
        this.peonB3 = new Peon();
        this.peonB4 = new Peon();
        this.peonB5 = new Peon();
        this.peonB6 = new Peon();
        this.peonB7 = new Peon();
        this.peonB8 = new Peon();
        // Instanciamos torres blancas
        this.torreB1 = new Torre();
        this.torreB2 = new Torre();
        // Instanciamos caballos blancos
        this.caballoB1 = new Caballo();
        this.caballoB2 = new Caballo();
        // Instanciamos alfiles blancos
        this.alfilB1 = new Alfil();
        this.alfilB2 = new Alfil();
        // Instanciamos reina blanca
        this.reinaB1 = new Reina();
        // Instanciamos rey blanco
        this.reyB = new Rey();

        // Instanciamos peones negros
        this.peonN1 = new Peon();
        this.peonN2 = new Peon();
        this.peonN3 = new Peon();
        this.peonN4 = new Peon();
        this.peonN5 = new Peon();
        this.peonN6 = new Peon();
        this.peonN7 = new Peon();
        this.peonN8 = new Peon();
        // Instanciamos torres negras
        this.torreN1 = new Torre();
        this.torreN2 = new Torre();
        // Instanciamos caballos negros
        this.caballoN1 = new Caballo();
        this.caballoN2 = new Caballo();
        // Instanciamos alfiles negros
        this.alfilN1 = new Alfil();
        this.alfilN2 = new Alfil();
        // Instanciamos reina negra
        this.reinaN1 = new Reina();
        // Instanciamos rey negro
        this.reyN = new Rey();

        return true;
    }

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
        this.reinaB1 = null;
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
        this.reinaN1 = null;
        // Eliminamos rey negro
        this.reyN = null;

        return true;
    }

    public boolean destruirPieza(IPieza pieza) {

        // Eliminamos la pieza
        pieza = null;

        return true;
    }
    // Añadir entradas (objeto pieza, posicionActual?)
    public boolean moverPieza(Pieza pieza, int[] posicionActual) {

        pieza.setPosicion(posicionActual);

        return true;
    }
}
