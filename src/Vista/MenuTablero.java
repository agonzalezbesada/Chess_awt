package Vista;

import Controlador.Controlador;
import Modelo.Pieza;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Ventana de la partida
 */
public class MenuTablero {

    /**
     * Genera la interfaz de la partida
     */
    public static void generarPartida(int modo) {
        JFrame Partida = new JFrame();
        Partida.setBounds(0, 0, 1400, 1700);


        JPanel tablero = MenuTablero.generarTablero(modo);
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

    /**
     * Genera el tablero
     * @return Devuelve el tablero
     */
    public static JPanel generarTablero(int modo) {

        JPanel tablero = new JPanel(new GridLayout(9, 9)); // Inicializa el tablero y un GridLayout

        // Agregamos las letras en la fila superior
        tablero.add(new JLabel(""));
        for (char c = 'A'; c <= 'H'; c++) {
            JLabel letra = new JLabel(String.valueOf(c), SwingConstants.CENTER);
            tablero.add(letra);
        }

        Pieza[][] matrizPiezas = null;

        // Dependiendo de si se desea crear o actualizar
        if (modo == 0) {
            matrizPiezas = Controlador.posicionesIniciales(); // Matriz con las piezas iniciales
        } else if (modo == 1) {
            matrizPiezas = Controlador.posicionesActuales(); // Matriz con las piezas actuales
        }

        JLabel[][] label = new JLabel[8][8]; // Matriz con labels
        int numeros = 8;

        for (int col = 0; col < 8; col++) {

            JLabel numero = new JLabel(String.valueOf(numeros), SwingConstants.CENTER); // Crea los numeros en la primera fila
            tablero.add(numero);
            numeros--;


            for (int row = 0; row < 8; row++) {
                JPanel celda = new JPanel(); // Inicializa las celdas
                if ((col + row) % 2 == 0) {
                    celda.setBackground(Color.WHITE); // Atribuye colores a las casillas
                } else {
                    celda.setBackground(Color.BLACK); // Atribuye colores a las casillas
                }
                Pieza pieza = matrizPiezas[row][col]; // Pieza correspondiente a la posicion de la cuadricula

                if (pieza != null) {

                    label[col][row] = new JLabel(pieza.getNombre(), SwingConstants.CENTER); // Inicializa un label con la pieza correspondiente
                    celda.add(label[col][row]); // Agrega el label a la celda

                } else {

                    label[col][row] = new JLabel(); // Inicializa un label vacio
                    celda.add(label[col][row]); // Agrega el label a la celda

                }

                ManejadorRaton eleccion = new ManejadorRaton(label,label[col][row]); // Crea el manejador para el raton
                celda.addMouseListener(eleccion); // Agrega el manejador a la celda


                tablero.add(celda); // Agrega la celda al tablero
            }
        }

        return tablero;
    }
}