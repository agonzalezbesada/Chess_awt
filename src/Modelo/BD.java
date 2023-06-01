package Modelo;

import java.sql.*;
public class BD {

    public String bd = "chess";
    public String tabla = "jugadores";
    public Connection conexion = null;
    public String url = "jdbc:mysql://localhost:3306/chess";
    public String user = "root";
    public String password = "root";
    public Statement consulta = null;
    public Statement seleccion = null;

    public void conectar() {

        try {

            conexion = DriverManager.getConnection(url,user,password);
            System.out.println("Conexion exitosa");

        } catch (SQLException e) {

            System.out.println("Error en la conexion");
            System.out.println(e.getLocalizedMessage());

        }

    }

    public void modificar(String texto) {

        consulta = null;
        String textoConsulta = texto;

        try {

            consulta = conexion.createStatement();
            consulta.executeUpdate(textoConsulta);
            System.out.println("Consulta exitosa");

        } catch (SQLException e) {

            System.out.println("Error en la consulta");
            System.out.println(e.getLocalizedMessage());

        }

    }

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

    public boolean registrar(String textoModificacion) {

        conectar();

        Statement consulta = null; // Objeto que permite hacer las consultas

        try {

            consulta = conexion.createStatement();
            consulta.executeUpdate(textoModificacion); // Método para realizar la consulta
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

    public void cerrar() {

        try {

            conexion.close(); // Cierra la conexion

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }

}
