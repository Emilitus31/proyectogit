package com.demografia.dao;
import com.demografia.modelo.Pais;
import java.util.List;
public interface IPaisDao {
	boolean insertar(Pais p);
	List<Pais> listar();
	boolean actualizar(Pais p);
	boolean eliminar(int id);
}
