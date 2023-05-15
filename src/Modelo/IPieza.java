package Modelo;

/**
 * Interfaz para las piezas
 */
public interface IPieza {

    // Quizás innecesario
    int[] cambiarPosicion();

    // Quizás innecesario
    boolean destruirPieza();

    final Integer BLANCO = 0;
    final Integer NEGRO = 1;

}
