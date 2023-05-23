package Modelo;

/**
 * Pieza Peon
 */
public class Peon extends Pieza implements IPieza {

    /**
     * Constructor vacío
     */
    public Peon() {

    }

    /**
     * Constructor parametrizado
     * @param color Color de la pieza
     * @param nombre Nombre de la pieza
     * @param x Fila
     * @param y Columna
     */
    public Peon(Integer color, String nombre, Integer x, Integer y) {
        setColor(color);
        setNombre(nombre);
        Integer[] posicion = new Integer[2];
        posicion[0] = x;
        posicion[1] = y;
        setPosicion(posicion);
    }

    @Override
    public Integer[] cambiarPosicion(Integer[] posicionNueva, Pieza[][] matrizPiezas) {

        boolean isValido;
        Integer[] posicionFinal = new Integer[2];


        if (matrizPiezas[posicionNueva[0]][posicionNueva[1]] != null) { // Si en la posicion final existe una pieza

            if (posicionNueva[0]==getPosicion()[0]) {// Si el movimiento es lineal no lo permite

                posicionFinal = null;

            } else {

                if (getColor().equals(IPieza.BLANCO)) { // Si la pieza es blanca


                    if (posicionNueva[0] != getPosicion()[0] && posicionNueva[0] > getPosicion()[0]-2) { // Solo puede alejarse una casilla en diagonal
                        if (posicionNueva[1] < getPosicion()[1] && posicionNueva[1] > getPosicion()[1]-2) { // Solo puede ser hacia adelante
                            isValido = true;
                            posicionFinal = posicionNueva;
                            setPosicion(posicionFinal);
                            setNMovimientos();
                        }
                    }

                } else if (getColor().equals(IPieza.NEGRO)) { // Si la pieza es negra

                    if (posicionNueva[0] != getPosicion()[0] && posicionNueva[0] > getPosicion()[0]-2) { // Solo puede alejarse una casilla en diagonal
                        if (posicionNueva[1] > getPosicion()[1] && posicionNueva[1] < getPosicion()[1]+2) { // Solo puede ser hacia adelante
                            isValido = true;
                            posicionFinal = posicionNueva;
                            setPosicion(posicionFinal);
                            setNMovimientos();
                        }
                    }

                }

            }

        } else { // Si en la posicion final no existe una pieza

            if (getColor().equals(IPieza.BLANCO)) { // Si la pieza es blanca
                if (posicionNueva[0] == getPosicion()[0]) { // Si no se mueve de su columna

                    if (posicionNueva[1] < getPosicion()[1] && posicionNueva[1] > getPosicion()[1]-3 && getNMovimientos() == 0) { // Si nunca se ha movido y pretende moverse 2 posiciones
                        isValido = true;

                        for (int i = getPosicion()[1]-1; i >= posicionNueva[1]; i--) { // Recorre las posiciones del desplazamiento en busca de una pieza que lo impida
                            if (matrizPiezas[getPosicion()[0]][i] != null) {
                                isValido = false;
                                break;
                            }
                        }

                        if (isValido) { // Si no hay ninguna pieza en su camino y por tanto es valido
                            posicionFinal = posicionNueva;
                            setPosicion(posicionFinal);
                            setNMovimientos();
                        }

                    } else if (posicionNueva[1] < getPosicion()[1] && posicionNueva[1] > getPosicion()[1]-2) { // Si avanza pero no más de dos posiciones
                        isValido = true;
                        posicionFinal = posicionNueva;
                        setPosicion(posicionFinal);
                        setNMovimientos();
                    }
                }
            }

            if (getColor().equals(IPieza.NEGRO)) { // Si la pieza es negra
                if (posicionNueva[0] == getPosicion()[0]) { // Si no se mueve de su columna

                    if (posicionNueva[1] > getPosicion()[1] && posicionNueva[1] < getPosicion()[1]+3 && getNMovimientos() == 0) { // Si nunca se ha movido y pretende moverse 2 posiciones
                        isValido = true;

                        for (int i = getPosicion()[1]+1; i <= posicionNueva[1]; i++) { // Recorre las posiciones del desplazamiento en busca de una pieza que lo impida
                            if (matrizPiezas[getPosicion()[0]][i] != null) {
                                isValido = false;
                                break;
                            }
                        }

                        if (isValido) { // Si no hay ninguna pieza en su camino y por tanto es valido
                            posicionFinal = posicionNueva;
                            setPosicion(posicionFinal);
                            setNMovimientos();
                        }

                    } else if (posicionNueva[1] > getPosicion()[1] && posicionNueva[1] < getPosicion()[1]+2) { // Si avanza pero no más de dos posiciones
                        isValido = true;
                        posicionFinal = posicionNueva;
                        setPosicion(posicionFinal);
                        setNMovimientos();
                    }
                }
            }

        }

        return posicionFinal;
    }
}