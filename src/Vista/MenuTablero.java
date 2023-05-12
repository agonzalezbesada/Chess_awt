package Vista;

import Controlador.Controlador;
import Modelo.Pieza;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class MenuTablero {

    public static Controlador controlador = new Controlador();

    public static void generarPartida() {
        JFrame Partida = new JFrame();
        Partida.setBounds(0, 0, 1400, 1700);


        JPanel tablero = MenuTablero.generarTablero();
        JPanel informacionExtra = new JPanel(new GridLayout(2, 1));

        //Aquí iría la funcionalidad de generar tablero
        JLabel Temporizador = new JLabel("03:00");
        JButton GuardarYSalir = new JButton("Guardar y salir");

        informacionExtra.add(Temporizador);
        informacionExtra.add(GuardarYSalir);
        Partida.add(informacionExtra, BorderLayout.EAST);
        Partida.add(tablero);
        Partida.setVisible(true);
    }

    public static JPanel generarTablero() {
        JPanel tablero = new JPanel(new GridLayout(9, 9));

        // Agregamos las letras en la fila superior
        tablero.add(new JLabel(""));
        for (char c = 'A'; c <= 'H'; c++) {
            JLabel letra = new JLabel(String.valueOf(c), SwingConstants.CENTER);
            tablero.add(letra);
        }

        Pieza[][] matrizPiezas = controlador.posicionesIniciales();
        JLabel[][] label = new JLabel[8][8];

        for (int row = 0; row < 8; row++) {
            JLabel numero = new JLabel(String.valueOf(row+1), SwingConstants.CENTER);
            tablero.add(numero);

            for (int col = 0; col < 8; col++) {
                JPanel celda = new JPanel();
                if ((row + col) % 2 == 0) {
                    celda.setBackground(Color.WHITE);
                } else {
                    celda.setBackground(Color.BLACK);
                }
                Pieza pieza = matrizPiezas[row][col];

                DesplazamientoRaton desplazamiento;
                if (pieza != null) {
                    label[row][col] = new JLabel(pieza.getNombre(), SwingConstants.CENTER);

                    celda.add(label[row][col]);
                } else {
                    label[row][col] = new JLabel();

                    celda.add(label[row][col]);
                }

                EleccionRaton eleccion = new EleccionRaton(label,label[row][col]);
                celda.addMouseListener(eleccion);


                tablero.add(celda);
            }
        }

        return tablero;
    }
}