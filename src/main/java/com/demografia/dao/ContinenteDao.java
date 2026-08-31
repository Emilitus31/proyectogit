package com.demografia.dao;

import com.demografia.modelo.Continente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContinenteDao implements IContinenteDao {
    private Connection conn;

    public ContinenteDao() {
        this.conn = com.demografia.config.Conexion.getConnection();
    }

    @Override
    public List<Continente> listar() {
        List<Continente> continentes = new ArrayList<>();
        String sql = "SELECT id, nombre FROM continentes";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Continente c = new Continente(
                		//Error: Con el constructor del modelo actualizado esta parte cambia
                		rs.getString("nombre"), 
                		rs.getInt("id"));
                continentes.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return continentes;
    }

    @Override
    public boolean insertar(Continente continente) {
        String sql = "INSERT INTO continentes (nombre) VALUES (?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, continente.getNombre());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(Continente continente) {
        String sql = "UPDATE continentes SET nombre=? WHERE id=?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, continente.getNombre());
            stmt.setInt(2, continente.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM continentes WHERE id=?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}