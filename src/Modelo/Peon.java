package Modelo;

/**
 * Pieza Peon
 */
public class Peon extends Pieza implements IPieza {

    /**
     * Constructor vacío
     */
    public Peon() {

    }

    /**
     * Constructor parametrizado
     * @param color Color de la pieza
     * @param nombre Nombre de la pieza
     * @param x Fila
     * @param y Columna
     */
    public Peon(Integer color, String nombre, Integer x, Integer y) {
        setColor(color);
        setNombre(nombre);
        Integer[] posicion = new Integer[2];
        posicion[0] = x;
        posicion[1] = y;
        setPosicion(posicion);
    }

    // Quizás innecesario
    @Override
    public Integer[] cambiarPosicion(Integer[] posicionNueva) {

        boolean isValido;
        Integer[] posicionFinal = new Integer[2];

        if (getColor().equals(IPieza.BLANCO)) {
            if (posicionNueva[0]==getPosicion()[0]) {
                if (posicionNueva[1]<getPosicion()[1] && posicionNueva[1]>getPosicion()[1]-2) {
                    isValido = true;
                    posicionFinal = posicionNueva;
                    setPosicion(posicionFinal);
                }
            }
        }

        if (getColor().equals(IPieza.NEGRO)) {
            if (posicionNueva[0]==getPosicion()[0]) {
                if (posicionNueva[1]>getPosicion()[1] && posicionNueva[1]<getPosicion()[1]+2) {
                    isValido = true;
                    posicionFinal = posicionNueva;
                    setPosicion(posicionFinal);
                }
            }
        }

        return posicionFinal;
    }
}