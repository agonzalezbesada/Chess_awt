package Vista;

import Controlador.Controlador;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Objeto que se escucha al ratón
 */
public class ManejadorRaton implements MouseListener {

    /**
     * Posicion inicial seleccionada
     */
    public static Integer[] posicionInicial = new Integer[2];
    /**
     * Posicion final seleccionada
     */
    public static Integer[] posicionNueva = new Integer[2];
    /**
     * Matriz con las casillas
     */
    public JLabel[][] label;
    /**
     * Casilla actual
     */
    public JLabel celdaActual;

    /**
     * Constructor parametrizado que inicializa atributos
     * @param label Matriz con los JLabel
     * @param celdaActual JLabel desencadenante
     */
    public ManejadorRaton(JLabel[][] label, JLabel celdaActual) {
        this.label = label;
        this.celdaActual = celdaActual;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Guarda la casilla de origen
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

        // Recorre la matriz en busqueda del label correspondiente
        for (int i = 0; i < label.length; i++) {
            for (int j = 0; j < label[i].length; j++) {
                if (label[i][j] == celdaActual) {
                    posicionInicial[0] = j;
                    posicionInicial[1] = i;
                }
            }
        }

        System.out.println(posicionInicial[0]+" "+ posicionInicial[1]+" Origen");

    }


    /**
     * Marca la casilla de destino
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

        // Recorre la matriz en busqueda del label correspondiente
        for (int i = 0; i < label.length; i++) {
            for (int j = 0; j < label[i].length; j++) {
                if (label[i][j] == celdaActual) {
                    posicionNueva[0] = j;
                    posicionNueva[1] = i;
                }
            }
        }

        System.out.println(posicionNueva[0]+" "+posicionNueva[1]+" Destino");

    }

    /**
     * Envia la posicion de origen y destino
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        // Envía los datos recogidos
        Controlador.moverPieza(posicionInicial,posicionNueva);

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
