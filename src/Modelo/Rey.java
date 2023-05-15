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
    public Rey(Integer color, String nombre, int x, int y) {
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

        if (nuevaPosicion[0] < getPosicion()[0]+2 || nuevaPosicion[0] == getPosicion()[0]) {
            if (nuevaPosicion[1] < getPosicion()[0]+2 || nuevaPosicion[1] == getPosicion()[1]){
                isValido = true;
            }
        } else if (nuevaPosicion[1] < getPosicion()[0]+2 || nuevaPosicion[1] == getPosicion()[1]) {
            if (nuevaPosicion[0] < getPosicion()[0]+2 || nuevaPosicion[0] == getPosicion()[0]) {
                isValido = true;
            }
        }


        return new int[0];
    }
}