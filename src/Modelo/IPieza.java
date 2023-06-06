package Modelo;

/**
 * Interfaz para las piezas
 */
public interface IPieza {

    /**
     * Método que evalúa y realiza el movimiento de la pieza
     * @param posicionNueva Posición de destino
     * @param matrizPiezas Matriz de piezas
     * @return Nueva posición para la pieza
     */
    Integer[] cambiarPosicion(Integer[] posicionNueva, Pieza[][] matrizPiezas);

    /**
     * Literal que identifica las piezas blancas
     */
    final Integer BLANCO = 0;
    /**
     * Literal que identifica las piezas negras
     */
    final Integer NEGRO = 1;

}