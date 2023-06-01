package Modelo;

/**
 * Interfaz para las piezas
 */
public interface IPieza {

    Integer[] cambiarPosicion(Integer[] posicionNueva, Pieza[][] matrizPiezas);


    final Integer BLANCO = 0;
    final Integer NEGRO = 1;

}