package Vista;

import Controlador.Controlador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Menu principal
 */
public class MenuPrincipal {

    /**
     * Genera el menu
     */
    public static void GenerarMenu(){

        JFrame menuPrincipal = new JFrame(); // Pantalla del menu principal
        menuPrincipal.setTitle("Ajedrez"); // Nombre de la pantalla
        menuPrincipal.setBounds(0,0, 1920, 1050); // Proporciones
        menuPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Tras crear el menú principal, generamos un panel donde introducimos un GridLayout con 4 filas y 1 columna
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton jugarPartida = new JButton("Jugar partida"); // Boton para jugar la partida
        JButton iniciarSesion = new JButton("Iniciar sesión"); // Boton para iniciar sesion
        JButton cargarPartida = new JButton("Cargar Partida");
        JButton estadisticas = new JButton("Consultar estadísticas"); // Boton de estadisticas
        JButton salir = new JButton("Salir"); // Boton para salir

        jugarPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPrincipal.setVisible(false); // Cierra la ventana
                if (Controlador.modelo.partida==null) {
                    MenuTablero.generarPartida(0); // Genera la ventana de la partida
                } else {
                    MenuTablero.generarPartida(1); // Genera la ventana de la partida
                }

            }
        });

        iniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.iniciarSesion("Adrian");
                /*
                menuPrincipal.setVisible(false);
                IniciarSesion.GenerarMenu();
                 */

            }
        });

        cargarPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador.cargarPartida();
            }
        });

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Finaliza el programa
            }
        });





        // Añade los botones
        panel.add(jugarPartida);
        panel.add(iniciarSesion);
        panel.add(cargarPartida);
        panel.add(estadisticas);
        panel.add(salir);

        /** Añadimos los botones al panel, y le ponemos una especie de padding con unos límites para separar estos del
         * frame **/

        // Añadimos los botones al panel, y le ponemos una especie de padding con unos límites para separar estos del frame
        // Add an EmptyBorder with a 50-pixel margin around the panel
        panel.setBorder(new EmptyBorder(150, 200, 150, 200));

        menuPrincipal.add(panel, BorderLayout.CENTER);

        menuPrincipal.setVisible(true);
    }

}
