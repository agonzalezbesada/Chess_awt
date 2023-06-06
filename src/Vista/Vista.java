package Vista;


/**
 * Vista
 */
public class Vista {

    /**
     * Llama a la interfaz
     */
    public void llamadaMenuP(String usuarioConectado){
        MenuPrincipal principal = new MenuPrincipal();
        principal.GenerarMenu(usuarioConectado);
    }

    public void actualizarTablero() {
        MenuTablero.actualizarTablero(1);
    }

    public void terminarPartida() {
        MenuTablero.terminarPartida();
    }

}