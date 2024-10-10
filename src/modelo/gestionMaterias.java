package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class gestionMaterias {
    private Connection conexion;

    public gestionMaterias() {
        this.conexion = new Conexion().Conecta(); // Conectar a la base de datos
    }

    public boolean agregarMateria(Materia materia) {
        String query = "INSERT INTO materias (codigo, nombre) VALUES (?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, materia.getCodigo());
            ps.setString(2, materia.getNombre());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al agregar materia: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarMateria(String codigo, String nuevoNombre) {
        String query = "UPDATE materias SET nombre = ? WHERE codigo = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, nuevoNombre);
            ps.setString(2, codigo);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar materia: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarMateria(String codigo) {
        String query = "DELETE FROM materias WHERE codigo = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, codigo);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar materia: " + e.getMessage());
            return false;
        }
    }

    public Materia buscarMateria(String codigo) {
        String query = "SELECT * FROM materias WHERE codigo = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Materia(rs.getString("codigo"), rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar materia: " + e.getMessage());
        }
        return null;
    }

    public void listarMaterias() {
        String query = "SELECT * FROM materias";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println(new Materia(rs.getString("codigo"), rs.getString("nombre")));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar materias: " + e.getMessage());
        }
    }
}
