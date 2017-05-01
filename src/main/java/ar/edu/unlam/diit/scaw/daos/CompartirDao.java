package ar.edu.unlam.diit.scaw.daos;

import java.util.LinkedList;

public interface CompartirDao {

	public boolean insertarColaborador(Integer idTarea,Integer idUsuario);
	
	public boolean eliminarColaborador(Integer idTarea,Integer idUsuario);
	
	public LinkedList<Integer> obtenerColaboradores(Integer idTarea);
	
}
