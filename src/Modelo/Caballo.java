package Modelo;

/**
 * Pieza Caballo
 */
public class Caballo extends Pieza implements IPieza {

    /**
     * Constructor vacío
     */
    public Caballo() {

    }

    /**
     * Constructor parametrizado
     * @param color Color de la pieza
     * @param nombre Nombre de la pieza
     * @param x Fila
     * @param y Columna
     */
    public Caballo(Integer color, String nombre, Integer x, Integer y) {
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

            if (posicionNueva[0] == getPosicion()[0]+1 && posicionNueva[1] == getPosicion()[1]+2) { // Movimiento 1 abajo 2 a la derecha
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            } else if (posicionNueva[0] == getPosicion()[0]+1 && posicionNueva[1] == getPosicion()[1]-2) { // Movimiento 1 abajo 2 a la izquierda
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            } else if (posicionNueva[0] == getPosicion()[0]+2 && posicionNueva[1] == getPosicion()[1]+1) { // Movimiento 2 abajo 1 a la derecha
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            } else if (posicionNueva[0] == getPosicion()[0]+2 && posicionNueva[1] == getPosicion()[1]-1) { // Movimiento 2 abajo 1 a la izquierda
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            } else if (posicionNueva[0] == getPosicion()[0]-1 && posicionNueva[1] == getPosicion()[1]+2) { // Movimiento 1 arriba 2 a la derecha
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            } else if (posicionNueva[0] == getPosicion()[0]-1 && posicionNueva[1] == getPosicion()[1]-2) { // Movimiento 1 arriba 2 a la izquierda
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            } else if (posicionNueva[0] == getPosicion()[0]-2 && posicionNueva[1] == getPosicion()[1]+1) { // Movimiento 2 arriba 1 a la derecha
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            } else if (posicionNueva[0] == getPosicion()[0]-2 && posicionNueva[1] == getPosicion()[1]-1) { // Movimiento 2 arriba 1 a la izquierda
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            }

        } else { // Si en la posicion final no existe una pieza

            if (posicionNueva[0] == getPosicion()[0]+1 && posicionNueva[1] == getPosicion()[1]+2) { // Movimiento 1 abajo 2 a la derecha
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            } else if (posicionNueva[0] == getPosicion()[0]+1 && posicionNueva[1] == getPosicion()[1]-2) { // Movimiento 1 abajo 2 a la izquierda
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            } else if (posicionNueva[0] == getPosicion()[0]+2 && posicionNueva[1] == getPosicion()[1]+1) { // Movimiento 2 abajo 1 a la derecha
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            } else if (posicionNueva[0] == getPosicion()[0]+2 && posicionNueva[1] == getPosicion()[1]-1) { // Movimiento 2 abajo 1 a la izquierda
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            } else if (posicionNueva[0] == getPosicion()[0]-1 && posicionNueva[1] == getPosicion()[1]+2) { // Movimiento 1 arriba 2 a la derecha
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            } else if (posicionNueva[0] == getPosicion()[0]-1 && posicionNueva[1] == getPosicion()[1]-2) { // Movimiento 1 arriba 2 a la izquierda
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            } else if (posicionNueva[0] == getPosicion()[0]-2 && posicionNueva[1] == getPosicion()[1]+1) { // Movimiento 2 arriba 1 a la derecha
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            } else if (posicionNueva[0] == getPosicion()[0]-2 && posicionNueva[1] == getPosicion()[1]-1) { // Movimiento 2 arriba 1 a la izquierda
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            }

        }


        return posicionFinal;
    }
}