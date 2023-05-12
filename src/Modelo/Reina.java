package Modelo;

/**
 * Pieza Reina
 */
public class Reina extends Pieza implements IPieza {

    /**
     * Constructor vacío
     */
    public Reina() {

    }

    /**
     * Constructor parametrizado
     * @param color Color de la pieza
     * @param nombre Nombre de la pieza
     * @param x Fila
     * @param y Columna
     */
    public Reina(String color, String nombre, int x, int y) {
        setColor(color);
        setNombre(nombre);
        int[] posicion = new int[2];
        posicion[0] = x;
        posicion[1] = y;
        setPosicion(posicion);
    }

    @Override
    public int[] cambiarPosicion() {
        return new int[0];
    }
}