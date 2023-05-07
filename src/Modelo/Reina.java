package Modelo;

public class Reina extends Pieza implements IPieza {

    Reina() {

    }

    Reina(String color, int[] posicion) {
        setColor(color);
        setPosicion(posicion);
    }

    @Override
    public int[] cambiarPosicion() {
        return new int[0];
    }
}