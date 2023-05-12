package Modelo;

/**
 * Pieza Peon
 */
public class Peon extends Pieza implements IPieza {

    /**
     * Constructor vacío
     */
    public Peon() {

    }

    /**
     * Constructor parametrizado
     * @param color Color de la pieza
     * @param nombre Nombre de la pieza
     * @param x Fila
     * @param y Columna
     */
    public Peon(String color, String nombre, int x, int y) {
        setColor(color);
        setNombre(nombre);
        int[] posicion = new int[2];
        posicion[0] = x;
        posicion[1] = y;
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