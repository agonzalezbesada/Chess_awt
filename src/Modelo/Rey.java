package Modelo;

public class Rey extends Pieza implements IPieza {


    public Rey() {

    }

    public Rey(String color, String nombre, int x, int y) {
        setColor(color);
        setNombre(nombre);
        int[] posicion = new int[2];
        posicion[0] = x;
        posicion[1] = y;
        setPosicion(posicion);
    }

    @Override
    public int[] cambiarPosicion() {
        return new int[0];
    }
}