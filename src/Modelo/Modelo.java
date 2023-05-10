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
        this.peonB1 = new Peon("blanco",6,0);
        this.peonB2 = new Peon("blanco",6,1);
        this.peonB3 = new Peon("blanco",6,2);
        this.peonB4 = new Peon("blanco",6,3);
        this.peonB5 = new Peon("blanco",6,4);
        this.peonB6 = new Peon("blanco",6,5);
        this.peonB7 = new Peon("blanco",6,6);
        this.peonB8 = new Peon("blanco",6,7);
        // Instanciamos torres blancas
        this.torreB1 = new Torre("blanco",7,0);
        this.torreB2 = new Torre("blanco",7,7);
        // Instanciamos caballos blancos
        this.caballoB1 = new Caballo("blanco",7,1);
        this.caballoB2 = new Caballo("blanco",7,6);
        // Instanciamos alfiles blancos
        this.alfilB1 = new Alfil("blanco",7,2);
        this.alfilB2 = new Alfil("blanco",7,5);
        // Instanciamos reina blanca
        this.reinaB1 = new Reina("blanco",7,3);
        // Instanciamos rey blanco
        this.reyB = new Rey("blanco",7,4);

        // Instanciamos peones negros
        this.peonN1 = new Peon("negro",1,0);
        this.peonN2 = new Peon("negro",1,1);
        this.peonN3 = new Peon("negro",1,2);
        this.peonN4 = new Peon("negro",1,3);
        this.peonN5 = new Peon("negro",1,4);
        this.peonN6 = new Peon("negro",1,5);
        this.peonN7 = new Peon("negro",1,6);
        this.peonN8 = new Peon("negro",1,7);
        // Instanciamos torres negras
        this.torreN1 = new Torre("negro",0,0);
        this.torreN2 = new Torre("negro",0,7);
        // Instanciamos caballos negros
        this.caballoN1 = new Caballo("negro",0,1);
        this.caballoN2 = new Caballo("negro",0,6);
        // Instanciamos alfiles negros
        this.alfilN1 = new Alfil("negro",0,2);
        this.alfilN2 = new Alfil("negro",0,5);
        // Instanciamos reina negra
        this.reinaN1 = new Reina("negro",0,3);
        // Instanciamos rey negro
        this.reyN = new Rey("negro",0,4);

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
    public boolean moverPieza() {

        // setPosicion
        return true;
    }
}
