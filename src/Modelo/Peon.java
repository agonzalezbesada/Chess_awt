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
    public Peon(Integer color, String nombre, int x, int y) {
        setColor(color);
        setNombre(nombre);
        int[] posicion = new int[2];
        posicion[0] = x;
        posicion[1] = y;
        setPosicion(posicion);
    }

    // Quizás innecesario
    @Override
    public int[] cambiarPosicion() {

        boolean isValido;
        int [] nuevaPosicion = new int[2];
        // nuevaPosicion[0]
        // nuevaPosicion[1]

        if (getColor().equals(IPieza.BLANCO)) {
            if (nuevaPosicion[1]==getPosicion()[1]) {
                isValido = true;
                if (nuevaPosicion[0]<getPosicion()[0] && nuevaPosicion[0]>getPosicion()[0]-2) {
                    isValido = true;
                    setPosicion(nuevaPosicion);
                }
            }
        } else {
            isValido = false;
        }

        if (getColor().equals(IPieza.NEGRO)) {
            if (nuevaPosicion[1]==getPosicion()[1]) {
                isValido = true;
                if (nuevaPosicion[0]>getPosicion()[0] && nuevaPosicion[0]<getPosicion()[0]+2) {
                    isValido = true;
                    setPosicion(nuevaPosicion);
                }
            }
        } else {
            isValido = false;
        }





        // if true setPosicon(nuevaPosicion);

        return new int[0];
    }
}