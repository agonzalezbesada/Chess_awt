package Vista;

import Controlador.Controlador;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Estadisticas {

    public static void estadisticas() {

        JFrame estadisticasJugador = new JFrame();
        estadisticasJugador.setTitle("Estadísticas");
        estadisticasJugador.setBounds(0,0, 1920, 1050);
        estadisticasJugador.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        estadisticasJugador.setLayout(null);

        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        estadisticasJugador.setLayout(gridBag);

        String[] datos = Controlador.usuarioConectado();

        String[] campos = {"NickName", "partidasJugadas", "victorias", "derrotas", "tablas"};

        Object[][] registros = {{datos[0], datos[1], datos[2], datos[3], datos[4]}};

        JTable tabla = new JTable(registros,campos);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        estadisticasJugador.add(tabla, gbc);


        JTableHeader cabecera = tabla.getTableHeader();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.SOUTH;
        estadisticasJugador.add(cabecera, gbc);


        JButton volverMenu = new JButton("Volver al menu");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        estadisticasJugador.add(volverMenu, gbc);

        volverMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estadisticasJugador.setVisible(false);
                MenuPrincipal.GenerarMenu(Controlador.usuarioConectado()[0]);
            }
        });

        estadisticasJugador.setVisible(true);
    }
}
