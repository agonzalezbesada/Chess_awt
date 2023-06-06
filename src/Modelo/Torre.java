package Modelo;

/**
 * Pieza Torre
 */
public class Torre extends Pieza {

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

    /**
     * Método que evalúa y realiza el movimiento de la pieza
     * @param posicionNueva Posición de destino
     * @param matrizPiezas Matriz de piezas
     * @return Nueva posición para la pieza
     */
    @Override
    public Integer[] cambiarPosicion(Integer[] posicionNueva, Pieza[][] matrizPiezas) {

        boolean isValido;
        Integer[] posicionFinal = new Integer[2];


        if (matrizPiezas[posicionNueva[0]][posicionNueva[1]] != null) { // Si en la posicion final existe una pieza

            if (posicionNueva[0] == getPosicion()[0] && posicionNueva[1] != getPosicion()[1]) { // Si el movimiento es vertical |
                isValido = true;

                for (int i = getPosicion()[1]-1; i > posicionNueva[1]; i--) { // Recorre las posiciones del desplazamiento en busca de una pieza que lo impida
                    if (matrizPiezas[getPosicion()[0]][i] != null) {
                        isValido = false;
                        break;
                    }
                }

                for (int i = getPosicion()[1]+1; i < posicionNueva[1]; i++) { // Recorre las posiciones del desplazamiento en busca de una pieza que lo impida
                    if (matrizPiezas[getPosicion()[0]][i] != null) {
                        isValido = false;
                        break;
                    }
                }

                if (isValido) { // Si no hay ninguna pieza en su camino y por tanto es valido
                    posicionFinal = posicionNueva;
                    setPosicion(posicionFinal);
                    setNMovimientos();
                }

            } else if (posicionNueva[1] == getPosicion()[1] && posicionNueva[0] != getPosicion()[0]) { // Si el movimiento es horizontal -
                isValido = true;

                for (int i = getPosicion()[0]-1; i > posicionNueva[0]; i--) { // Recorre las posiciones del desplazamiento en busca de una pieza que lo impida
                    if (matrizPiezas[i][getPosicion()[1]] != null) {
                        isValido = false;
                        break;
                    }
                }

                for (int i = getPosicion()[0]+1; i < posicionNueva[0]; i++) { // Recorre las posiciones del desplazamiento en busca de una pieza que lo impida
                    if (matrizPiezas[i][getPosicion()[1]] != null) {
                        isValido = false;
                        break;
                    }
                }

                if (isValido) { // Si no hay ninguna pieza en su camino y por tanto es valido
                    posicionFinal = posicionNueva;
                    setPosicion(posicionFinal);
                    setNMovimientos();
                }

            }

        } else { // Si en la posicion final no existe una pieza

            if (posicionNueva[0] == getPosicion()[0] && posicionNueva[1] != getPosicion()[1]) { // Si el movimiento es vertical |
                isValido = true;

                for (int i = getPosicion()[1]-1; i >= posicionNueva[1]; i--) { // Recorre las posiciones del desplazamiento en busca de una pieza que lo impida
                    if (matrizPiezas[getPosicion()[0]][i] != null) {
                        isValido = false;
                        break;
                    }
                }

                for (int i = getPosicion()[1]+1; i <= posicionNueva[1]; i++) { // Recorre las posiciones del desplazamiento en busca de una pieza que lo impida
                    if (matrizPiezas[getPosicion()[0]][i] != null) {
                        isValido = false;
                        break;
                    }
                }

                if (isValido) { // Si no hay ninguna pieza en su camino y por tanto es valido
                    posicionFinal = posicionNueva;
                    setPosicion(posicionFinal);
                    setNMovimientos();
                }

            } else if (posicionNueva[1] == getPosicion()[1] && posicionNueva[0] != getPosicion()[0]) { // Si el movimiento es horizontal -
                isValido = true;

                for (int i = getPosicion()[0]-1; i >= posicionNueva[0]; i--) { // Recorre las posiciones del desplazamiento en busca de una pieza que lo impida
                    if (matrizPiezas[i][getPosicion()[1]] != null) {
                        isValido = false;
                        break;
                    }
                }

                for (int i = getPosicion()[0]+1; i <= posicionNueva[0]; i++) { // Recorre las posiciones del desplazamiento en busca de una pieza que lo impida
                    if (matrizPiezas[i][getPosicion()[1]] != null) {
                        isValido = false;
                        break;
                    }
                }

                if (isValido) { // Si no hay ninguna pieza en su camino y por tanto es valido
                    posicionFinal = posicionNueva;
                    setPosicion(posicionFinal);
                    setNMovimientos();
                }

            }

        }


        return posicionFinal;
    }
}