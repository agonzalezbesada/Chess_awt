package Modelo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Guardado {

    public Gson gson = new Gson();

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

        Partida partidaCargada = gson.fromJson(jsonRecuperado, Partida.class); // No se puede desreializar las Pieza[] porque es una clase abstracta

        return partidaCargada;
    }

}
