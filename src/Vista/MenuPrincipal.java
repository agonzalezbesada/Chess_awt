package Vista;

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

        JFrame MenuPrincipal = new JFrame(); // Pantalla del menu principal
        MenuPrincipal.setTitle("Ajedrez"); // Nombre de la pantalla
        MenuPrincipal.setBounds(0,0, 1400, 700); // Proporciones
        // Tras crear el menú principal, generamos un panel donde introducimos un GridLayout con 4 filas y 1 columna
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton JugarPartida = new JButton("Jugar partida"); // Boton para jugar la partida
        JButton IniciarSesion = new JButton("Iniciar sesión"); // Boton para iniciar sesion
        JButton Estadisticas = new JButton("Consultar estadísticas"); // Boton de estadisticas
        JButton Salir = new JButton("Salir"); // Boton para salir

        Salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Finaliza el programa
            }
        });
        JugarPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal.setVisible(false); // Cierra la ventana
                MenuTablero.generarPartida(0); // Genera la ventana de la partida
            }
        });

        // Añade los botones
        panel.add(JugarPartida);
        panel.add(IniciarSesion);
        panel.add(Estadisticas);
        panel.add(Salir);
        // Añadimos los botones al panel, y le ponemos una especie de padding con unos límites para separar estos del frame
        // Add an EmptyBorder with a 50-pixel margin around the panel
        panel.setBorder(new EmptyBorder(150, 200, 150, 200));

        MenuPrincipal.add(panel, BorderLayout.CENTER);

        MenuPrincipal.setVisible(true);
    }

}
