package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String db = "productos";
    private String url = "jdbc:mysql://localhost:3306/" + db;
    private String user = "root";
    private String pass = "0000";

    public Connection Conecta() {
        Connection conec = null;
        try {
            conec = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión exitosa.");
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
        return conec;
    }
}