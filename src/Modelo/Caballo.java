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
    public Caballo(Integer color, String nombre, int x, int y) {
        setColor(color);
        setNombre(nombre);
        int[] posicion = new int[2];
        posicion[0] = x;
        posicion[1] = y;
        setPosicion(posicion);
    }


    @Override
    public int[] cambiarPosicion() {

        boolean isValido;
        int [] nuevaPosicion = new int[2];
        // nuevaPosicion[0]
        // nuevaPosicion[1]

        if (nuevaPosicion[0] == getPosicion()[0]+1 && nuevaPosicion[1] == getPosicion()[1]+2) {
            isValido = true;
        } else if (nuevaPosicion[0] == getPosicion()[0]+1 && nuevaPosicion[1] == getPosicion()[1]-2) {
            isValido = true;
        } else if (nuevaPosicion[0] == getPosicion()[0]+2 && nuevaPosicion[1] == getPosicion()[1]+1) {
            isValido = true;
        } else if (nuevaPosicion[0] == getPosicion()[0]+2 && nuevaPosicion[1] == getPosicion()[1]-1) {
            isValido = true;
        } else if (nuevaPosicion[0] == getPosicion()[0]-1 && nuevaPosicion[1] == getPosicion()[1]+2) {
            isValido = true;
        } else if (nuevaPosicion[0] == getPosicion()[0]-1 && nuevaPosicion[1] == getPosicion()[1]-2) {
            isValido = true;
        } else if (nuevaPosicion[0] == getPosicion()[0]-2 && nuevaPosicion[1] == getPosicion()[1]+1) {
            isValido = true;
        } else if (nuevaPosicion[0] == getPosicion()[0]-2 && nuevaPosicion[1] == getPosicion()[1]-1) {
            isValido = true;
        }


        return new int[0];
    }
}