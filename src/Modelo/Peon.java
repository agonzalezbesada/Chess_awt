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
            if (posicionNueva[1]==getPosicion()[1]) {
                isValido = true;
                if (posicionNueva[0]<getPosicion()[0] && posicionNueva[0]>getPosicion()[0]-2) {
                    isValido = true;
                    setPosicion(posicionNueva);
                }
            }
        } else {
            isValido = false;
        }

        if (getColor().equals(IPieza.NEGRO)) {
            if (posicionNueva[1]==getPosicion()[1]) {
                isValido = true;
                if (posicionNueva[0]>getPosicion()[0] && posicionNueva[0]<getPosicion()[0]+2) {
                    isValido = true;
                    setPosicion(posicionNueva);
                }
            }
        } else {
            isValido = false;
        }





        // if true setPosicon(nuevaPosicion);

        posicionFinal = posicionNueva;

        System.out.println(posicionFinal[0]+" "+ posicionFinal[1]+" Final 1");

        return posicionFinal;
    }
}