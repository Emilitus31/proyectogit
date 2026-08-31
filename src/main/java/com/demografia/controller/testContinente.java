package com.demografia.controller;

import com.demografia.dao.ContinenteDao;
import com.demografia.modelo.Continente;
import java.util.List;

public class testContinente {
    public static void main(String[] args) {
        ContinenteDao dao = new ContinenteDao();

        // Insertar continente
        Continente c = new Continente("Africa", 4); // Mantiene la lógica de nombres del original
        if (dao.insertar(c)) {
            System.out.println("Continente insertado correctamente.");
        }

        c.setNombre("Oceania");
        if (dao.insertar(c)) {
            System.out.println("Continente insertado correctamente.");
        }

        // Listar todos los continentes antes de eliminar
        System.out.println("Continentes antes de eliminar:");
        List<Continente> continentesAntes = dao.listar();
        for (Continente con : continentesAntes) {
            System.out.println(con.getId() + " - " + con.getNombre());
        }


        // 4. Actualizar continente
        if (dao != null) {
            c.setNombre("Africa actualizada");
            if (dao.actualizar(c)) {
                System.out.println("Continente actualizado correctamente.");
            } else {
                System.out.println("Error al actualizar continente");
            }
        }

        // Listar todos los continentes antes de eliminar
        System.out.println("Continentes antes de eliminar:");
        List<Continente> continentesDespuesActualizar = dao.listar();
        for (Continente con : continentesDespuesActualizar) {
            System.out.println(con.getId() + " - " + con.getNombre());
        }

        // Eliminar el continente recién insertado
        int idAEliminar = c.getId(); // Opción 1: si tu DAO no retorna id, tomamos el primero de la lista
        if (continentesAntes.size() > 0) {
            idAEliminar = continentesAntes.get(0).getId();
        }

        if (dao.eliminar(idAEliminar)) {
            System.out.println("Continente eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el continente.");
        }

        // Listar continentes después de eliminar
        System.out.println("Continentes después de eliminar:");
        List<Continente> continentesDespues = dao.listar();
        for (Continente con : continentesDespues) {
            System.out.println(con.getId() + " - " + con.getNombre());
        }
    }
}
