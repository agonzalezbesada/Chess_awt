package Modelo;

public class Peon extends Pieza implements IPieza {

    Peon() {

    }

    Peon(String color, int[] posicion) {
        setColor(color);
        setPosicion(posicion);
    }

    // Quizás innecesario
    @Override
    public int[] cambiarPosicion() {

        // Porceso lógico

        // if true setPosicon(nuevaPosicion);

        return new int[0];
    }
}