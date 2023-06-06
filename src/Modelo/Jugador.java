package Modelo;

/**
 * Objeto que almacena datos del jugador
 */
public class Jugador {

    /**
     * Nombre del jugador
     */
    private String nickName;
    /**
     * Número de partidas jugadas
     */
    private String partidasJugadas;
    /**
     * Número de victorias
     */
    private String victorias;
    /**
     * Número de derrotas
     */
    private String derrotas;
    /**
     * Número de tablas (empates)
     */
    private String tablas;

    /**
     * Constructor vacío del jugador
     */
    public Jugador() {

    }

    /**
     * Constructor parametrizado del jugador
     * @param nickName Nombre del jugador
     * @param partidasJugadas Número de partidas jugadas
     * @param victorias Número de victorias
     * @param derrotas Número de derrotas
     * @param tablas Número de tablas (empates)
     */
    public Jugador(String nickName, String partidasJugadas, String victorias, String derrotas, String tablas) {

        this.nickName = nickName;
        this.partidasJugadas = partidasJugadas;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.tablas = tablas;

    }

    /**
     * Getter para el nombre de usuario
     * @return Nombre de usuario
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Setter para el nombre de usuario
     */
    public void setNickName() {
        this.nickName = nickName;
    }

    /**
     * Getter para el número de partidas jugadas
     * @return Partidas jugadas
     */
    public String getPartidasJugadas() {
        return partidasJugadas;
    }

    /**
     * Setter para el número de partidas jugadas
     */
    public void setPartidasJugadas() {
        this.partidasJugadas = partidasJugadas;
    }

    /**
     * Getter para el número de victorias
     * @return Victorias
     */
    public String getVictorias() {
        return victorias;
    }

    /**
     * Setter para el número de victorias
     */
    public void setVictorias() {
        this.victorias = victorias;
    }

    /**
     * Getter para el número de derrotas
     * @return Derrotas
     */
    public String getDerrotas() {
        return derrotas;
    }

    /**
     * Setter para el número de derrotas
     */
    public void setDerrotas() {
        this.derrotas = derrotas;
    }

    /**
     * Getter para el número de tablas (empates)
     * @return Tablas (empates)
     */
    public String getTablas() {
        return tablas;
    }

    /**
     * Setter para el número de tablas (empates)
     */
    public void setTablas() {
        this.tablas = tablas;
    }

    /**
     * Método que devuelve los datos del jugador en forma de array
     * @return Arrat con datos del jugador
     */
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
