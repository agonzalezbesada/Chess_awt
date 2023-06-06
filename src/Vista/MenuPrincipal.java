package Vista;

import Controlador.Controlador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que se ocupa de la ventana del menu principal
 */
public class MenuPrincipal {

    /**
     * Genera el menu
     * @param usuarioConectado Usuario actual
     */
    public static void GenerarMenu(String usuarioConectado){

        JFrame menuPrincipal = new JFrame(); // Pantalla del menu principal
        menuPrincipal.setTitle("Menu Principal"); // Nombre de la pantalla
        menuPrincipal.setBounds(0,0, 1920, 1050); // Proporciones
        menuPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Tras crear el menú principal, generamos un panel donde introducimos un GridLayout con 4 filas y 1 columna
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JLabel conexionActual = new JLabel("USUARIO ACTUAL:    "+usuarioConectado);
        conexionActual.setHorizontalAlignment(JLabel.CENTER);
        JButton jugarPartida = new JButton("Jugar partida"); // Boton para jugar la partida
        JButton iniciarSesion = new JButton("Iniciar sesión / Registrarse"); // Boton para iniciar sesion
        JButton cargarPartida = new JButton("Cargar Partida");
        JButton estadisticas = new JButton("Consultar estadísticas"); // Boton de estadisticas
        JButton salir = new JButton("Salir"); // Boton para salir

        jugarPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (usuarioConectado.equals("Ninguno")) {

                } else {
                    menuPrincipal.setVisible(false); // Cierra la ventana
                    if (Controlador.modelo.partida==null) {
                        MenuTablero.generarPartida(0); // Genera la ventana de la partida
                    } else {
                        MenuTablero.generarPartida(1); // Genera la ventana de la partida
                    }
                }

            }
        });

        iniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                menuPrincipal.setVisible(false);
                IniciarSesion.inciarSesion();

            }
        });

        cargarPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (usuarioConectado.equals("Ninguno")) {

                } else {
                    Controlador.cargarPartida(); // Carga una partida guardada en formato JSON
                }

            }
        });

        estadisticas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuarioConectado.equals("Ninguno")) {

                } else {
                    menuPrincipal.setVisible(false); // Cierra la ventana
                    Estadisticas.estadisticas();
                }
            }
        });

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Finaliza el programa
            }
        });


        // Añade los botones
        panel.add(conexionActual);
        panel.add(jugarPartida);
        panel.add(iniciarSesion);
        panel.add(cargarPartida);
        panel.add(estadisticas);
        panel.add(salir);


        // Ponemos una especie de padding con unos límites para separar estos del frame
        panel.setBorder(new EmptyBorder(150, 200, 150, 200));

        menuPrincipal.add(panel, BorderLayout.CENTER);

        menuPrincipal.setVisible(true);
    }

}
