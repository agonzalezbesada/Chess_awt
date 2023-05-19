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
    public Integer[] cambiarPosicion(Integer[] posicionNueva, Pieza[][] matrizPiezas) {

        boolean isValido;
        Integer[] posicionFinal = new Integer[2];


        if (matrizPiezas[posicionNueva[0]][posicionNueva[1]] != null) { // Si en la posicion final existe una pieza

            if (posicionNueva[0] == getPosicion()[0] && posicionNueva[1] != getPosicion()[1]) { // Si el movimiento es vertical
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            } else if (posicionNueva[1] == getPosicion()[1] && posicionNueva[0] != getPosicion()[0]) { // Si el movimiento es horizontal
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            }

        } else { // Si en la posicion final no existe una pieza

            if (posicionNueva[0] == getPosicion()[0] && posicionNueva[1] != getPosicion()[1]) { // Si el movimiento es vertical
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            } else if (posicionNueva[1] == getPosicion()[1] && posicionNueva[0] != getPosicion()[0]) { // Si el movimiento es horizontal
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            }

        }

        return posicionFinal;
    }
}