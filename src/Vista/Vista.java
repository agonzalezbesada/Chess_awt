package Vista;

import Controlador.Controlador;

import javax.swing.*;
import java.awt.*;

/**
 * Vista
 */
public class Vista {

    /**
     * Llama a la interfaz
     */
    public void LlamadaMenuP(String usuarioConectado){
        MenuPrincipal principal = new MenuPrincipal();
        principal.GenerarMenu(usuarioConectado);
    }

    public void actualizarTablero() {
        MenuTablero.actualizarTablero(1);
    }

    public void volverMenuPrincipal() {

    }
}