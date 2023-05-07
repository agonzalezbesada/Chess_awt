package Modelo;

public class Peon extends Pieza implements IPieza {

    Peon() {

    }

    Peon(String color, int x, int y) {
        int[] posicion = new int[2];
        posicion[0] = x;
        posicion[1] = y;
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