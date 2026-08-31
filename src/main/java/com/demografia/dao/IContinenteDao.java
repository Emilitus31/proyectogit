package com.demografia.dao;
import com.demografia.modelo.Continente;
import java.util.List;
public interface IContinenteDao {
	boolean insertar(Continente c);
	List<Continente> listar();
	boolean actualizar(Continente c);
	boolean eliminar(int id);
}
