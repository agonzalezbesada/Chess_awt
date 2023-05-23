package Vista;

import Controlador.Controlador;
import Modelo.Pieza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.TimerTask;

/**
 * Ventana de la partida
 */
public class MenuTablero {
    private static JLabel EtiquetaTemporizador;

    public static JPanel tablero;
    public static JFrame partida;
    public static JLabel[][] label;

    /**
     * Genera la interfaz de la partida
     */
    public static void generarPartida(int modo) {
        partida = new JFrame();
        partida.setBounds(0, 0, 1920, 1050);
        partida.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JPanel tablero = MenuTablero.generarTablero(0);
        JPanel informacionExtra = new JPanel(new GridLayout(6,1));
        tablero = MenuTablero.generarTablero(modo);
        informacionExtra = new JPanel(new GridLayout(2, 1));

        //Aquí iría la funcionalidad de generar tablero
        EtiquetaTemporizador = new JLabel();
        JButton IniciarTemporizador = new JButton("Iniciar tiempo");
        IniciarTemporizador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuTablero.Temporizador(3);
            }
        });
        JButton CambiarTurno = new JButton("Cambiar turno");
        JTextField CasillaInicial = new JTextField("Casilla inicial");
        JTextField CasillaFinal = new JTextField("Casilla final");
        JButton GuardarYSalir = new JButton("Guardar y salir");

        informacionExtra.add(EtiquetaTemporizador);
        informacionExtra.add(IniciarTemporizador);
        informacionExtra.add(CambiarTurno);
        informacionExtra.add(CasillaInicial);
        informacionExtra.add(CasillaFinal);
        informacionExtra.add(GuardarYSalir);

        Partida.add(informacionExtra, BorderLayout.EAST);

        Partida.add(tablero);
        Partida.setVisible(true);
    }

    /**
     * Genera el tablero
     * @return Devuelve el tablero
     */
    public static JPanel generarTablero(int modo) {

        tablero = new JPanel(new GridLayout(9, 9)); // Inicializa el tablero y un GridLayout

        // Agregamos las letras en la fila superior
        tablero.add(new JLabel(""));
        for (char c = 'A'; c <= 'H'; c++) {
            JLabel letra = new JLabel(String.valueOf(c), SwingConstants.CENTER);
            tablero.add(letra);
        }

        Pieza[][] matrizPiezas = null;

        // Dependiendo de si se desea crear o actualizar
        // TODO Literales
        if (modo == 0) {
            matrizPiezas = Controlador.posicionesIniciales(); // Matriz con las piezas iniciales
        } else if (modo == 1) {
            matrizPiezas = Controlador.posicionesActuales(); // Matriz con las piezas actuales
        }

        label = new JLabel[8][8]; // Matriz con labels
        int numeros = 8;

        for (int col = 0; col < 8; col++) {

            JLabel numero = new JLabel(String.valueOf(numeros), SwingConstants.CENTER); // Crea los numeros en la primera fila
            tablero.add(numero);
            numeros--;


            for (int row = 0; row < 8; row++) {
                JPanel celda = new JPanel(); // Inicializa las celdas
                if ((col + row) % 2 == 0) {
                    celda.setBackground(Color.WHITE); // Atribuye colores a las casillas
                } else {
                    celda.setBackground(Color.BLACK); // Atribuye colores a las casillas
                }
                Pieza pieza = matrizPiezas[row][col]; // Pieza correspondiente a la posicion de la cuadricula

                if (pieza != null) {

                    label[col][row] = new JLabel(pieza.getNombre(), SwingConstants.CENTER); // Inicializa un label con la pieza correspondiente
                    celda.add(label[col][row]); // Agrega el label a la celda

                } else {

                    label[col][row] = new JLabel(); // Inicializa un label vacio
                    celda.add(label[col][row]); // Agrega el label a la celda

                }

                ManejadorRaton eleccion = new ManejadorRaton(label,label[col][row]); // Crea el manejador para el raton
                celda.addMouseListener(eleccion); // Agrega el manejador a la celda


                tablero.add(celda); // Agrega la celda al tablero
            }
        }

        return tablero;
    }

/** Añadimos la funcionalidad para el temporizador**/
    public static void Temporizador (int minutos){
        //declaramos segundos y un contador (debe ser final para que pueda usarse en el método
        //anónimo)
        int segundos = minutos * 60;
        final int[] contador = {minutos * 60};
        Timer temporizador = new Timer(1000, new ActionListener() {
           //Creamos el temporizador, y vamos restando el contador con un delay determinado para
            //poder restar de segundo en segundo,
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contador[0] > 0){
                    String ModificarTiempoVisual = ModificarVisual(contador[0]);
                    EtiquetaTemporizador.setText(ModificarTiempoVisual);
                    contador[0]--;
                }else{
                    EtiquetaTemporizador.setText("Siguiente turno");
                }
            }
        });
        temporizador.start();
    }

    /**
     * Modificar visual lo único que realiza es el cambio en Timer, pero en GUI
     *     Para ello, necesitamos configurar el formato de la String (02d para saber cuántos dígitos
     *     son e incluir un 0 a la derecha, como formato de hora, y pasarle los minutos y segundos
     *     restantes. El resto de la división entre los segundos y 60 nos sirve para representar
     *     visualmnente cuántos segundos quedan de cada minuto.
     *
     * @param segundos
     * @return
     */
    public static String ModificarVisual(int segundos){
        int minutos = segundos/60;
        int segundosRestantes = segundos % 60;
        return String.format("%02d:%02d", minutos, segundosRestantes);
    }

    public static void actualizarTablero(int modo) {

        tablero = generarTablero(modo);

        partida.add(tablero);
        partida.setVisible(true);

    }
}