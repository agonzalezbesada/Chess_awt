package Controlador;

import Modelo.Modelo;
import Modelo.Pieza;
import Vista.Vista;

/**
 * Controlador
 */
public class Controlador {

    public static Modelo modelo = new Modelo();
    public static Vista vista = new Vista();

    public static void main(String[] args) {

        vista.LlamadaMenuP();


    }

    public static Pieza[][] posicionesIniciales() {
        return modelo.iniciarPartida();
    }

    public static void moverPieza(Integer[] posicionActual, Integer[] posicionNueva) {
        // pieza = modelo.moverPieza(pieza, posicionActual);
        System.out.println("Mover pieza de la posición "+posicionActual[0]+" "+posicionActual[1]+ " a la posición "+posicionNueva[0]+" "+posicionNueva[1]);
    }

}