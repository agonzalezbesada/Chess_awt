package Controlador;

import Modelo.Modelo;
import Modelo.Pieza;
import Vista.Vista;

import javax.swing.*;

/**
 * Controlador
 */
public class Controlador {

    public static Modelo modelo = new Modelo();
    public static Vista vista = new Vista();

    public static void main(String[] args) {

        vista.LlamadaMenuP();
      
    }

    /**
     * Proporciona las posiciones iniciales
     * @return Matriz con las posiciones iniciales
     */
    public static Pieza[][] posicionesIniciales() {
        return modelo.iniciarPartida();
    }

    /**
     * Proporciona las posiciones actuales
     * @return Matriz con las posiciones actuales
     */
    public static Pieza[][] posicionesActuales() {
        return modelo.asignarMatriz();
    }

    /**
     * Lammada para mover las piezas
     * @param posicionInicial Posicion de la pieza a mover
     * @param posicionNueva Posicion deseada a la que desplazarse
     */
    public static void moverPieza(Integer[] posicionInicial, Integer[] posicionNueva) {

        modelo.moverPieza(posicionInicial, posicionNueva);

        vista.actualizarTablero();

    }
}