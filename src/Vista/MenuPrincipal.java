package Vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal {

    public static void GenerarMenu(){
        JFrame MenuPrincipal = new JFrame();
        MenuPrincipal.setTitle("Ajedrez");
        MenuPrincipal.setBounds(0,0, 1400, 700);
        /**Tras crear el menú principal, generamos un panel donde introducimos un GridLayout con 4 filas y 1 columna**/
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton JugarPartida = new JButton("Jugar partida");
        JButton IniciarSesion = new JButton("Iniciar sesión");
        JButton Estadisticas = new JButton("Consultar estadísticas");
        JButton Salir = new JButton("Salir");
        Salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(JugarPartida);
        panel.add(IniciarSesion);
        panel.add(Estadisticas);
        panel.add(Salir);
        /** Añadimos los botones al panel, y le ponemos una especie de padding con unos límites para separar estos del
         * frame **/
        // Add an EmptyBorder with a 50-pixel margin around the panel
        panel.setBorder(new EmptyBorder(150, 200, 150, 200));

        MenuPrincipal.add(panel, BorderLayout.CENTER);

        MenuPrincipal.setVisible(true);
    }

}
