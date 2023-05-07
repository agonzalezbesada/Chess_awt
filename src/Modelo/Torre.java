package Modelo;

public class Torre extends Pieza implements IPieza {

    Torre() {

    }

    Torre(String color, int[] posicion) {
        setColor(color);
        setPosicion(posicion);
    }
    @Override
    public int[] cambiarPosicion() {
        return new int[0];
    }
}