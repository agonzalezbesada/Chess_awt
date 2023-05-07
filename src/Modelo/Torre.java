package Modelo;

public class Torre extends Pieza implements IPieza {

    Torre() {

    }

    Torre(String color, int x, int y) {
        int[] posicion = new int[2];
        posicion[0] = x;
        posicion[1] = y;
        setColor(color);
        setPosicion(posicion);
    }
    @Override
    public int[] cambiarPosicion() {
        return new int[0];
    }
}