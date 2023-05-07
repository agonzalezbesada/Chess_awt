package Modelo;

public class Reina extends Pieza implements IPieza {

    Reina() {

    }

    Reina(String color, int x, int y) {
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