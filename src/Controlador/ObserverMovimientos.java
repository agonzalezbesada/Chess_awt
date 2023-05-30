package Controlador;

import java.util.Observable;
import java.util.Observer;

public class ObserverMovimientos implements Observer {

    /**
     *  Observer que detecta los cambios en las posiciones de las piezas y actualiza el tablero
     * @param o     Objeto observable
     * @param arg   Argumento pasado a {@code notifyObservers}
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {

        Controlador.actualizarTablero();

    }
}
