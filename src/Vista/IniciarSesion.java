package Vista;

import Controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que se ocupa de la ventana para el inicio de sesión
 */
public class IniciarSesion {

    public static void inciarSesion() {

        JFrame interfazSesion = new JFrame();
        interfazSesion.setTitle("Inicio/Registro");
        interfazSesion.setBounds(0,0, 1920, 1050);
        interfazSesion.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        interfazSesion.setLayout(null);


        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        interfazSesion.setLayout(gridBag);

        JLabel informacion = new JLabel();
        informacion.setText("Inicie Sesión o Registrese introduciendo un nombre");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.SOUTH;
        interfazSesion.add(informacion, gbc);


        JTextField areaTexto = new JTextField();
        areaTexto.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        interfazSesion.add(areaTexto, gbc);

        areaTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String usuario = areaTexto.getText();
                boolean isUsuario = Controlador.iniciarSesion(usuario);
                if (!isUsuario) {
                    boolean isRegistered = Controlador.registrarUsuario(usuario);
                    if (isRegistered) {
                        Controlador.iniciarSesion(usuario);

                        interfazSesion.setVisible(false);
                        Vista.llamadaMenuP(Controlador.usuarioConectado()[0]);
                    }



                } else {
                    Controlador.iniciarSesion(usuario);
                    interfazSesion.setVisible(false);
                    MenuPrincipal.GenerarMenu(Controlador.usuarioConectado()[0]);
                }

            }
        });

        interfazSesion.setVisible(true);
    }

}
