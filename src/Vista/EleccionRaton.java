package Vista;

import Controlador.Controlador;
import Modelo.Pieza;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EleccionRaton implements MouseListener {

    public Pieza pieza;
    public int[] posicionActual;
    public EleccionRaton(Pieza pieza) {

        this.pieza = pieza;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        try {

            this.posicionActual = pieza.getPosicion();
            System.out.println(posicionActual[0]+" "+posicionActual[1]);

        } catch (NullPointerException exception) {

            if (this.posicionActual==null) {
                System.out.println("Elija una casilla válida");
            }

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
