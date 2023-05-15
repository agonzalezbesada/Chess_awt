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
    public Torre(Integer color, String nombre, Integer x, Integer y) {
        setColor(color);
        setNombre(nombre);
        Integer[] posicion = new Integer[2];
        posicion[0] = x;
        posicion[1] = y;
        setPosicion(posicion);
    }

    @Override
    public Integer[] cambiarPosicion(Integer[] posicionNueva) {

        boolean isValido;
        Integer[] posicionFinal = new Integer[2];

        // || nuevaPosicion[0] > 9 && nuevaPosicion[1] > 9 ...

        if (posicionNueva[0] < getPosicion()[0] && posicionNueva[1] == getPosicion()[1]) {
            isValido = true;
        } else if (posicionNueva[0] == getPosicion()[0] && posicionNueva[1] > getPosicion()[1]) {
            isValido = true;
        }

        return posicionFinal;
    }
}