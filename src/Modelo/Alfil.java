package Modelo;

public class Alfil extends Pieza implements IPieza {

    Alfil()  {

    }

    Alfil(String color, int[] posicion) {
        setColor(color);
        setPosicion(posicion);
    }


    @Override
    public int[] cambiarPosicion() {
        return new int[0];
    }
}
