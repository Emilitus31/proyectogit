package com.demografia.controller;

import com.demografia.dao.CiudadDao;
import com.demografia.modelo.Ciudad;
import java.util.List;

public class testCiudad {
    public static void main(String[] args) {
        CiudadDao dao = new CiudadDao();

        // 1. Insertar ciudad
        Ciudad c = new Ciudad("Lisbon", 29, 1); 
        if (dao.insertar(c)) {
            System.out.println("Ciudad insertada correctamente.");
        }

        c.setNombre("Rosario");
        if (dao.insertar(c)) {
            System.out.println("Ciudad insertada correctamente.");
        }

        // 2. Listar todas las ciudades antes de eliminar
        System.out.println("Ciudades antes de eliminar:");
        List<Ciudad> ciudadesAntes = dao.listar();
        for (Ciudad ciu : ciudadesAntes) {
            System.out.println(ciu.getId() + " - " + ciu.getNombre());
        }

        // 3. Actualizar ciudad
        if (dao != null) {
            c.setNombre("Rosario actualizada");
            if (dao.actualizar(c)) {
                System.out.println("Ciudad actualizada correctamente.");
            } else {
                System.out.println("Error al actualizar ciudad");
            }
        }

        // 4. Listar todas las ciudades después de actualizar
        System.out.println("Ciudades después de actualizar:");
        List<Ciudad> ciudadesDespuesActualizar = dao.listar();
        for (Ciudad ciu : ciudadesDespuesActualizar) {
            System.out.println(ciu.getId() + " - " + ciu.getNombre());
        }

        // 5. Eliminar la ciudad
        int idAEliminar = c.getId(); 
        if (ciudadesAntes.size() > 0) {
            idAEliminar = ciudadesAntes.get(0).getId();
        }

        if (dao.eliminar(idAEliminar)) {
            System.out.println("Ciudad eliminada correctamente.");
        } else {
            System.out.println("No se pudo eliminar la ciudad.");
        }

        // 6. Listar ciudades después de eliminar
        System.out.println("Ciudades después de eliminar:");
        List<Ciudad> ciudadesDespues = dao.listar();
        for (Ciudad ciu : ciudadesDespues) {
            System.out.println(ciu.getId() + " - " + ciu.getNombre());
        }
    }
}
