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
    public static ObserverMovimientos observerMovimientos = new ObserverMovimientos();

    public static void main(String[] args) {

        modelo.addObserver(observerMovimientos);

        vista.LlamadaMenuP();
      
    }

    /**
     * Proporciona las posiciones iniciales
     * @return Matriz con las posiciones iniciales
     */
    public static Pieza[][] iniciarPartida() {
        return modelo.posicionesIniciales();
    }

    /**
     * Proporciona las posiciones actuales
     * @return Matriz con las posiciones actuales
     */
    public static Pieza[][] posicionesActuales() {
        return modelo.obtenerMatriz();
    }

    /**
     * Llamada para mover las piezas
     * @param posicionInicial Posicion de la pieza a mover
     * @param posicionNueva Posicion deseada a la que desplazarse
     */
    public static void moverPieza(Integer[] posicionInicial, Integer[] posicionNueva) {

        modelo.moverPieza(posicionInicial, posicionNueva);

    }

    public static void actualizarTablero() {

        vista.actualizarTablero(); // TODO pasar esto a observador

    }
}