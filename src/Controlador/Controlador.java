package Controlador;

import Modelo.Modelo;
import Modelo.Pieza;
import Vista.Vista;

/**
 * Controlador, encargado de las llamadas
 */
public class Controlador {
    /**
     * Instancia del modelo
     */
    public static Modelo modelo = new Modelo();
    /**
     * Instancia de la vista
     */
    public static Vista vista = new Vista();
    /**
     * Instancia del observador de los movimientos
     */
    public static ObserverMovimientos observerMovimientos = new ObserverMovimientos();

    public static void main(String[] args) {

        modelo.addObserver(observerMovimientos);

        vista.llamadaMenuP("Ninguno");
      
    }

    /**
     * Llamada al modelo para iniciar sesion obteniendo los datos de un usuario
     * @param nickName Nombre del usuario
     * @return Comprobación
     */
    public static boolean iniciarSesion(String nickName) {

        return modelo.iniciarSesion(nickName);
    }

    /**
     * Llamada al modelo para crear un nuevo usuario en la base de datos
     * @param nickName Nombre del usuario
     * @return Comprobación
     */
    public static boolean registrarUsuario(String nickName) {

        return modelo.registrarUsuario(nickName);
    }

    /**
     * Llamada al modelo para obtener los datos del usuario
     * @return Datos del usuario
     */
    public static String[] usuarioConectado() {
        return modelo.obtenerDatos();
    }

    /**
     * Proporciona las posiciones iniciales
     * @return Matriz con las posiciones iniciales
     */
    public static Pieza[][] iniciarPartida() {
        return modelo.posicionesIniciales();
    }

    /**
     * Llamada al modelo para realizar las acciones pertinentes de cara al final de la partida
     */
    public static void terminarPartida() {
        vista.terminarPartida();
    }

    /**
     * Proporciona las posiciones actuales
     * @return Matriz con las posiciones actuales
     */
    public static Pieza[][] posicionesActuales() {
        return modelo.obtenerMatriz();
    }

    /**
     * Llamada para mover las piezas
     * @param posicionInicial Posicion de la pieza a mover
     * @param posicionNueva Posicion deseada a la que desplazarse
     */
    public static void moverPieza(Integer[] posicionInicial, Integer[] posicionNueva) {

        modelo.moverPieza(posicionInicial, posicionNueva);

        /*
        if (modelo.turno % 2 != 0) {
            turnoAutomata();
        }
         */

    }

    /**
     * Llamada al modelo para cambiar el turno
     */
    public static void cambiarTurno() {
        modelo.cambiarTurno();
    }

    /**
     * Otorga el turno a la máquina (Futura implementación)
     */
    public static void turnoAutomata() {
        modelo.turnoMaquina();
        actualizarTablero();
    }

    /**
     * Llamada al modelo para guardar el estado de la partida actual
     */
    public static void guardarPartida() {
        modelo.guardarPartida();
    }

    /**
     * Llamada al modelo para cargar una partida correspondiente al usuario actual en caso de existir
     */
    public static void cargarPartida() {
        modelo.cargarPartida();
    }

    /**
     * Llamada a la vista para actualizar el tablero
     */
    public static void actualizarTablero() {

        vista.actualizarTablero();

    }
}