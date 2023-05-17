package Vista;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuTablero {

    public static void generarPartida(){
        JFrame Partida = new JFrame();
        Partida.setBounds(0,0,1400,1700);


        JPanel tablero = MenuTablero.generarTablero();
        JPanel informacionExtra = new JPanel(new GridLayout(5,1));

        //Aquí iría la funcionalidad de generar tablero
        JLabel Temporizador = new JLabel("03:00");
        JButton CambiarTurno = new JButton("Cambiar turno");
        JTextField CasillaInicial = new JTextField("Casilla inicial");
        JTextField CasillaFinal = new JTextField("Casilla final");
        JButton GuardarYSalir = new JButton("Guardar y salir");

        informacionExtra.add(Temporizador);
        informacionExtra.add(CambiarTurno);
        informacionExtra.add(CasillaInicial);
        informacionExtra.add(CasillaFinal);
        informacionExtra.add(GuardarYSalir);

        Partida.add(informacionExtra, BorderLayout.EAST);
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

        // Agregamos las casillas del tablero
        for (int i = 1; i <= 8; i++) {
            // Agregamos los números en la columna izquierda
            JLabel numero = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            tablero.add(numero);
            for (int j = 0; j < 8; j++) {
                JPanel casilla = new JPanel();
                if ((i + j) % 2 == 0) {
                    casilla.setBackground(Color.WHITE);
                } else {
                    casilla.setBackground(Color.BLACK);
                }
                casilla.setPreferredSize(new Dimension(100, 100));
                tablero.add(casilla);
            }
        }

        return tablero;
    }

    public Timer Temporizador (){
        Timer temporizador;
        JTimer

        return temporizador;
    }
}
