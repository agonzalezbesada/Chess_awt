package Modelo;

public class Rey extends Pieza implements IPieza {

    Rey() {

    }

    Rey(String color, int[] posicion) {
        setColor(color);
        setPosicion(posicion);
    }

    @Override
    public int[] cambiarPosicion() {
        return new int[0];
    }
}