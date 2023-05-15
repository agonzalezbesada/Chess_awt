package Modelo;

/**
 * Interfaz para las piezas
 */
public interface IPieza {

    // Quizás innecesario
    Integer[] cambiarPosicion(Integer[] posicionNueva);

    // Quizás innecesario
    boolean destruirPieza();

    final Integer BLANCO = 0;
    final Integer NEGRO = 1;

}
