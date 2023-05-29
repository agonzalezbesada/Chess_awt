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
    public Reina(Integer color, String nombre, Integer x, Integer y) {
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

            } else if ((posicionNueva[0] - getPosicion()[0]) == (posicionNueva[1] - getPosicion()[1]) && (posicionNueva[1] != getPosicion()[1] && posicionNueva[0] != getPosicion()[0])) { // Si se mueve en la diagonal \
                isValido = true;

                int comprobacionFila = getPosicion()[1]; // Variable para poder recorrer la matriz en diagonal

                for (int i = getPosicion()[0]+1; i < posicionNueva[0]; i++) {

                    comprobacionFila++;
                    if (matrizPiezas[i][comprobacionFila] != null) {

                        isValido = false;
                        i = posicionNueva[0]; // Igualamos el iterador al final del for para finalizarlo

                    }

                }

                comprobacionFila = getPosicion()[1];
                for (int i = getPosicion()[0]-1; i > posicionNueva[0]; i--) {

                    comprobacionFila--;
                    if (matrizPiezas[i][comprobacionFila] != null) {

                        isValido = false;
                        i = posicionNueva[0]; // Igualamos el iterador al final del for para finalizarlo

                    }

                }

                if (isValido) { // Si no hay ninguna pieza en su camino y por tanto es valido
                    posicionFinal = posicionNueva;
                    setPosicion(posicionFinal);
                    setNMovimientos();
                }

            } else if (posicionNueva[0] == getPosicion()[0] - (posicionNueva[1] - getPosicion()[1]) && (posicionNueva[1] != getPosicion()[1] && posicionNueva[0] != getPosicion()[0])) { // Si se mueve en la diagonal /
                isValido = true;

                int comprobacionFila = getPosicion()[1]; // Variable para poder recorrer la matriz en diagonal

                for (int i = getPosicion()[0]+1; i < posicionNueva[0]; i++) {

                    comprobacionFila--;
                    if (matrizPiezas[i][comprobacionFila] != null) {

                        isValido = false;
                        i = posicionNueva[0]; // Igualamos el iterador al final del for para finalizarlo

                    }

                }

                comprobacionFila = getPosicion()[1];
                for (int i = getPosicion()[0]-1; i > posicionNueva[0]; i--) {

                    comprobacionFila++;
                    if (matrizPiezas[i][comprobacionFila] != null) {

                        isValido = false;
                        i = posicionNueva[0]; // Igualamos el iterador al final del for para finalizarlo

                    }

                }

                if (isValido) { // Si no hay ninguna pieza en su camino y por tanto es valido
                    posicionFinal = posicionNueva;
                    setPosicion(posicionFinal);
                    setNMovimientos();
                }

            }

        } else { // Si en la posicion final no existe una pieza

            if (posicionNueva[0] == getPosicion()[0]) { // Si el movimiento es vertical |
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

            } else if (posicionNueva[1] == getPosicion()[1]) { // Si el movimiento es horizontal -
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

            } else if ((posicionNueva[0] - getPosicion()[0]) == (posicionNueva[1] - getPosicion()[1])) { // Si se mueve en la diagonal \
                isValido = true;

                int comprobacionFila = getPosicion()[1]; // Variable para poder recorrer la matriz en diagonal

                for (int i = getPosicion()[0]+1; i < posicionNueva[0]; i++) {

                    comprobacionFila++;
                    if (matrizPiezas[i][comprobacionFila] != null) {

                        isValido = false;
                        i = posicionNueva[0]; // Igualamos el iterador al final del for para finalizarlo

                    }

                }

                comprobacionFila = getPosicion()[1];
                for (int i = getPosicion()[0]-1; i > posicionNueva[0]; i--) {

                    comprobacionFila--;
                    if (matrizPiezas[i][comprobacionFila] != null) {

                        isValido = false;
                        i = posicionNueva[0]; // Igualamos el iterador al final del for para finalizarlo

                    }

                }

                if (isValido) { // Si no hay ninguna pieza en su camino y por tanto es valido
                    posicionFinal = posicionNueva;
                    setPosicion(posicionFinal);
                    setNMovimientos();
                }

            } else if (posicionNueva[0] == getPosicion()[0] - (posicionNueva[1] - getPosicion()[1])) { // Si se mueve en la diagonal /
                isValido = true;

                int comprobacionFila = getPosicion()[1]; // Variable para poder recorrer la matriz en diagonal

                for (int i = getPosicion()[0]+1; i < posicionNueva[0]; i++) {

                    comprobacionFila--;
                    if (matrizPiezas[i][comprobacionFila] != null) {

                        isValido = false;
                        i = posicionNueva[0]; // Igualamos el iterador al final del for para finalizarlo

                    }

                }

                comprobacionFila = getPosicion()[1];
                for (int i = getPosicion()[0]-1; i > posicionNueva[0]; i--) {

                    comprobacionFila++;
                    if (matrizPiezas[i][comprobacionFila] != null) {

                        isValido = false;
                        i = posicionNueva[0]; // Igualamos el iterador al final del for para finalizarlo

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