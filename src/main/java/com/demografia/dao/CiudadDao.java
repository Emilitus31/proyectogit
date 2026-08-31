package com.demografia.dao;

import com.demografia.modelo.Ciudad;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CiudadDao implements ICiudadDao {
    private Connection conn;

    public CiudadDao() {
        this.conn = com.demografia.config.Conexion.getConnection(); 
    }

    @Override
    public List<Ciudad> listar() {
        List<Ciudad> ciudades = new ArrayList<>();
        String sql = "SELECT id, nombre FROM ciudades";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Ciudad c = new Ciudad(
                		//Error: Con el constructor del modelo actualizado esta parte cambia
                		rs.getString("nombre"), 
                		rs.getInt("id"), 
                		rs.getInt("paisId"));
                ciudades.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ciudades;
    }

    @Override
    public boolean insertar(Ciudad ciudad) {
        String sql = "INSERT INTO ciudades (nombre) VALUES (?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ciudad.getNombre());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(Ciudad ciudad) {
        String sql = "UPDATE ciudades SET nombre=? WHERE id=?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ciudad.getNombre());
            stmt.setInt(2, ciudad.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM ciudades WHERE id=?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}