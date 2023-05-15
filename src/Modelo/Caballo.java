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
    public Integer[] cambiarPosicion(Integer[] posicionNueva) {

        boolean isValido;
        Integer[] posicionFinal = new Integer[2];

        if (posicionNueva[0] == getPosicion()[0]+1 && posicionNueva[1] == getPosicion()[1]+2) {
            isValido = true;
        } else if (posicionNueva[0] == getPosicion()[0]+1 && posicionNueva[1] == getPosicion()[1]-2) {
            isValido = true;
        } else if (posicionNueva[0] == getPosicion()[0]+2 && posicionNueva[1] == getPosicion()[1]+1) {
            isValido = true;
        } else if (posicionNueva[0] == getPosicion()[0]+2 && posicionNueva[1] == getPosicion()[1]-1) {
            isValido = true;
        } else if (posicionNueva[0] == getPosicion()[0]-1 && posicionNueva[1] == getPosicion()[1]+2) {
            isValido = true;
        } else if (posicionNueva[0] == getPosicion()[0]-1 && posicionNueva[1] == getPosicion()[1]-2) {
            isValido = true;
        } else if (posicionNueva[0] == getPosicion()[0]-2 && posicionNueva[1] == getPosicion()[1]+1) {
            isValido = true;
        } else if (posicionNueva[0] == getPosicion()[0]-2 && posicionNueva[1] == getPosicion()[1]-1) {
            isValido = true;
        }


        return posicionFinal;
    }
}