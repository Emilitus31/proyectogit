package com.demografia.controller;

import com.demografia.dao.PaisDao;
import com.demografia.modelo.Pais;
import java.util.List;

public class testPais {
    public static void main(String[] args) {
        PaisDao dao = new PaisDao();

        // 1. Insertar país
        Pais p = new Pais("Jordania", 15, 46000000, 4); 
        if (dao.insertar(p)) {
            System.out.println("País insertado correctamente.");
        }

        p.setNombre("Mauritania");
        p.setPoblacion(214000000);
        if (dao.insertar(p)) {
            System.out.println("País insertado correctamente.");
        }

        // 2. Listar todos los países antes de eliminar
        System.out.println("Países antes de eliminar:");
        List<Pais> paisesAntes = dao.listar();
        for (Pais pais : paisesAntes) {
            System.out.println(pais.getId() + " - " + pais.getNombre() + " (" + pais.getpoblacion() + ")");
        }

        // 3. Actualizar país
        if (dao != null) {
            p.setNombre("Mauritania actualizado");
            if (dao.actualizar(p)) {
                System.out.println("País actualizado correctamente.");
            } else {
                System.out.println("Error al actualizar país");
            }
        }

        // 4. Listar todos los países después de actualizar
        System.out.println("Países después de actualizar:");
        List<Pais> paisesDespuesActualizar = dao.listar();
        for (Pais pais : paisesDespuesActualizar) {
            System.out.println(pais.getId() + " - " + pais.getNombre() + " (" + pais.getpoblacion() + ")");
        }

        // 5. Eliminar el país
        int idAEliminar = p.getId(); 
        if (paisesAntes.size() > 0) {
            idAEliminar = paisesAntes.get(0).getId();
        }

        if (dao.eliminar(idAEliminar)) {
            System.out.println("País eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el país.");
        }

        // 6. Listar países después de eliminar
        System.out.println("Países después de eliminar:");
        List<Pais> paisesDespues = dao.listar();
        for (Pais pais : paisesDespues) {
            System.out.println(pais.getId() + " - " + pais.getNombre());
        }
    }
}
