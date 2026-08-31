package com.demografia.dao;
import com.demografia.modelo.Ciudad;
import java.util.List;
public interface ICiudadDao {
	boolean insertar(Ciudad c);
	List<Ciudad> listar();
	boolean actualizar(Ciudad c);
	boolean eliminar(int id);
}
