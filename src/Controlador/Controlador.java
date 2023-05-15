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
        // pieza = modelo.moverPieza(pieza, posicionInicial);
        System.out.println("Mover pieza de la posición "+posicionInicial[0]+" "+posicionInicial[1]+ " a la posición "+posicionNueva[0]+" "+posicionNueva[1]);

        Pieza[][] matrizPiezas = modelo.moverPieza(posicionInicial, posicionNueva);

        System.out.println(matrizPiezas[0][1]+" "+matrizPiezas[0][2]);

        modelo.asignarMatriz();

        vista.actualizarTablero();

    }

}