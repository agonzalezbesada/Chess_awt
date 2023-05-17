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
    public void LlamadaMenuP(){
        MenuPrincipal principal = new MenuPrincipal();
        principal.GenerarMenu();
    }

    public void actualizarTablero() {
        MenuTablero.actualizarTablero(1);
    }
}