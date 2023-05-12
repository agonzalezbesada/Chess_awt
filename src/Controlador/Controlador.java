package Controlador;

import Modelo.Modelo;
import Modelo.Pieza;
import Vista.Vista;
import java.util.ArrayList;

public class Controlador {

    public static Modelo modelo = new Modelo();
    public static Vista vista = new Vista();

    public static void main(String[] args) {

        vista.LlamadaMenuP();


    }

    public static Pieza[][] posicionesIniciales() {
        return modelo.iniciarPartida();
    }

    public static Pieza moverPieza(Pieza pieza, int[] posicionActual) {
        pieza = modelo.moverPieza(pieza, posicionActual);
        System.out.println("Hola");
        return pieza;
    }

    public static void selecionarDesplazamiento(int[] posicionActual, int[] nuevaPosicion) {

        System.out.println(posicionActual);
        System.out.println(nuevaPosicion);




    }

}