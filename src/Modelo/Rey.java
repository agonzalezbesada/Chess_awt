package Modelo;

/**
 * Pieza Rey
 */
public class Rey extends Pieza implements IPieza {

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
    public Integer[] cambiarPosicion(Integer[] posicionNueva) {

        boolean isValido;
        Integer[] posicionFinal = new Integer[2];

        if (posicionNueva[1] == getPosicion()[1]) {
            if (posicionNueva[0] < getPosicion()[0]+2 && posicionNueva[0] > getPosicion()[0]-2){
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            }
        } else if (posicionNueva[0] == getPosicion()[0]) {
            if (posicionNueva[1] < getPosicion()[1]+2 && posicionNueva[1] > getPosicion()[1]-2) {
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            }
        } else if (posicionNueva[0] != getPosicion()[0] && posicionNueva[1] != getPosicion()[1]) {
            if ((posicionNueva[0] < getPosicion()[0]+2 && posicionNueva[0] > getPosicion()[0]-2) && (posicionNueva[1] < getPosicion()[1]+2 && posicionNueva[1] > getPosicion()[1]-2)) {
                isValido = true;
                posicionFinal = posicionNueva;
                setPosicion(posicionFinal);
            }

        }


        return posicionFinal;
    }
}