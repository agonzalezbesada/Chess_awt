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
    public Reina(Integer color, String nombre, int x, int y) {
        setColor(color);
        setNombre(nombre);
        int[] posicion = new int[2];
        posicion[0] = x;
        posicion[1] = y;
        setPosicion(posicion);
    }

    @Override
    public int[] cambiarPosicion() {

        boolean isValido;
        int [] nuevaPosicion = new int[2];
        // nuevaPosicion[0]
        // nuevaPosicion[1]

        if (nuevaPosicion[0] > getPosicion()[0] && nuevaPosicion[1] == getPosicion()[1]) {
            isValido = true;
        } else if (nuevaPosicion[0] < getPosicion()[0] && nuevaPosicion[1] == getPosicion()[1]) {
            isValido = true;
        } else if (nuevaPosicion[1] > getPosicion()[1] && nuevaPosicion[0] == getPosicion()[0]) {
            isValido = true;
        } else if (nuevaPosicion[1] < getPosicion()[1] && nuevaPosicion[0] == getPosicion()[0]) {
            isValido = true;
        }

        // Falta diagonal

        return new int[0];
    }
}