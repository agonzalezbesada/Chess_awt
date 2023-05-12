package Vista;

import Controlador.Controlador;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ManejadorRaton implements MouseListener {

    Integer[] posicionActual = new Integer[2];
    Integer[] posicionNueva = new Integer[2];
    public JLabel[][] label;
    public JLabel celdaVacia;

    /**
     * Constructor parametrizado que inicializa atributos
     * @param label Matriz con los JLabel
     * @param celdaVacia JLabel desencadenante
     */
    public ManejadorRaton(JLabel[][] label, JLabel celdaVacia) {
        this.label = label;
        this.celdaVacia = celdaVacia;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        // Recorre la matriz en busqueda del label correspondiente
        for (int i = 0; i < label.length; i++) {
            for (int j = 0; j < label[i].length; j++) {
                if (label[i][j] == celdaVacia) {
                    posicionActual[0] = j;
                    posicionActual[1] = i;
                }
            }
        }

        System.out.println(posicionActual[0]+" "+posicionActual[1]);

    }



    @Override
    public void mouseEntered(MouseEvent e) {

        System.out.println("Testeo "+posicionNueva[0]+" "+posicionNueva[1]); // Prueba

        // Recorre la matriz en busqueda del label correspondiente
        for (int i = 0; i < label.length; i++) {
            for (int j = 0; j < label[i].length; j++) {
                if (label[i][j] == celdaVacia) {
                    posicionNueva[0] = j;
                    posicionNueva[1] = i;
                    // Prueba
                    System.out.println("Guardado "+posicionNueva[0]+" "+posicionNueva[1]);
                }
            }
        }

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // Envía los datos recogidos
        Controlador.moverPieza(posicionActual,posicionNueva);

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
