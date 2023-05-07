package Modelo;

public class Caballo extends Pieza implements IPieza {

    Caballo() {

    }

    Caballo(String color, int[] posicion) {
        setColor(color);
        setPosicion(posicion);
    }


    @Override
    public int[] cambiarPosicion() {
        return new int[0];
    }
}