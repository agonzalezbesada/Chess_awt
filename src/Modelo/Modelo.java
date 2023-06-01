package Modelo;

import javax.swing.*;
import java.util.Observable;

/**
 * Modelo
 */
public class Modelo extends Observable {

    public BD bd = new BD();
    public Jugador jugador;
    public Integer turno;
    public Partida partida = null;
    public Guardado guardado = new Guardado();
    public Automata automata = new Automata();
    public Movimiento movimiento = new Movimiento();

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

    public Pieza[][] matrizPiezas;

    /**
     *
     * @return Matriz con las piezas
     */
    public Pieza[][] posicionesIniciales() {
        matrizPiezas = null;
        crearPiezas();

        this.turno = 0;

        return asignarMatriz();
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
     */
    public void crearPiezas() {

        // Instanciamos peones blancos
        this.peonB1 = new Peon(0,"PB1",0,6);
        this.peonB2 = new Peon(0, "PB2", 1,6);
        this.peonB3 = new Peon(0, "PB3", 2,6);
        this.peonB4 = new Peon(0, "PB4", 3,6);
        this.peonB5 = new Peon(0, "PB5", 4,6);
        this.peonB6 = new Peon(0, "PB6", 5,6);
        this.peonB7 = new Peon(0, "PB7", 6,6);
        this.peonB8 = new Peon(0, "PB8", 7,6);
        // Instanciamos torres blancas
        this.torreB1 = new Torre(0,"TB1",0,7);
        this.torreB2 = new Torre(0,"TB2",7,7);
        // Instanciamos caballos blancos
        this.caballoB1 = new Caballo(0,"CB1",1,7);
        this.caballoB2 = new Caballo(0,"CB2",6,7);
        // Instanciamos alfiles blancos
        this.alfilB1 = new Alfil(0,"AB1",2,7);
        this.alfilB2 = new Alfil(0,"AB2",5,7);
        // Instanciamos reina blanca
        this.reinaB = new Reina(0,"ReinaB",4,7);
        // Instanciamos rey blanco
        this.reyB = new Rey(0,"ReyB",3,7);

        // Instanciamos peones negros
        this.peonN1 = new Peon(1,"PN1",0,1);
        this.peonN2 = new Peon(1, "PN2",1,1);
        this.peonN3 = new Peon(1, "PN3",2,1);
        this.peonN4 = new Peon(1, "PN4",3,1);
        this.peonN5 = new Peon(1, "PN5",4,1);
        this.peonN6 = new Peon(1, "PN6",5,1);
        this.peonN7 = new Peon(1, "PN7",6,1);
        this.peonN8 = new Peon(1, "PN8",7,1);
        // Instanciamos torres negras
        this.torreN1 = new Torre(1,"TN1",0,0);
        this.torreN2 = new Torre(1,"TN2",7,0);
        // Instanciamos caballos negros
        this.caballoN1 = new Caballo(1,"CN1",1,0);
        this.caballoN2 = new Caballo(1,"CN2",6,0);
        // Instanciamos alfiles negros
        this.alfilN1 = new Alfil(1,"AN1",2,0);
        this.alfilN2 = new Alfil(1,"AN2",5,0);
        // Instanciamos reina negra
        this.reinaN = new Reina(1,"ReinaN",4,0);
        // Instanciamos rey negro
        this.reyN = new Rey(1,"ReyN",3,0);

    }

    public Pieza[][] asignarMatriz() {

        matrizPiezas = new Pieza[8][8];

        this.matrizPiezas[peonB1.getPosicion()[0]][peonB1.getPosicion()[1]] = peonB1;
        this.matrizPiezas[peonB2.getPosicion()[0]][peonB2.getPosicion()[1]] = peonB2;
        this.matrizPiezas[peonB3.getPosicion()[0]][peonB3.getPosicion()[1]] = peonB3;
        this.matrizPiezas[peonB4.getPosicion()[0]][peonB4.getPosicion()[1]] = peonB4;
        this.matrizPiezas[peonB5.getPosicion()[0]][peonB5.getPosicion()[1]] = peonB5;
        this.matrizPiezas[peonB6.getPosicion()[0]][peonB6.getPosicion()[1]] = peonB6;
        this.matrizPiezas[peonB7.getPosicion()[0]][peonB7.getPosicion()[1]] = peonB7;
        this.matrizPiezas[peonB8.getPosicion()[0]][peonB8.getPosicion()[1]] = peonB8;
        this.matrizPiezas[torreB1.getPosicion()[0]][torreB1.getPosicion()[1]] = torreB1;
        this.matrizPiezas[torreB2.getPosicion()[0]][torreB2.getPosicion()[1]] = torreB2;
        this.matrizPiezas[caballoB1.getPosicion()[0]][caballoB1.getPosicion()[1]] = caballoB1;
        this.matrizPiezas[caballoB2.getPosicion()[0]][caballoB2.getPosicion()[1]] = caballoB2;
        this.matrizPiezas[alfilB1.getPosicion()[0]][alfilB1.getPosicion()[1]] = alfilB1;
        this.matrizPiezas[alfilB2.getPosicion()[0]][alfilB2.getPosicion()[1]] = alfilB2;
        this.matrizPiezas[reinaB.getPosicion()[0]][reinaB.getPosicion()[1]] = reinaB;
        this.matrizPiezas[reyB.getPosicion()[0]][reyB.getPosicion()[1]] = reyB;

        this.matrizPiezas[peonN1.getPosicion()[0]][peonN1.getPosicion()[1]] = peonN1;
        this.matrizPiezas[peonN2.getPosicion()[0]][peonN2.getPosicion()[1]] = peonN2;
        this.matrizPiezas[peonN3.getPosicion()[0]][peonN3.getPosicion()[1]] = peonN3;
        this.matrizPiezas[peonN4.getPosicion()[0]][peonN4.getPosicion()[1]] = peonN4;
        this.matrizPiezas[peonN5.getPosicion()[0]][peonN5.getPosicion()[1]] = peonN5;
        this.matrizPiezas[peonN6.getPosicion()[0]][peonN6.getPosicion()[1]] = peonN6;
        this.matrizPiezas[peonN7.getPosicion()[0]][peonN7.getPosicion()[1]] = peonN7;
        this.matrizPiezas[peonN8.getPosicion()[0]][peonN8.getPosicion()[1]] = peonN8;
        this.matrizPiezas[torreN1.getPosicion()[0]][torreN1.getPosicion()[1]] = torreN1;
        this.matrizPiezas[torreN2.getPosicion()[0]][torreN2.getPosicion()[1]] = torreN2;
        this.matrizPiezas[caballoN1.getPosicion()[0]][caballoN1.getPosicion()[1]] = caballoN1;
        this.matrizPiezas[caballoN2.getPosicion()[0]][caballoN2.getPosicion()[1]] = caballoN2;
        this.matrizPiezas[alfilN1.getPosicion()[0]][alfilN1.getPosicion()[1]] = alfilN1;
        this.matrizPiezas[alfilN2.getPosicion()[0]][alfilN2.getPosicion()[1]] = alfilN2;
        this.matrizPiezas[reinaN.getPosicion()[0]][reinaN.getPosicion()[1]] = reinaN;
        this.matrizPiezas[reyN.getPosicion()[0]][reyN.getPosicion()[1]] = reyN;

        return matrizPiezas;
    }

    public Pieza[][] obtenerMatriz() {
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

    public Pieza[][] obtenerPiezas() {
        return matrizPiezas;
    }

    /**
     * Cambia la posicion de una pieza
     * @param posicionInicial Posicion actual de la pieza
     * @param posicionNueva Posicion final de la pieza
     * @return Devuelve la pieza
     */
    public boolean moverPieza(Integer[] posicionInicial, Integer[] posicionNueva) {

        System.out.println("Posicion inicial 0 "+posicionInicial[0]);
        System.out.println("Posicion inicial 1 "+posicionInicial[1]);

        Integer[] posicionFinal = null;

        /*
        Comprueba que la pieza seleccionada coincide con las piezas de ese jugador basandose en el color de la pieza y en el turno.
        Y a su vez comprueba que no se está intentando comer una pieza propia
         */
        if ((matrizPiezas[posicionInicial[0]][posicionInicial[1]].getColor() == IPieza.BLANCO) && (matrizPiezas[posicionNueva[0]][posicionNueva[1]] == null || matrizPiezas[posicionNueva[0]][posicionNueva[1]].getColor() != IPieza.BLANCO) && this.turno % 2 == 0) {
            posicionFinal =  this.matrizPiezas[posicionInicial[0]][posicionInicial[1]].cambiarPosicion(posicionNueva,matrizPiezas);

        } else if ((matrizPiezas[posicionInicial[0]][posicionInicial[1]].getColor() == IPieza.NEGRO) && (matrizPiezas[posicionNueva[0]][posicionNueva[1]] == null || matrizPiezas[posicionNueva[0]][posicionNueva[1]].getColor() != IPieza.NEGRO) && this.turno % 2 != 0) {
            posicionFinal =  this.matrizPiezas[posicionInicial[0]][posicionInicial[1]].cambiarPosicion(posicionNueva,matrizPiezas);

        }


        if (posicionFinal != null ) {

            this.matrizPiezas[posicionFinal[0]][posicionFinal[1]] = null;

            this.matrizPiezas[posicionFinal[0]][posicionFinal[1]] = this.matrizPiezas[posicionInicial[0]][posicionInicial[1]];

            System.out.println("Despues del =\n"+posicionFinal[0]+" "+posicionFinal[1]);

            this.matrizPiezas[posicionInicial[0]][posicionInicial[1]] = null;

            setChanged();

            notifyObservers();

            this.turno ++;

        }

        // Recorre el tablero en busqueda de los reyes para determinar el fin de la partida

        boolean isReyN = false;
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {

                if (matrizPiezas[col][row]!=null && matrizPiezas[col][row].getNombre().equals("ReyN")) {
                    isReyN = true;
                }

            }
        }

        if (!isReyN) {
            JOptionPane.showMessageDialog(null,"Gana el jugador blanco");
        }

        boolean isReyB = false;
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {

                if (matrizPiezas[col][row]!=null && matrizPiezas[col][row].getNombre().equals("ReyB")) {
                    isReyB = true;
                }

            }
        }

        if (!isReyB) {
            JOptionPane.showMessageDialog(null,"Gana el jugador negro");
        }

        return true;
    }

    public void cambiarTurno() {
        turno ++;
    }

    public void turnoMaquina() {
        int alfa = Integer.MAX_VALUE;
        int beta = Integer.MIN_VALUE;
        automata.Minimax(turno,matrizPiezas,alfa,beta,true);
    }

    public boolean iniciarSesion(String nickName) {

        String[] sesionIniciada = new String[5];
        sesionIniciada = bd.consultar("SELECT * FROM jugadores WHERE nickName = '"+nickName+"';");
        jugador = new Jugador(sesionIniciada[0],sesionIniciada[1],sesionIniciada[2],sesionIniciada[3],sesionIniciada[4]);

        if (sesionIniciada[0]==null) {
            return false;
        }

        return true;
    }

    public boolean registrarUsuario(String nickName) {

        return bd.registrar("INSERT INTO jugadores (NickName) VALUES ('"+nickName+"');");
    }

    public String[] obtenerDatos() {
        return jugador.obtenerDatos();
    }

    public void guardarPartida() {
        partida = new Partida();

        partida.nickName = jugador.getNickName();
        partida.estadoPartida = matrizPiezas;
        partida.turno = turno;

        guardado.guardarPartida(partida);

        partida = null;
    }

    public void cargarPartida() {
        partida = guardado.cargarPartida(jugador.getNickName());
        matrizPiezas = partida.estadoPartida;
    }
}