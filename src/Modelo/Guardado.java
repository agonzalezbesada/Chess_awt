package Modelo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Objeto que maneja partidas en ficheros
 */
public class Guardado {

    /**
     * Objeto que permite tratar JSON
     */
    public Gson gson = new Gson();

    /**
     * Guarda el estado de la partida en un fichero en formato JSON
     * @param partida Valores actuales de la partida
     */
    public void guardarPartida(Partida partida) {

        String jsonPartida = gson.toJson(partida, Partida.class);

        FileWriter escritorFichero;

        try {

            escritorFichero = new FileWriter("src\\Modelo\\PartidasGuardadas\\PartidaGuardada"+partida.nickName+".json",false);
            escritorFichero.write(jsonPartida);
            escritorFichero.close();

        } catch (IOException e) {

            System.out.println(e.toString());

        }

    }

    /**
     * Carga el estado de una anterior partida perteneciente al usuario actual
     * @param jugador Usuario actual
     * @return Valores de la partida
     */
    public Partida cargarPartida(String jugador) {

        String jsonRecuperado = "";
        FileReader lectorFichero;

        try {

            lectorFichero = new FileReader("src\\Modelo\\PartidasGuardadas\\PartidaGuardada"+jugador+".json");
            int caracter = lectorFichero.read();

            while (caracter!=-1) {

                jsonRecuperado += (char) caracter;
                caracter = lectorFichero.read();

            }

            lectorFichero.close();

        } catch (IOException e) {
            System.out.println(e.toString());
        }

        Partida partidaCargada = gson.fromJson(jsonRecuperado, Partida.class);

        return partidaCargada;
    }

}
