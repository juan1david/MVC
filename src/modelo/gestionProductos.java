package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class gestionProductos {
    private Conexion cnn = new Conexion();

    public boolean insertarProducto(Producto p) {
        boolean resultado = false;
        Producto pb = buscarReferencia(p.getReferencia());
        Connection conexion = null;
        PreparedStatement ps = null;
        try {
            if (pb == null) {
                conexion = cnn.Conecta();
                String sql = "INSERT INTO productos (Referencia, Nombre, Precio, Categoria) VALUES (?, ?, ?, ?);";
                ps = conexion.prepareStatement(sql);
                ps.setString(1, p.getReferencia());
                ps.setString(2, p.getNombre());
                ps.setFloat(3, p.getPrecio());
                ps.setInt(4, p.getCategoria());
                resultado = ps.executeUpdate() > 0;
            } else {
                System.out.println("El producto ya está registrado.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar: " + ex.getMessage());
        } finally {
            closeResources(ps, conexion);
        }
        return resultado;
    }

    public Producto buscarReferencia(String ref) {
        Producto p = null;
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            conexion = cnn.Conecta();
            String sql = "SELECT * FROM productos WHERE Referencia = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, ref);
            res = ps.executeQuery();
            if (res.next()) {
                p = new Producto(res.getString("Referencia"), res.getString("Nombre"), res.getFloat("Precio"), res.getInt("Categoria"));
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar: " + ex.getMessage());
        } finally {
            closeResources(ps, res, conexion);
        }
        return p;
    }

    public void buscarPorCategoria(Integer categoria) {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            conexion = cnn.Conecta();
            String sql = "SELECT * FROM productos WHERE Categoria = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, categoria);
            res = ps.executeQuery();
            boolean found = false;
            while (res.next()) {
                Producto p = new Producto(res.getString("Referencia"), res.getString("Nombre"), res.getFloat("Precio"), res.getInt("Categoria"));
                System.out.println(p);
                found = true;
            }
            if (!found) {
                System.out.println("No se encontraron productos para la categoría especificada.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar productos por categoría: " + ex.getMessage());
        } finally {
            closeResources(ps, res, conexion);
        }
    }

    private void closeResources(PreparedStatement ps, ResultSet res, Connection conexion) {
        try {
            if (res != null) res.close();
            if (ps != null) ps.close();
            if (conexion != null) conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar recursos: " + ex.getMessage());
        }
    }

    private void closeResources(PreparedStatement ps, Connection conexion) {
        closeResources(ps, null, conexion);
    }
}