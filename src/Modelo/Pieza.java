package Modelo;

/**
 * Clase abstacta de las piezas con atributos y métodos con cuerpo
 */
public class Pieza implements IPieza {

    private String nombre;
    private Integer[] posicion = new Integer[2];
    private int nMovimientos = 0;
    private Integer color;

    /**
     * Devuelve el nombre
     * @return Nombre de la pieza
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Introduce un nombre
     * @param nombre Atributo de nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la posicion
     * @return Posicion de la pieza
     */
    public Integer[] getPosicion() {
        return this.posicion;
    }

    /**
     * Introduce la posicion
     * @param posicion Atributo de posicion
     */
    public void setPosicion(Integer[] posicion) {
        this.posicion[0] = posicion[0];
        this.posicion[1] = posicion[1];
    }

    /**
     * Devuelve el numero de movimientos
     * @return Devuelve el numero de movimientos
     */
    public int getNMovimientos() {
        return nMovimientos;
    }

    /**
     * Aumenta el numero de movimientos
     */
    public void setNMovimientos() {
        this.nMovimientos++;
    }

    /**
     * Devuelve el color
     * @return Devuelve el color
     */
    public Integer getColor() {
        return this.color;
    }

    /**
     * Introduce el color
     * @param color Color de la pieza
     */
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public Integer[] cambiarPosicion(Integer[] posicionNueva, Pieza[][] matrizPiezas) {
        return new Integer[0];
    }
}