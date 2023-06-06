package Vista;


/**
 * Vista, encargada de lo visual
 */
public class Vista {

    /**
     * Llama a la interfaz
     */
    public static void llamadaMenuP(String usuarioConectado){
        MenuPrincipal principal = new MenuPrincipal();
        principal.GenerarMenu(usuarioConectado);
    }

    /**
     * Llamada para actualizar el tablero
     */
    public void actualizarTablero() {
        MenuTablero.actualizarTablero(1);
    }

    /**
     * Llamada para terminar la partida
     */
    public void terminarPartida() {
        MenuTablero.terminarPartida();
    }

}