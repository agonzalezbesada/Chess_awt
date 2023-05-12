package Modelo;

public abstract class Pieza implements IPieza {

    private String nombre;
    private int[] posicion = new int[2];
    private int nMovimientos;
    private String color;

    public boolean destruirPieza() {
        return true;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getPosicion() {
        return this.posicion;
    }

    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }

    public int getNMovimientos() {
        return nMovimientos;
    }

    public void setNMovimientos(int nMovimientos) {
        this.nMovimientos = nMovimientos;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}