package Modelo;

/**
 * Clase abstacta de las piezas con atributos y métodos con cuerpo
 */
public abstract class Pieza implements IPieza {

    private String nombre;
    private Integer[] posicion = new Integer[2];
    private int nMovimientos;
    private Integer color;



    public boolean destruirPieza() {
        return true;
    }

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
        this.posicion = posicion;
    }

    /**
     * Devuelve el numero de movimientos
     * @return Devuelve el numero de movimientos
     */
    public int getNMovimientos() {
        return nMovimientos;
    }

    /**
     * Introduce el numero de movimientos
     * @param nMovimientos Contador de movimientos
     */
    public void setNMovimientos(int nMovimientos) {
        this.nMovimientos = nMovimientos;
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
}