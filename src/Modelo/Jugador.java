package Modelo;

public class Jugador {

    private String nickName;
    private String partidasJugadas;
    private String victorias;
    private String derrotas;
    private String tablas;

    public Jugador(String nickName, String partidasJugadas, String victorias, String derrotas, String tablas) {

        this.nickName = nickName;
        this.partidasJugadas = partidasJugadas;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.tablas = tablas;

    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName() {
        this.nickName = nickName;
    }

    public String getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas() {
        this.partidasJugadas = partidasJugadas;
    }

    public String getVictorias() {
        return victorias;
    }

    public void setVictorias() {
        this.victorias = victorias;
    }

    public String getDerrotas() {
        return derrotas;
    }

    public void setDerrotas() {
        this.derrotas = derrotas;
    }

    public String getTablas() {
        return tablas;
    }

    public void setTablas() {
        this.tablas = tablas;
    }

    public String[] obtenerDatos() {
        String[] datos = new String[5];
        datos[0] = getNickName();
        datos[1] = getPartidasJugadas();
        datos[2] = getVictorias();
        datos[3] = getDerrotas();
        datos[4] = getTablas();

        return datos;
    }

}
