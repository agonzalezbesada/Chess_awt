package Modelo;

/**
 * Pieza Torre
 */
public class Torre extends Pieza implements IPieza {

    /**
     * Constructor vacío
     */
    public Torre() {

    }

    /**
     * Constructor parametrizado
     * @param color Color de la pieza
     * @param nombre Nombre de la pieza
     * @param x Fila
     * @param y Columna
     */
    public Torre(Integer color, String nombre, int x, int y) {
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

        // || nuevaPosicion[0] > 9 && nuevaPosicion[1] > 9 ...

        if (nuevaPosicion[0] < getPosicion()[0] && nuevaPosicion[1] == getPosicion()[1]) {
            isValido = true;
        } else if (nuevaPosicion[0] == getPosicion()[0] && nuevaPosicion[1] > getPosicion()[1]) {
            isValido = true;
        }

        return new int[0];
    }
}