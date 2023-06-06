package Modelo;

import java.sql.*;
public class BD {

    /**
     * Nombre de la base de datos
     */
    public String bd = "chess";
    /**
     * Nombre de la tabla
     */
    public String tabla = "jugadores";
    /**
     * Objeto que permite hacer la conexión
     */
    public Connection conexion = null;
    /**
     * URL necesaria para la conexion
     */
    public String url = "jdbc:mysql://localhost:3306/chess";
    /**
     * Usuario de la base de datos
     */
    public String user = "root";
    /**
     * Contraseña de la base de datos
     */
    public String password = "root";
    /**
     * Objeto que permite hacer la consulta
     */
    public Statement consulta = null;
    /**
     * Objeto que permite hacer la selección
     */
    public Statement seleccion = null;

    /**
     * Conecta con la base de datos
     */
    public void conectar() {

        try {

            conexion = DriverManager.getConnection(url,user,password);
            System.out.println("Conexion exitosa");

        } catch (SQLException e) {

            System.out.println("Error en la conexion");
            System.out.println(e.getLocalizedMessage());

        }

    }

    /**
     * Método que permite hacer una modificación en la base de datos
     * @param textoModificacion Consulta de modificación
     * @return Comprobación
     */
    public boolean modificar(String textoModificacion) {

        conectar();

        consulta = null;

        try {

            consulta = conexion.createStatement();
            consulta.executeUpdate(textoModificacion);
            System.out.println("Consulta exitosa");

        } catch (SQLException e) {

            System.out.println("Error en la consulta");
            System.out.println(e.getLocalizedMessage());
            cerrar();
            return false;
        }

        cerrar();
        return true;
    }

    /**
     * Método que permite hacer una consulta en la base de datos
     * @param textoConsulta Consulta de seleccion
     * @return Resultado de la consulta
     */
    public String[] consultar(String textoConsulta) {

        conectar();

        seleccion = null;
        ResultSet resultado = null;
        String[] resultadoConsulta = new String[5];

        try {

            seleccion = conexion.createStatement();
            resultado = seleccion.executeQuery(textoConsulta);

            while (resultado.next()) {

                resultadoConsulta[0] = resultado.getString("NickName");
                resultadoConsulta[1] = resultado.getInt("PartidasJugadas")+"";
                resultadoConsulta[2] = resultado.getInt("Victorias")+"";
                resultadoConsulta[3] = resultado.getInt("Derrotas")+"";
                resultadoConsulta[4] = resultado.getInt("Tablas")+"";

                resultado.close();

            }

        } catch (SQLException e) {

            System.out.println("Error en la consulta");
            System.out.println(e.getLocalizedMessage());

        }

        cerrar();

        return resultadoConsulta;

    }

    /**
     * Método que cierra la conexión
     */
    public void cerrar() {

        try {

            conexion.close(); // Cierra la conexion

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }

}
