package Vista;

import Controlador.Controlador;
import Modelo.Pieza;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EleccionRaton implements MouseListener {

    public int[] posicionActual;
    public JLabel[][] label;
    public JLabel celdaVacia;


    public EleccionRaton(JLabel[][] label, JLabel celdaVacia) {
        this.label = label;
        this.celdaVacia = celdaVacia;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        int[] nuevaPosicion = new int[2];

        for (int i = 0; i < label.length; i++) {
            for (int j = 0; j < label[i].length; j++) {
                if (label[i][j] == celdaVacia) {
                    nuevaPosicion[0] = j;
                    nuevaPosicion[1] = i;
                }
            }
        }

        System.out.println(nuevaPosicion[0]+" "+nuevaPosicion[1]);

    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {

        int[] nuevaPosicion = new int[2];

        for (int i = 0; i < label.length; i++) {
            for (int j = 0; j < label[i].length; j++) {
                if (label[i][j] == celdaVacia) {
                    nuevaPosicion[0] = j;
                    nuevaPosicion[1] = i;
                }
            }
        }

        System.out.println(nuevaPosicion[0]+" "+nuevaPosicion[1]);
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
