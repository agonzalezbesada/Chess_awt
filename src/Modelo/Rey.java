package Modelo;

/**
 * Pieza Rey
 */
public class Rey extends Pieza {

    /**
     * Constructor vacío
     */
    public Rey() {

    }

    /**
     * Constructor parametrizado
     * @param color Color de la pieza
     * @param nombre Nombre de la pieza
     * @param x Fila
     * @param y Columna
     */
    public Rey(Integer color, String nombre, Integer x, Integer y) {
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

            if (posicionNueva[1] == getPosicion()[1]) { // Si el movimiento es horizontal -
                if (posicionNueva[0] < getPosicion()[0]+2 && posicionNueva[0] > getPosicion()[0]-2 && posicionNueva[0] > getPosicion()[0]){ // Si sólo se mueve una posición en ese sentido
                    isValido = true;
                    posicionFinal = posicionNueva;
                    setPosicion(posicionFinal);
                }
            } else if (posicionNueva[0] == getPosicion()[0]) { // Si el movimiento es vertical |
                if (posicionNueva[1] < getPosicion()[1]+2 && posicionNueva[1] > getPosicion()[1]-2) { // Si sólo se mueve una posición en ese sentido
                    isValido = true;
                    posicionFinal = posicionNueva;
                    setPosicion(posicionFinal);
                }
            } else if (posicionNueva[0] != getPosicion()[0] && posicionNueva[1] != getPosicion()[1]) { // Si se mueve diagonalmente
                if ((posicionNueva[0] < getPosicion()[0]+2 && posicionNueva[0] > getPosicion()[0]-2) && (posicionNueva[1] < getPosicion()[1]+2 && posicionNueva[1] > getPosicion()[1]-2)) { // Si se mueve sólo una posición
                    isValido = true;
                    posicionFinal = posicionNueva;
                    setPosicion(posicionFinal);
                }
            }

        } else { // Si en la posicion final no existe una pieza

            if (posicionNueva[1] == getPosicion()[1]) { // Si el movimiento es horizontal -
                if (posicionNueva[0] < getPosicion()[0]+2 && posicionNueva[0] > getPosicion()[0]-2){ // Si sólo se mueve una posición en ese sentido
                    isValido = true;
                    posicionFinal = posicionNueva;
                    setPosicion(posicionFinal);
                }
            } else if (posicionNueva[0] == getPosicion()[0]) { // Si el movimiento es vertical |
                if (posicionNueva[1] < getPosicion()[1]+2 && posicionNueva[1] > getPosicion()[1]-2) { // Si sólo se mueve una posición en ese sentido
                    isValido = true;
                    posicionFinal = posicionNueva;
                    setPosicion(posicionFinal);
                }
            } else if (posicionNueva[0] != getPosicion()[0] && posicionNueva[1] != getPosicion()[1]) { // Si se mueve diagonalmente
                if ((posicionNueva[0] < getPosicion()[0]+2 && posicionNueva[0] > getPosicion()[0]-2) && (posicionNueva[1] < getPosicion()[1]+2 && posicionNueva[1] > getPosicion()[1]-2)) { // Si se mueve sólo una posición
                    isValido = true;
                    posicionFinal = posicionNueva;
                    setPosicion(posicionFinal);
                }
            }

        }


        return posicionFinal;
    }
}