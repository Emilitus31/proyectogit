package com.demografia.dao;

import com.demografia.modelo.Pais;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaisDao implements IPaisDao {
    private Connection conn;

    public PaisDao() {
        this.conn = com.demografia.config.Conexion.getConnection();
    }

    @Override
    public List<Pais> listar() {
        List<Pais> paises = new ArrayList<>();
        String sql = "SELECT id, nombre, poblacion FROM paises";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
        		//Error: Con el constructor del modelo actualizado esta parte cambia
                Pais p = new Pais(
                    rs.getString("nombre"),
                    rs.getInt("id"),
                    rs.getInt("poblacion"),
                    rs.getInt("continenteId")
                );
                paises.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paises;
    }

    @Override
    public boolean insertar(Pais pais) {
        String sql = "INSERT INTO paises (nombre, poblacion) VALUES (?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pais.getNombre());
            stmt.setInt(2, pais.getpoblacion());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(Pais pais) {
        String sql = "UPDATE paises SET nombre=?, poblacion=? WHERE id=?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pais.getNombre());
            stmt.setInt(2, pais.getpoblacion());
            stmt.setInt(3, pais.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM paises WHERE id=?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}